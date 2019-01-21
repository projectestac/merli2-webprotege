package edu.stanford.bmir.protege.web.client.hierarchy;

import com.google.gwt.view.client.SelectionChangeEvent;
import edu.stanford.bmir.protege.web.client.action.UIAction;
import edu.stanford.bmir.protege.web.shared.dispatch.actions.CreateClassesAction;
import edu.stanford.bmir.protege.web.client.library.dlg.WebProtegeDialog;
import edu.stanford.bmir.protege.web.client.portlet.AbstractWebProtegePortletPresenter;
import edu.stanford.bmir.protege.web.client.portlet.PortletAction;
import edu.stanford.bmir.protege.web.client.portlet.PortletUi;
import edu.stanford.bmir.protege.web.client.search.SearchDialogController;
import edu.stanford.bmir.protege.web.client.watches.WatchPresenter;
import edu.stanford.bmir.protege.web.shared.event.WebProtegeEventBus;
import edu.stanford.bmir.protege.web.shared.hierarchy.EntityHierarchyNode;
import edu.stanford.bmir.protege.web.shared.project.ProjectId;
import edu.stanford.bmir.protege.web.shared.selection.SelectionModel;
import edu.stanford.protege.gwt.graphtree.client.TreeWidget;
import edu.stanford.protege.gwt.graphtree.shared.Path;
import edu.stanford.protege.gwt.graphtree.shared.tree.impl.GraphTreeNodeModel;
import edu.stanford.webprotege.shared.annotations.Portlet;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLEntity;

import javax.annotation.Nonnull;
import javax.inject.Inject;
import java.util.Optional;

import static com.google.common.base.Preconditions.checkNotNull;
import static edu.stanford.bmir.protege.web.client.Messages.MESSAGES;
import static edu.stanford.bmir.protege.web.shared.access.BuiltInAction.*;
import static edu.stanford.bmir.protege.web.shared.hierarchy.HierarchyId.CLASS_HIERARCHY;
import static edu.stanford.protege.gwt.graphtree.shared.tree.RevealMode.REVEAL_FIRST;
import static org.semanticweb.owlapi.model.EntityType.CLASS;


@SuppressWarnings("Convert2MethodRef")
@Portlet(id = "portlets.ClassHierarchy",
        title = "Class Hierarchy",
        tooltip = "Displays the class hierarchy as a tree.")
public class ClassHierarchyPortletPresenter extends AbstractWebProtegePortletPresenter {

    private final WatchPresenter watchPresenter;

    private final SearchDialogController searchDialogController;

    private final EntityHierarchyModel hierarchyModel;
    @Nonnull
    private final EntityHierarchyTreeNodeRenderer renderer;

    private final UIAction createClassAction;

    private final UIAction watchClassAction;

    private final UIAction deleteClassAction;

    private final UIAction searchAction;

    @Nonnull
    private final CreateEntityPresenter createEntityPresenter;

    @Nonnull
    private final DeleteEntityPresenter deleteEntityPresenter;

    @Nonnull
    private final EntityHierarchyContextMenuPresenterFactory contextMenuPresenterFactory;

    @Nonnull
    private final HierarchyActionStatePresenter actionStatePresenter;

    @Nonnull
    private final TreeWidget<EntityHierarchyNode, OWLEntity> treeWidget;

    @Nonnull
    private final EntityHierarchyDropHandler dropHandler;

    private boolean transmittingSelectionFromTree = false;

