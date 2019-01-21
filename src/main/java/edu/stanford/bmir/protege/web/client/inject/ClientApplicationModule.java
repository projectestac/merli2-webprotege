package edu.stanford.bmir.protege.web.client.inject;

import com.google.gwt.activity.shared.ActivityManager;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.place.shared.PlaceHistoryHandler;
import com.google.gwt.place.shared.PlaceHistoryMapper;
import com.google.web.bindery.event.shared.EventBus;
import dagger.Module;
import dagger.Provides;
import edu.stanford.bmir.protege.web.client.Messages;
import edu.stanford.bmir.protege.web.client.app.ApplicationSettingsView;
import edu.stanford.bmir.protege.web.client.app.ApplicationSettingsViewImpl;
import edu.stanford.bmir.protege.web.client.app.*;
import edu.stanford.bmir.protege.web.client.chgpwd.ResetPasswordView;
import edu.stanford.bmir.protege.web.client.chgpwd.ResetPasswordViewImpl;
import edu.stanford.bmir.protege.web.client.collection.*;
import edu.stanford.bmir.protege.web.client.dispatch.SignInRequiredHandler;
import edu.stanford.bmir.protege.web.client.dispatch.SignInRequiredHandlerImpl;
import edu.stanford.bmir.protege.web.client.entity.DeprecatedEntitiesView;
import edu.stanford.bmir.protege.web.client.entity.DeprecatedEntitiesViewImpl;
import edu.stanford.bmir.protege.web.client.filter.FilterView;
import edu.stanford.bmir.protege.web.client.filter.FilterViewImpl;
import edu.stanford.bmir.protege.web.client.form.FormElementView;
import edu.stanford.bmir.protege.web.client.form.FormElementViewImpl;
import edu.stanford.bmir.protege.web.client.help.*;
import edu.stanford.bmir.protege.web.client.issues.CommentedEntitiesView;
import edu.stanford.bmir.protege.web.client.issues.CommentedEntitiesViewImpl;
import edu.stanford.bmir.protege.web.client.login.LoginView;
import edu.stanford.bmir.protege.web.client.login.LoginViewImpl;
import edu.stanford.bmir.protege.web.client.login.SignInRequestHandler;
import edu.stanford.bmir.protege.web.client.login.SignInRequestHandlerImpl;
import edu.stanford.bmir.protege.web.client.logout.LogoutView;
import edu.stanford.bmir.protege.web.client.logout.LogoutViewImpl;
import edu.stanford.bmir.protege.web.client.pagination.PaginatorView;
import edu.stanford.bmir.protege.web.client.pagination.PaginatorViewImpl;
import edu.stanford.bmir.protege.web.client.perspective.*;
import edu.stanford.bmir.protege.web.client.place.*;
import edu.stanford.bmir.protege.web.client.portlet.PortletChooserView;
import edu.stanford.bmir.protege.web.client.portlet.PortletChooserViewImpl;
import edu.stanford.bmir.protege.web.client.portlet.PortletUi;
import edu.stanford.bmir.protege.web.client.portlet.PortletUiImpl;
import edu.stanford.bmir.protege.web.client.project.*;
import edu.stanford.bmir.protege.web.client.projectlist.AvailableProjectView;
import edu.stanford.bmir.protege.web.client.projectlist.AvailableProjectViewImpl;
import edu.stanford.bmir.protege.web.client.projectmanager.*;
import edu.stanford.bmir.protege.web.client.search.SearchView;
import edu.stanford.bmir.protege.web.client.search.SearchViewImpl;
import edu.stanford.bmir.protege.web.client.signup.SignUpView;
import edu.stanford.bmir.protege.web.client.signup.SignUpViewImpl;
import edu.stanford.bmir.protege.web.client.topbar.GoToHomeView;
import edu.stanford.bmir.protege.web.client.topbar.GoToToHomeViewImpl;
import edu.stanford.bmir.protege.web.client.topbar.TopBarView;
import edu.stanford.bmir.protege.web.client.topbar.TopBarViewImpl;
import edu.stanford.bmir.protege.web.client.user.*;
import edu.stanford.bmir.protege.web.resources.WebProtegeClientBundle;
import edu.stanford.bmir.protege.web.shared.auth.Md5MessageDigestAlgorithm;
import edu.stanford.bmir.protege.web.shared.auth.MessageDigestAlgorithm;
import edu.stanford.bmir.protege.web.shared.inject.ApplicationSingleton;

