package edu.stanford.bmir.protege.web.client.editor;

import edu.stanford.bmir.protege.web.shared.dispatch.actions.GetClassFrameAction;
import edu.stanford.bmir.protege.web.shared.dispatch.actions.UpdateClassFrameAction;
import edu.stanford.bmir.protege.web.client.frame.ClassFrameEditor;
import edu.stanford.bmir.protege.web.shared.frame.LabelledFrame;
import edu.stanford.bmir.protege.web.shared.dispatch.UpdateObjectAction;
import edu.stanford.bmir.protege.web.shared.frame.ClassFrame;
import edu.stanford.bmir.protege.web.shared.frame.GetClassFrameResult;

import javax.inject.Inject;
import static edu.stanford.bmir.protege.web.client.Messages.MESSAGES;

/**
 * Author: Matthew Horridge<br>
 * Stanford University<br>
 * Bio-Medical Informatics Research Group<br>
 * Date: 23/04/2013
 */
public class ClassFrameEditorManager implements EditorManager<OWLEntityContext, LabelledFrame<ClassFrame>, GetClassFrameAction, GetClassFrameResult> {

    private ClassFrameEditor editor;

    @Inject
    public ClassFrameEditorManager(ClassFrameEditor editor) {
        this.editor = editor;
    }

    @Override
    public EditorView<LabelledFrame<ClassFrame>> getView(OWLEntityContext context) {
        return editor;
    }

    @Override
    public GetClassFrameAction createAction(OWLEntityContext editorContext) {
        return new GetClassFrameAction(editorContext.getEntity().asOWLClass(), editorContext.getProjectId());
    }

    @Override
    public LabelledFrame<ClassFrame> extractObject(GetClassFrameResult result) {
        return result.getFrame();
    }

    @Override
    public UpdateObjectAction<LabelledFrame<ClassFrame>> createUpdateObjectAction(LabelledFrame<ClassFrame> pristineObject, LabelledFrame<ClassFrame> editedObject, OWLEntityContext editorContext) {
        return new UpdateClassFrameAction(editorContext.getProjectId(), pristineObject, editedObject);
    }

    @Override
    public String getDescription(OWLEntityContext editorContext) {
        return "Class description";
    }
}