    @Inject
    public ClassHierarchyPortletPresenter(@Nonnull final ProjectId projectId,
                                          @Nonnull SelectionModel selectionModel,
                                          @Nonnull WatchPresenter watchPresenter,
                                          @Nonnull SearchDialogController searchDialogController,
                                          @Nonnull EntityHierarchyModel hierarchyModel,
                                          @Nonnull EntityHierarchyContextMenuPresenterFactory contextMenuPresenterFactory,
                                          @Nonnull TreeWidget<EntityHierarchyNode, OWLEntity> treeWidget,
                                          @Nonnull EntityHierarchyTreeNodeRenderer renderer,
                                          @Nonnull CreateEntityPresenter createEntityPresenter,
                                          @Nonnull DeleteEntityPresenter deleteEntityPresenter,
                                          @Nonnull HierarchyActionStatePresenter actionStatePresenter,
                                          @Nonnull EntityHierarchyDropHandler dropHandler) {
        super(selectionModel, projectId);
        this.watchPresenter = checkNotNull(watchPresenter);
        this.searchDialogController = checkNotNull(searchDialogController);
        this.hierarchyModel = checkNotNull(hierarchyModel);
        this.contextMenuPresenterFactory = checkNotNull(contextMenuPresenterFactory);
        this.treeWidget = checkNotNull(treeWidget);
        this.renderer = checkNotNull(renderer);
        this.createEntityPresenter = checkNotNull(createEntityPresenter);

        this.createClassAction = new PortletAction(MESSAGES.create(),
                                                   this::handleCreateSubClasses);

        this.deleteClassAction = new PortletAction(MESSAGES.delete(),
                                                   this::handleDelete);

        this.watchClassAction = new PortletAction(MESSAGES.watch(),
                                                  this::handleEditWatches);

        this.searchAction = new PortletAction(MESSAGES.search(),
                                              this::handleSearch);
        this.deleteEntityPresenter = deleteEntityPresenter;
        this.actionStatePresenter = actionStatePresenter;
        this.dropHandler = dropHandler;


        this.treeWidget.addSelectionChangeHandler(this::transmitSelectionFromTree);
    }

    @Override
    protected void handleAfterSetEntity(Optional<OWLEntity> entityData) {
        setSelectionInTree(entityData);
    }

    @Override
    public void startPortlet(@Nonnull PortletUi portletUi,
                             @Nonnull WebProtegeEventBus eventBus) {
        portletUi.addAction(createClassAction);
        portletUi.addAction(deleteClassAction);
        portletUi.addAction(watchClassAction);
        portletUi.addAction(searchAction);
        portletUi.setWidget(treeWidget);

        actionStatePresenter.registerAction(CREATE_CLASS, createClassAction);
        actionStatePresenter.registerAction(DELETE_CLASS, deleteClassAction);
        actionStatePresenter.registerAction(WATCH_CHANGES, watchClassAction);

        actionStatePresenter.start(eventBus);

        hierarchyModel.start(eventBus, CLASS_HIERARCHY);
        treeWidget.setRenderer(renderer);
        treeWidget.setModel(GraphTreeNodeModel.create(hierarchyModel,
                                                      node -> node.getEntity()));

        treeWidget.setDropHandler(this.dropHandler);
        dropHandler.start(CLASS_HIERARCHY);
        contextMenuPresenterFactory.create(hierarchyModel,
                                           treeWidget,
                                           createClassAction,
                                           deleteClassAction)
                                   .install();
        setSelectionInTree(getSelectedEntity());
    }

    private Optional<OWLClass> getFirstSelectedClass() {
        return treeWidget.getFirstSelectedKey()
                         .filter(sel -> sel instanceof OWLClass)
                         .map(sel -> (OWLClass) sel);
    }

    private void transmitSelectionFromTree(SelectionChangeEvent event) {
        try {
            transmittingSelectionFromTree = true;
            treeWidget.getFirstSelectedKey()
                      .ifPresent(sel -> getSelectionModel().setSelection(sel));
            if (!treeWidget.getFirstSelectedKey().isPresent()) {
                getSelectionModel().clearSelection();
            }
        } finally {
            transmittingSelectionFromTree = false;
        }
    }

    private void handleCreateSubClasses() {
        createEntityPresenter.createEntities(CLASS,
                                             treeWidget, (projectId, browserText) ->
                                                     new CreateClassesAction(projectId,
                                                                             browserText,
                                                                             getFirstSelectedClass())
        );
    }

    private void handleDelete() {
        deleteEntityPresenter.start(treeWidget);
    }

    private void handleSearch() {
        searchDialogController.setEntityTypes(CLASS);
        WebProtegeDialog.showDialog(searchDialogController);
    }

    private void selectAndExpandPath(Path<OWLEntity> entityPath) {
        treeWidget.setSelected(entityPath, true, () -> treeWidget.setExpanded(entityPath));
    }


    protected void handleEditWatches() {
        final Optional<OWLEntity> sel = treeWidget.getFirstSelectedKey();
        sel.ifPresent(watchPresenter::start);
    }

    private void setSelectionInTree(Optional<OWLEntity> selection) {
        if (transmittingSelectionFromTree) {
            return;
        }
        selection.ifPresent(sel -> {
            if (sel.isOWLClass()) {
                treeWidget.revealTreeNodesForKey(sel, REVEAL_FIRST);
            }
        });
    }
}
