package edu.stanford.bmir.protege.web.client.projectlist;

import com.google.auto.factory.AutoFactory;
import com.google.auto.factory.Provided;
import edu.stanford.bmir.protege.web.client.action.AbstractUiAction;
import edu.stanford.bmir.protege.web.client.projectmanager.DownloadProjectRequestHandler;
import edu.stanford.bmir.protege.web.client.projectmanager.LoadProjectInNewWindowRequestHandler;
import edu.stanford.bmir.protege.web.client.projectmanager.LoadProjectRequestHandler;
import edu.stanford.bmir.protege.web.client.projectmanager.TrashManagerRequestHandler;
import edu.stanford.bmir.protege.web.shared.project.AvailableProject;
import edu.stanford.bmir.protege.web.shared.project.ProjectId;
import edu.stanford.bmir.protege.web.client.ui.TimeFormatter;
import edu.stanford.bmir.protege.web.shared.user.UserId;

import javax.annotation.Nonnull;
import javax.inject.Inject;

import static com.google.common.base.Preconditions.checkNotNull;
import static edu.stanford.bmir.protege.web.client.Messages.MESSAGES;
import static edu.stanford.bmir.protege.web.shared.project.AvailableProject.UNKNOWN;


/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 19/02/16
 */
@AutoFactory
public class AvailableProjectPresenter {

    @Nonnull
    private final AvailableProjectView view;

    @Nonnull
    private final AvailableProject project;

    @Nonnull
    private final TrashManagerRequestHandler trashManagerRequestHandler;

    @Nonnull
    private final LoadProjectRequestHandler loadProjectRequestHandler;

    @Nonnull
    private final DownloadProjectRequestHandler downloadProjectRequestHandler;

    @Nonnull
    private LoadProjectInNewWindowRequestHandler loadProjectInNewWindowRequestHandler;

    @Inject
    public AvailableProjectPresenter(@Nonnull AvailableProject project,
                                     @Provided @Nonnull AvailableProjectView view,
                                     @Provided @Nonnull LoadProjectInNewWindowRequestHandler loadProjectInNewWindowRequestHandler,
                                     @Provided @Nonnull TrashManagerRequestHandler trashManagerRequestHandler,
                                     @Provided @Nonnull LoadProjectRequestHandler loadProjectRequestHandler,
                                     @Provided @Nonnull DownloadProjectRequestHandler downloadProjectRequestHandler) {
        this.view = checkNotNull(view);
        this.project = checkNotNull(project);
        this.loadProjectInNewWindowRequestHandler = checkNotNull(loadProjectInNewWindowRequestHandler);
        this.trashManagerRequestHandler = checkNotNull(trashManagerRequestHandler);
        this.loadProjectRequestHandler = checkNotNull(loadProjectRequestHandler);
        this.downloadProjectRequestHandler = checkNotNull(downloadProjectRequestHandler);
    }

    public void start() {
        view.setProject(project.getProjectId(), project.getDisplayName());
        view.setProjectOwner(project.getOwner());
        String lastOpenedAt;
        if(project.getLastOpenedAt() != UNKNOWN) {
            lastOpenedAt = TimeFormatter.get().toTimeAgo(project.getLastOpenedAt());
        }
        else {
            lastOpenedAt = "";
        }
        view.setLastOpenedAt(lastOpenedAt);

        long modifiedAtTs = project.getLastModifiedAt();
        String modifiedAt;
        if(modifiedAtTs != UNKNOWN) {
            modifiedAt = TimeFormatter.get().toTimeAgo(modifiedAtTs);
        }
        else {
            modifiedAt = "";
        }
        view.setModifiedAt(modifiedAt);
        view.setDescription(project.getDescription());
        view.setInTrash(project.isInTrash());
        view.setLoadProjectRequestHandler(loadProjectRequestHandler);
        addActions();
    }

    public ProjectId getProjectId() {
        return project.getProjectId();
    }

    public UserId getOwner() {
        return project.getOwner();
    }

    @Nonnull
    public AvailableProjectView getView() {
        return view;
    }

    private void addActions() {
        addOpenAction();
        addOpenInNewWindowAction();
        addDowloadAction();
        addTrashAction();
    }

    private void addOpenAction() {
        view.addAction(new AbstractUiAction(MESSAGES.project_Open()) {
            @Override
            public void execute() {
                loadProjectRequestHandler.handleProjectLoadRequest(project.getProjectId());
            }
        });
    }

    private void addOpenInNewWindowAction() {
        view.addAction(new AbstractUiAction(MESSAGES.project_OpenInWindow()) {
            @Override
            public void execute() {
                loadProjectInNewWindowRequestHandler.handleLoadProjectInNewWindow(project.getProjectId());
            }
        });
    }

    private void addDowloadAction() {
        AbstractUiAction downloadAction = new AbstractUiAction(MESSAGES.project_Download()) {
            @Override
            public void execute() {
                downloadProjectRequestHandler.handleProjectDownloadRequest(project.getProjectId());
            }
        };
        downloadAction.setEnabled(project.isDownloadable());
        view.addAction(downloadAction);
    }

    private void addTrashAction() {
        String trashActionLabel;
        if(project.isInTrash()) {
            trashActionLabel = MESSAGES.project_Untrash();
        }
        else {
            trashActionLabel = MESSAGES.project_Trash();
        }
        AbstractUiAction trashAction = new AbstractUiAction(trashActionLabel) {
            @Override
            public void execute() {
                if (project.isInTrash()) {
                    trashManagerRequestHandler.handleRemoveProjectFromTrash(project.getProjectId());
                }
                else {
                    trashManagerRequestHandler.handleMoveProjectToTrash(project.getProjectId());
                }
            }
        };
        view.addAction(trashAction);
        trashAction.setEnabled(project.isTrashable());
    }


}
