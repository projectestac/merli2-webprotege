package edu.stanford.bmir.protege.web.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.i18n.client.LocalizableResource.DefaultLocale;
import com.google.gwt.i18n.client.LocalizableResource;
import java.util.Date;


/**
 * {@inheritDoc}
 */
@DefaultLocale("en")
@LocalizableResource.Generate(
  format =   "com.google.gwt.i18n.server.PropertyCatalogFactory",
  locales =  "default"
)
@LocalizableResource.GenerateKeys(
  value =    "com.google.gwt.i18n.server.keygen.MD5KeyGenerator"
)
public interface Messages extends com.google.gwt.i18n.client.Messages {

    /** Instance of this interface */
    public static final Messages MESSAGES = GWT.create(Messages.class);


    @DefaultMessage("About")
    @Key("about")
    String about();


    @DefaultMessage("Add tab")
    @Key("addTab")
    String addTab();


    @DefaultMessage("Changes on {0}")
    @Key("change.changesOn")
    String change_changesOn(String date);


    @DefaultMessage("Showing {0,number} of {1,number} changes")
    @Key("change.showingChanges")
    String change_showingChanges(Number count, Number total);


    @DefaultMessage("Plus {0,number} more changes not shown here")
    @AlternateMessage({"one", "Plus one more change not shown here"})
    @Key("change.plusHidden")
    String change_plusHidden(@PluralCount int count);


    @DefaultMessage("Download revision")
    @Key("change.downloadRevision")
    String change_downloadRevision();


    @DefaultMessage("You do not have permission to view changes in this")
    @Key("change.permissionDenied")
    String change_permissionDenied();


    @DefaultMessage("Revert")
    @Key("change.revert")
    String change_revert();


    @DefaultMessage("Revert changes in revision")
    @Key("change.revertChangesInRevision")
    String change_revertChangesInRevision();


    @DefaultMessage("Do you want to revert the changes in this revision?")
    @Key("change.revertChangesInRevisionQuestion")
    String change_revertChangesInRevisionQuestion();


    @DefaultMessage("Revert Changes?")
    @Key("change.revertChangesQuestion")
    String change_revertChangesQuestion();


    @DefaultMessage("Change Email Address")
    @Key("changeEmailAddress")
    String changeEmailAddress();


    @DefaultMessage("Change Password")
    @Key("changePassword")
    String changePassword();


    @DefaultMessage("Change Email Address")
    @Key("dialog.title.changeEmailAddress")
    String dialog_title_changeEmailAddress();


    @DefaultMessage("Change Password")
    @Key("dialog.title.changePassword")
    String dialog_title_changePassword();


    @DefaultMessage("Choose view")
    @Key("dialog.title.chooseView")
    String dialog_title_chooseView();


    @DefaultMessage("Upload ontologies")
    @Key("dialog.title.uploadOntologies")
    String dialog_title_uploadOntologies();


    @DefaultMessage("Reset password")
    @Key("dialog.title.resetPassword")
    String dialog_title_resetPassword();


    @DefaultMessage("Search")
    @Key("dialog.title.search")
    String dialog_title_search();


    @DefaultMessage("Select the type of watch")
    @Key("dialog.title.selectWatch")
    String dialog_title_selectWatch();


    @DefaultMessage("Changes by Entity")
    @Key("changesByEntity")
    String changesByEntity();


    @DefaultMessage("Class IRI")
    @Key("classIri")
    String classIri();


    @DefaultMessage("Classes")
    @Key("classes")
    String classes();


    @DefaultMessage("Comments")
    @Key("comments")
    String comments();


    @DefaultMessage("by")
    @Key("comments.by")
    String comments_by();


    @DefaultMessage("Comment")
    @Key("comments.comment")
    String comments_comment();


    @DefaultMessage("Commented entities")
    @Key("comments.commentedEntities")
    String comments_commentedEntities();


