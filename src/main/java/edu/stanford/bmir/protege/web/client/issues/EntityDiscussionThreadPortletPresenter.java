package edu.stanford.bmir.protege.web.client.issues;

import edu.stanford.bmir.protege.web.client.action.UIAction;
import edu.stanford.bmir.protege.web.client.filter.FilterView;
import edu.stanford.bmir.protege.web.client.permissions.LoggedInUserProjectPermissionChecker;
import edu.stanford.bmir.protege.web.client.portlet.AbstractWebProtegePortletPresenter;
import edu.stanford.bmir.protege.web.client.portlet.PortletAction;
import edu.stanford.bmir.protege.web.client.portlet.PortletUi;
import edu.stanford.bmir.protege.web.shared.event.WebProtegeEventBus;
import edu.stanford.bmir.protege.web.shared.filter.FilterId;
import edu.stanford.bmir.protege.web.shared.permissions.PermissionsChangedEvent;
import edu.stanford.bmir.protege.web.shared.project.ProjectId;
import edu.stanford.bmir.protege.web.shared.selection.SelectionModel;
import edu.stanford.webprotege.shared.annotations.Portlet;
import org.semanticweb.owlapi.model.OWLEntity;

import javax.annotation.Nonnull;
import javax.inject.Inject;
import java.util.Optional;

import static edu.stanford.bmir.protege.web.client.Messages.MESSAGES;
import static edu.stanford.bmir.protege.web.shared.access.BuiltInAction.VIEW_OBJECT_COMMENT;
import static edu.stanford.bmir.protege.web.shared.filter.FilterSetting.OFF;
import static edu.stanford.bmir.protege.web.shared.filter.FilterSetting.ON;
import static edu.stanford.bmir.protege.web.shared.permissions.PermissionsChangedEvent.ON_PERMISSIONS_CHANGED;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 5 Oct 2016
 */
@Portlet(id = "portlets.Comments", title = "Comments", tooltip = "Displays comments for the selected entity")
public class EntityDiscussionThreadPortletPresenter extends AbstractWebProtegePortletPresenter {

    @Nonnull
    private final FilterId displayResolvedThreadsFilter;

    @Nonnull
    private final DiscussionThreadListPresenter presenter;

    @Nonnull
    private final LoggedInUserProjectPermissionChecker permissionChecker;

    @Nonnull
    private final UIAction addCommentAction;

    @Nonnull
    private final FilterView filterView;

    private Optional<PortletUi> portletUi = Optional.empty();



    @Inject
    public EntityDiscussionThreadPortletPresenter(@Nonnull SelectionModel selectionModel,
                                                  @Nonnull FilterView filterView,
                                                  @Nonnull LoggedInUserProjectPermissionChecker permissionChecker,
                                                  @Nonnull ProjectId projectId,
                                                  @Nonnull DiscussionThreadListPresenter presenter) {
        super(selectionModel, projectId);
        this.filterView = filterView;
        this.displayResolvedThreadsFilter = new FilterId(MESSAGES.discussionThread_DisplayResolvedThreads());
        filterView.addFilter(displayResolvedThreadsFilter, OFF);
        filterView.addValueChangeHandler(event -> handleFilterSettingChanged());
        this.presenter = presenter;
        this.permissionChecker = permissionChecker;
        this.addCommentAction = new PortletAction(MESSAGES.startNewCommentThread(),
                                                  presenter::createThread);
    }

    @Override
    public void startPortlet(PortletUi portletUi, WebProtegeEventBus eventBus) {
        eventBus.addProjectEventHandler(getProjectId(),
                                        ON_PERMISSIONS_CHANGED,
                                        this::handlePemissionsChange);
        this.portletUi = Optional.of(portletUi);
        portletUi.setWidget(presenter.getView());
        portletUi.addAction(addCommentAction);
        addCommentAction.setEnabled(false);
        portletUi.setFilterView(filterView);
        portletUi.setForbiddenMessage(MESSAGES.discussionThread_ViewingForbidden());
        presenter.setHasBusy(portletUi);
        presenter.start(eventBus);
        presenter.setEntityDisplay(this);
        handleSetEntity(getSelectedEntity());
    }

    private void handleFilterSettingChanged() {
        boolean displayResolvedThreads = filterView.getFilterSet()
                  .getFilterSetting(displayResolvedThreadsFilter, OFF) == ON;
        presenter.setDisplayResolvedThreads(displayResolvedThreads);
    }

    private void handlePemissionsChange(PermissionsChangedEvent event) {
        handleAfterSetEntity(Optional.empty());
    }

    @Override
    protected void handleAfterSetEntity(Optional<OWLEntity> entity) {
        handleSetEntity(entity);
    }

    private void handleSetEntity(Optional<OWLEntity> entity) {
        addCommentAction.setEnabled(entity.isPresent());
        portletUi.ifPresent(portletUi -> {
            permissionChecker.hasPermission(VIEW_OBJECT_COMMENT, canViewComments -> {
                portletUi.setForbiddenVisible(!canViewComments);
                if(canViewComments) {
                    if(entity.isPresent()) {
                        presenter.setEntity(entity.get());
                    }
                    else {
                        presenter.clear();
                        setDisplayedEntity(Optional.empty());
                    }
                }
            });
        });

    }
}