/**
 * Author: Matthew Horridge<br>
 * Stanford University<br>
 * Bio-Medical Informatics Research Group<br>
 * Date: 16/01/2014
 */
@Module
public class ClientApplicationModule {

    @Provides
    @ApplicationSingleton
    EventBus provideEventBus() {
        return new SimpleEventBus();
    }

    @Provides
    @ApplicationSingleton
    PlaceController providePlaceController(EventBus eventBus) {
        return new PlaceController(eventBus);
    }

    @Provides
    @ApplicationSingleton
    PlaceHistoryHandler providePlaceHistoryHandler(PlaceHistoryHandlerProvider provider) {
        return provider.get();
    }

    @Provides
    @ApplicationSingleton
    PlaceHistoryMapper providePlaceHistoryMapper(WebProtegePlaceHistoryMapper mapper) {
        return mapper;
    }

    @Provides
    @ApplicationSingleton
    WebProtegePlaceHistoryMapper provideWebProtegePlaceHistoryMapper() {
        return GWT.create(WebProtegePlaceHistoryMapper.class);
    }

    @Provides
    @ApplicationSingleton
    @Deprecated
    Messages provideMessages() {
        return Messages.MESSAGES;
    }

    @Provides
    @ApplicationSingleton
    WebProtegeClientBundle provideClientBundle() {
        WebProtegeClientBundle.BUNDLE.style().ensureInjected();
        return WebProtegeClientBundle.BUNDLE;
    }

    @Provides
    @ApplicationSingleton
    ActivityMapper provideActivityMapper(WebProtegeActivityMapper mapper) {
        mapper.start();
        return mapper;
    }

    @Provides
    @ApplicationSingleton
    ActivityManager provideActivityManager(WebProtegeActivityManager manager) {
        return manager;
    }

    @Provides
    ApplicationView provideApplicationView(ApplicationViewImpl applicationView) {
        return applicationView;
    }

    @Provides
    @ApplicationSingleton
    LoggedInUserProvider provideLoggedInUserProvider(LoggedInUser loggedInUser) {
        return loggedInUser;
    }

    @Provides
    @ApplicationSingleton
    SignInRequestHandler provideSignInRequestHandler(SignInRequestHandlerImpl impl) {
        return impl;
    }

    @Provides
    @ApplicationSingleton
    SignOutRequestHandler provideSignOutRequestHandler(SignOutRequestHandlerImpl impl) {
        return impl;
    }

    @Provides
    SignUpView provideSignUpView(SignUpViewImpl signUpView) {
        return signUpView;
    }

    @Provides
    @ApplicationSingleton
    SignInRequiredHandler provideSignInRequiredHandler(SignInRequiredHandlerImpl impl) {
        return impl;
    }

    @Provides
    @ApplicationSingleton
    ChangeEmailAddressHandler provideChangeEmailAddressHandler(ChangeEmailAddressHandlerImpl impl) {
        return impl;
    }

    @Provides
    @ApplicationSingleton
    ShowUserGuideHandler provideShowUserGuideHandler(ShowUserGuideHandlerImpl impl) {
        return impl;
    }

    @Provides
    @ApplicationSingleton
    ChangePasswordHandler provideChangePasswordHandler(ChangePasswordHandlerImpl impl) {
        return impl;
    }

    @Provides
    @ApplicationSingleton
    ShowAboutBoxHandler provideShowAboutBoxHandler(ShowAboutBoxHandlerImpl impl) {
        return impl;
    }

    @Provides
    TopBarView provideTopBarView(TopBarViewImpl impl) {
        return impl;
    }

    @Provides
    ProjectManagerView provideProjectManagerView(ProjectManagerViewImpl impl) {
        return impl;
    }

    @Provides
    AvailableProjectView projectDetailsView(AvailableProjectViewImpl impl) {
        return impl;
    }

    @Provides
    LoadProjectRequestHandler providesLoadProjectRequestHandler(LoadProjectRequestHandlerImpl impl) {
        return impl;
    }

    @Provides
    LoadProjectInNewWindowRequestHandler providesLoadProjectInNewWindowRequestHandler(LoadProjectInNewWindowRequestHandlerImpl impl) {
        return impl;
    }

    @Provides
    DownloadProjectRequestHandler provideDownloadProjectRequestHandler(DownloadProjectRequestHandlerImpl impl) {
        return impl;
    }