    @DefaultMessage("Last comment")
    @Key("comments.lastComment")
    String comments_lastComment();


    @DefaultMessage("resolved")
    @Key("comments.resolved")
    String comments_resolved();


    @DefaultMessage("unresolved")
    @Key("comments.unresolved")
    String comments_unresolved();


    @DefaultMessage("Create")
    @Key("create")
    String create();


    @DefaultMessage("Enter one name per line (press CTRL+ENTER to accept and close panel)")
    @Key("createEntityInstructions")
    String createEntityInstructions();


    @DefaultMessage("Create New Project")
    @Key("createProject")
    String createProject();


    @DefaultMessage("Delete")
    @Key("delete")
    String delete();


    @DefaultMessage("Are you sure you want to delete the {0} \"{1}\"?")
    @Key("delete.entity.msg")
    String delete_entity_msg(String arg0,  String arg1);


    @DefaultMessage("Delete {0}")
    @Key("delete.entity.title")
    String delete_entity_title(String arg0);


    @DefaultMessage("Delete")
    @Key("deleteComment")
    String deleteComment();


    @DefaultMessage("Are you sure that you want to delete this comment?  This cannot be undone.")
    @Key("deleteCommentConfirmationBoxText")
    String deleteCommentConfirmationBoxText();


    @DefaultMessage("Delete Comment?")
    @Key("deleteCommentConfirmationBoxTitle")
    String deleteCommentConfirmationBoxTitle();


    @DefaultMessage("Apply")
    @Key("dialog.apply")
    String dialog_apply();


    @DefaultMessage("Cancel")
    @Key("dialog.cancel")
    String dialog_cancel();


    @DefaultMessage("Close")
    @Key("dialog.close")
    String dialog_close();


    @DefaultMessage("No")
    @Key("dialog.no")
    String dialog_no();


    @DefaultMessage("OK")
    @Key("dialog.ok")
    String dialog_ok();


    @DefaultMessage("Select")
    @Key("dialog.select")
    String dialog_select();


    @DefaultMessage("Yes")
    @Key("dialog.yes")
    String dialog_yes();


    @DefaultMessage("Direct Link")
    @Key("directLink")
    String directLink();


    @DefaultMessage("Display resolved threads")
    @Key("discussionThread.DisplayResolvedThreads")
    String discussionThread_DisplayResolvedThreads();


    @DefaultMessage("Re-open")
    @Key("discussionThread.Reopen")
    String discussionThread_Reopen();


    @DefaultMessage("Resolve")
    @Key("discussionThread.Resolve")
    String discussionThread_Resolve();


    @DefaultMessage("You do not have permission to view comments in this project")
    @Key("discussionThread.ViewingForbidden")
    String discussionThread_ViewingForbidden();


    @DefaultMessage("Download")
    @Key("download")
    String download();


    @DefaultMessage("Edit")
    @Key("editComment")
    String editComment();


    @DefaultMessage("Enter search string to filter list")
    @Key("enterSearchStringToFilterList")
    String enterSearchStringToFilterList();


    @DefaultMessage("Error")
    @Key("error")
    String error();


    @DefaultMessage("An error has occurred.  Please refresh your browser and try again.")
    @Key("error.anErrorHasOccurred")
    String error_anErrorHasOccurred();


    @DefaultMessage("WebProtégé cannot connect to the server.  Please check your network connection.")
    @Key("error.connectionError.msg")
    String error_connectionError_msg();


    @DefaultMessage("Connection Error")
    @Key("error.connectionError.title")
    String error_connectionError_title();


    @DefaultMessage("An error has occurred.  Please refresh your browser and try again.")
    @Key("error.general")
    String error_general();


    @DefaultMessage("You do not have permission to carry out the specified action.")
    @Key("error.permissionError.msg")
    String error_permissionError_msg();


    @DefaultMessage("Permission Denied")
    @Key("error.permissionError.title")
    String error_permissionError_title();


    @DefaultMessage("Please refresh your browser")
    @Key("error.refreshBrowser")
    String error_refreshBrowser();


    @DefaultMessage("Server Error")
    @Key("error.serverError")
    String error_serverError();


    @DefaultMessage("Status Code")
    @Key("error.statusCode")
    String error_statusCode();


    @DefaultMessage("WebProtégé has been upgraded.  Please refresh your browser.")
    @Key("error.upgraded")
    String error_upgraded();


    @DefaultMessage("WebProtégé has encountered an error.  Please try again.")
    @Key("error.webProtegeHasEncounteredAnErrorPleaseTryAgain")
    String error_webProtegeHasEncounteredAnErrorPleaseTryAgain();


    @DefaultMessage("Forbidden")
    @Key("forbidden")
    String forbidden();


    @DefaultMessage("Forgot username or password")
    @Key("forgotUserNameOrPassword")
    String forgotUserNameOrPassword();


    @DefaultMessage("Annotations")
    @Key("frame.annotations")
    String frame_annotations();


    @DefaultMessage("Classes")
    @Key("frame.classes")
    String frame_classes();


    @DefaultMessage("Domain")
    @Key("frame.domain")
    String frame_domain();


    @DefaultMessage("Enter a class name")
    @Key("frame.enterAClassName")
    String frame_enterAClassName();


    @DefaultMessage("Enter a datatype name")
    @Key("frame.enterADatatype")
    String frame_enterADatatype();


    @DefaultMessage("Enter an individual name")
    @Key("frame.enterIndividualName")
    String frame_enterIndividualName();


    @DefaultMessage("Enter property")
    @Key("frame.enterProperty")
    String frame_enterProperty();


    @DefaultMessage("Enter value")
    @Key("frame.enterValue")
    String frame_enterValue();


    @DefaultMessage("Functional")
    @Key("frame.functional")
    String frame_functional();


    @DefaultMessage("lang")
    @Key("frame.lang")
    String frame_lang();


    @DefaultMessage("Range")
    @Key("frame.range")
    String frame_range();


    @DefaultMessage("Relationships")
    @Key("frame.relationships")
    String frame_relationships();


    @DefaultMessage("Same As")
    @Key("frame.sameIndividual")
    String frame_sameIndividual();


    @DefaultMessage("Single valued")
    @Key("frame.singleValued")
    String frame_singleValued();


    @DefaultMessage("Transitive")
    @Key("frame.transitive")
    String frame_transitive();


    @DefaultMessage("Types")
    @Key("frame.types")
    String frame_types();


    @DefaultMessage("Help")
    @Key("help")
    String help();


    @DefaultMessage("Annotation Properties")
    @Key("hierarchy.annotationproperties")
    String hierarchy_annotationproperties();


    @DefaultMessage("Data Properties")
    @Key("hierarchy.dataproperties")
    String hierarchy_dataproperties();


    @DefaultMessage("Object Properties")
    @Key("hierarchy.objectproperties")
    String hierarchy_objectproperties();


    @DefaultMessage("History")
    @Key("history")
    String history();


    @DefaultMessage("Home")
    @Key("home")
    String home();


    @DefaultMessage("Individuals")
    @Key("individuals")
    String individuals();


    @DefaultMessage("instance")
    @Key("instance")
    String instance();


    @DefaultMessage("IRI")
    @Key("iri")
    String iri();


    @DefaultMessage("Last modified")
    @Key("lastModified")
    String lastModified();


    @DefaultMessage("Last opened")
    @Key("lastOpened")
    String lastOpened();


    @DefaultMessage("Last updated")
    @Key("lastUpdated")
    String lastUpdated();


    @DefaultMessage("Please enter your password.")
    @Key("login.enterPassword")
    String login_enterPassword();


    @DefaultMessage("Please enter your user name.")
    @Key("login.enterUserName")
    String login_enterUserName();


    @DefaultMessage("Unable to log in.  User name or password is incorrect.")
    @Key("login.error")
    String login_error();