    @Provides
    TrashManagerRequestHandler provideTrashManagerRequestHandler(TrashManagerRequestHandlerImpl impl) {
        return impl;
    }

    @Provides
    LoginView provideLoginView(LoginViewImpl loginView) {
        return loginView;
    }

    @Provides
    LogoutView provideLogoutView(LogoutViewImpl logoutView) {
        return logoutView;
    }

    @Provides
    ResetPasswordView provideResetPasswordView(ResetPasswordViewImpl resetPasswordView) {
        return resetPasswordView;
    }

    @Provides
    LoggedInUserView provideLoggedInUserView(LoggedInUserViewImpl loggedInUserView) {
        return loggedInUserView;
    }

    @Provides
    HelpView provideHelpView(HelpViewImpl helpView) {
        return helpView;
    }

    @Provides
    GoToHomeView provideGoToHomeView(GoToToHomeViewImpl goToToHomeView) {
        return goToToHomeView;
    }

    @Provides
    MessageDigestAlgorithm provideMessageDigestAlgorithm(Md5MessageDigestAlgorithm algorithm) {
        return algorithm;
    }

    @Provides
    PerspectiveSwitcherView providePerspectiveSwitcherView(PerspectiveSwitcherViewImpl view) {
        return view;
    }

    @Provides
    PerspectiveView providePerspectiveView(PerspectiveViewImpl view) {
        return view;
    }

    @Provides
    CreateFreshPerspectiveRequestHandler provideCreateFreshPerspectiveRequestHandler(CreateFreshPerspectiveRequestHandlerImpl handler) {
        return handler;
    }

    @Provides
    EmptyPerspectiveView provideEmptyPerspectiveView(EmptyPerspectiveViewImpl view) {
        return view;
    }

    @Provides
    ForbiddenView provideForbiddenView(ForbiddenViewImpl view) {
        return view;
    }

    @Provides
    ProjectMenuView provideProjectMenuView(ProjectMenuViewImpl view) {
        return view;
    }

    @Provides
    PortletChooserView providePortletChooserView(PortletChooserViewImpl view) {
        return view;
    }

    @Provides
    ProjectView provideProjectView(ProjectViewImpl view) {
        return view;
    }

    @Provides
    ActiveProjectManager provideActiveProjectManager(ActiveProjectManagerImpl manager) {
        return manager;
    }

    @Provides
    FilterView provideFilterView(FilterViewImpl filterView) {
        return filterView;
    }

    @Provides
    PaginatorView providePaginatorView(PaginatorViewImpl view) {
        return view;
    }

    @Provides
    PortletUi providePortletUi(PortletUiImpl portletUi) {
        return portletUi;
    }

    @Provides
    CreateProjectRequestHandler provideCreateProjectRequestHandler(CreateProjectRequestHandlerImpl impl) {
        return impl;
    }

    @Provides
    CommentedEntitiesView provideCommentedEntitiesView(CommentedEntitiesViewImpl impl) {
        return impl;
    }

    @Provides
    ApplicationSettingsView provideAdminView(ApplicationSettingsViewImpl impl) {
        return impl;
    }

    @Provides
    NothingSelectedView provideNothingSelectedView(NothingSelectedViewImpl impl) {
        return impl;
    }

    @Provides
    SearchView providesSearchView(SearchViewImpl impl) {
        return impl;
    }

    @Provides
    DeprecatedEntitiesView provideDeprecatedEntitiesView(DeprecatedEntitiesViewImpl impl) {
        return impl;
    }

    @Provides
    FormElementView provideFormElementView(FormElementViewImpl impl) {
        return impl;
    }

    @Provides
    CollectionView provideCollectionView(CollectionViewImpl impl) {
        return impl;
    }

    @Provides
    CollectionItemListView provideCollectionElementsListView(CollectionItemListViewImpl impl) {
        return impl;
    }

    @Provides
    AddCollectionItemPrompt providesAddCollectionItemPrompt(AddCollectionItemPromptImpl impl) {
        return impl;
    }

    @Provides
    WindowTitleUpdater providesWindowTitleUpdater(WindowTitleUpdaterImpl impl) {
        return impl;
    }

    @Provides
    CreateNewProjectView providesCreateNewProjectView(CreateNewProjectViewImpl impl) {
        return impl;
    }
}