    @DefaultMessage("Markdown supported")
    @Key("markdownSupported")
    String markdownSupported();


    @DefaultMessage("Move to Trash")
    @Key("moveToTrash")
    String moveToTrash();


    @DefaultMessage("New Entity Settings")
    @Key("newEntitySettings")
    String newEntitySettings();


    @DefaultMessage("Digit count")
    @Key("newEntitySettings.digitCount")
    String newEntitySettings_digitCount();


    @DefaultMessage("IRI Prefix")
    @Key("newEntitySettings.iriPrefix")
    String newEntitySettings_iriPrefix();


    @DefaultMessage("IRI Suffix")
    @Key("newEntitySettings.iriSuffix")
    String newEntitySettings_iriSuffix();


    @DefaultMessage("Auto-generated OBO Style Id")
    @Key("newEntitySettings.oboId")
    String newEntitySettings_oboId();


    @DefaultMessage("Spaces")
    @Key("newEntitySettings.spaces")
    String newEntitySettings_spaces();


    @DefaultMessage("Collapse and transform to camel case")
    @Key("newEntitySettings.spaces.collapseAndTransformToCamelCase")
    String newEntitySettings_spaces_collapseAndTransformToCamelCase();


    @DefaultMessage("Replace with dashes")
    @Key("newEntitySettings.spaces.replaceWithDashes")
    String newEntitySettings_spaces_replaceWithDashes();


    @DefaultMessage("Replace with underscores")
    @Key("newEntitySettings.spaces.replaceWithUnderscores")
    String newEntitySettings_spaces_replaceWithUnderscores();


    @DefaultMessage("Supplied name")
    @Key("newEntitySettings.suppliedName")
    String newEntitySettings_suppliedName();


    @DefaultMessage("User specific ranges")
    @Key("newEntitySettings.userSpecificRanges")
    String newEntitySettings_userSpecificRanges();


    @DefaultMessage("Auto-generated Universally Unique Id (UUID)")
    @Key("newEntitySettings.uuid")
    String newEntitySettings_uuid();


    @DefaultMessage("New topic")
    @Key("newTopic")
    String newTopic();


    @DefaultMessage("Nothing selected")
    @Key("nothingSelected")
    String nothingSelected();


    @DefaultMessage("Open")
    @Key("open")
    String open();


    @DefaultMessage("Open in New Window")
    @Key("openInNewWindow")
    String openInNewWindow();


    @DefaultMessage("Owned by Me")
    @Key("ownedByMe")
    String ownedByMe();


    @DefaultMessage("Owner")
    @Key("owner")
    String owner();


    @DefaultMessage("Password")
    @Key("password")
    String password();


    @DefaultMessage("Password reset error")
    @Key("password.reset.error.generic.msg")
    String password_reset_error_generic_msg();


    @DefaultMessage("An error occurred. Please contact the administrator.")
    @Key("password.reset.error.generic.submsg")
    String password_reset_error_generic_submsg();


    @DefaultMessage("Invalid email address.")
    @Key("password.reset.error.invalidemail.msg")
    String password_reset_error_invalidemail_msg();


    @DefaultMessage("The email address that you supplied is not valid.  Your password has not been reset.")
    @Key("password.reset.error.invalidemail.submsg")
    String password_reset_error_invalidemail_submsg();


    @DefaultMessage("Your password has been reset")
    @Key("password.reset.success.msg")
    String password_reset_success_msg();


    @DefaultMessage("A temporary password has been sent to your email address.")
    @Key("password.reset.success.submsg")
    String password_reset_success_submsg();


    @DefaultMessage("Reset Password")
    @Key("password.resetPassword")
    String password_resetPassword();


    @DefaultMessage("Add blank tab")
    @Key("perspective.addBlankTab")
    String perspective_addBlankTab();


    @DefaultMessage("Add view")
    @Key("perspective.addView")
    String perspective_addView();


    @DefaultMessage("Close")
    @Key("perspective.close")
    String perspective_close();


    @DefaultMessage("Reset")
    @Key("perspective.reset")
    String perspective_reset();


    @DefaultMessage("Project")
    @Key("project")
    String project();


    @DefaultMessage("Click to open")
    @Key("project.click-to-open")
    String project_ClickToOpen();


    @DefaultMessage("Download")
    @Key("project.download")
    String project_Download();


    @DefaultMessage("Open")
    @Key("project.open")
    String project_Open();


    @DefaultMessage("Open in new window")
    @Key("project.open-in-window")
    String project_OpenInWindow();


    @DefaultMessage("Move to trash")
    @Key("project.trash")
    String project_Trash();


    @DefaultMessage("Remove from trash")
    @Key("project.untrash")
    String project_Untrash();


    @DefaultMessage("Project description")
    @Key("projectDescription")
    String projectDescription();


    @DefaultMessage("Project Feed")
    @Key("projectFeed")
    String projectFeed();


    @DefaultMessage("Project History")
    @Key("projectHistory")
    String projectHistory();


    @DefaultMessage("Project name")
    @Key("projectName")
    String projectName();


    @DefaultMessage("Please enter a project name")
    @Key("projectNameMissingErrorMessage")
    String projectNameMissingErrorMessage();


    @DefaultMessage("Loading project. Please wait.")
    @Key("projectPresenter.loading")
    String projectPresenter_loading();


    @DefaultMessage("Description")
    @Key("projectSettings.description")
    String projectSettings_description();


    @DefaultMessage("Display name")
    @Key("projectSettings.displayName")
    String projectSettings_displayName();


    @DefaultMessage("Main Settings")
    @Key("projectSettings.mainSettings")
    String projectSettings_mainSettings();


    @DefaultMessage("Payload URLs")
    @Key("projectSettings.payloadUrls")
    String projectSettings_payloadUrls();


    @DefaultMessage("Slack Integration")
    @Key("projectSettings.slackIntegration")
    String projectSettings_slackIntegration();


    @DefaultMessage("Slack Webhook URL")
    @Key("projectSettings.slackWebHookUrl")
    String projectSettings_slackWebHookUrl();


    @DefaultMessage("Project Settings")
    @Key("projectSettings.title")
    String projectSettings_title();


    @DefaultMessage("Web Hooks")
    @Key("projectSettings.webHooks")
    String projectSettings_webHooks();


    @DefaultMessage("Projects")
    @Key("projects")
    String projects();


    @DefaultMessage("Properties")
    @Key("properties")
    String properties();


    @DefaultMessage("Property IRI")
    @Key("propertyIri")
    String propertyIri();


    @DefaultMessage("Refresh")
    @Key("refresh")
    String refresh();


    @DefaultMessage("Refresh Tree")
    @Key("refreshTree")
    String refreshTree();


    @DefaultMessage("Reply")
    @Key("replyToComment")
    String replyToComment();


    @DefaultMessage("Search")
    @Key("search")
    String search();


    @DefaultMessage("Search for Class")
    @Key("search.class")
    String search_class();


    @DefaultMessage("Search for {0}")
    @Key("search.searchFor")
    String search_searchFor(String type);


    @DefaultMessage("Enter text to search for (multi-word search supported)")
    @Key("search.hint")
    String search_hint();


    @DefaultMessage("Settings")
    @Key("settings")
    String settings();


    @DefaultMessage("Share")
    @Key("share")
    String share();


    @DefaultMessage("Shared with Me")
    @Key("sharedWithMe")
    String sharedWithMe();


    @DefaultMessage("Anyone with the link can")
    @Key("sharing.anyoneWithTheLinkCan")
    String sharing_anyoneWithTheLinkCan();


    @DefaultMessage("Comment")
    @Key("sharing.comment")
    String sharing_comment();


    @DefaultMessage("Edit")
    @Key("sharing.edit")
    String sharing_edit();


    @DefaultMessage("Link sharing enabled")
    @Key("sharing.linkSharingEnabled")
    String sharing_linkSharingEnabled();


    @DefaultMessage("Manage")
    @Key("sharing.manage")
    String sharing_manage();


    @DefaultMessage("Share with specific people")
    @Key("sharing.shareWithSpecificPeople")
    String sharing_shareWithSpecificPeople();


    @DefaultMessage("Sharing Settings")
    @Key("sharing.sharingSettings")
    String sharing_sharingSettings();


    @DefaultMessage("Sign-in Required")
    @Key("sharing.signInRequired")
    String sharing_signInRequired();


    @DefaultMessage("View")
    @Key("sharing.view")
    String sharing_view();


    @DefaultMessage("Show Direct Link")
    @Key("showDirectLink")
    String showDirectLink();


    @DefaultMessage("Show IRI")
    @Key("showIri")
    String showIri();


    @DefaultMessage("Showing {0,number} of {1,number} instances")
    @AlternateMessage({"one", "Showing one instance"})
    @Key("showingInstances")
    String showingInstances(int count, @PluralCount int total);


    @DefaultMessage("Sign In")
    @Key("signIn")
    String signIn();


    @DefaultMessage("Please sign in to continue")
    @Key("signInToContinue")
    String signInToContinue();


    @DefaultMessage("Sign Out")
    @Key("signOut")
    String signOut();


    @DefaultMessage("Sign up for account")
    @Key("signUpForAccount")
    String signUpForAccount();


    @DefaultMessage("Sort by Entity")
    @Key("sortByEntity")
    String sortByEntity();


    @DefaultMessage("Sort by Last Modified")
    @Key("sortByLastModified")
    String sortByLastModified();


    @DefaultMessage("Sort by Last Opened")
    @Key("sortByLastOpened")
    String sortByLastOpened();


    @DefaultMessage("Sort by Last Updated")
    @Key("sortByLastUpdated")
    String sortByLastUpdated();


    @DefaultMessage("Sort by Owner")
    @Key("sortByOwner")
    String sortByOwner();


    @DefaultMessage("Sort by Project Name")
    @Key("sortByProjectName")
    String sortByProjectName();


    @DefaultMessage("Start new thread")
    @Key("startNewCommentThread")
    String startNewCommentThread();


    @DefaultMessage("days ago")
    @Key("time.daysAgo")
    String time_daysAgo();


    @DefaultMessage("hours ago")
    @Key("time.hoursAgo")
    String time_hoursAgo();


    @DefaultMessage("Less than one minute ago")
    @Key("time.lessThanOneMinuteAgo")
    String time_lessThanOneMinuteAgo();


    @DefaultMessage("minutes ago")
    @Key("time.minutesAgo")
    String time_minutesAgo();


    @DefaultMessage("Trash")
    @Key("trash")
    String trash();


    @DefaultMessage("Clear pruning")
    @Key("tree.clearPruning")
    String tree_clearPruning();


    @DefaultMessage("Prune all branches to root")
    @Key("tree.pruneAllBranchesToRoot")
    String tree_pruneAllBranchesToRoot();


    @DefaultMessage("Prune branch to root")
    @Key("tree.pruneBranchToRoot")
    String tree_pruneBranchToRoot();


    @DefaultMessage("Upload and Merge")
    @Key("uploadAndMerge")
    String uploadAndMerge();


    @DefaultMessage("Upload Project")
    @Key("uploadProject")
    String uploadProject();


    @DefaultMessage("Username")
    @Key("userName")
    String userName();


    @DefaultMessage("View Projects")
    @Key("viewProjects")
    String viewProjects();


    @DefaultMessage("Watch")
    @Key("watch")
    String watch();


    @DefaultMessage("Refresh")
    @Key("watcher.refresh")
    String watcher_Refresh();
}
