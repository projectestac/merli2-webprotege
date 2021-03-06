package edu.stanford.bmir.protege.web.shared.hierarchy;

import com.google.web.bindery.event.shared.Event;
import edu.stanford.bmir.protege.web.shared.project.ProjectId;
import org.semanticweb.owlapi.model.OWLDataProperty;

/**
 * Author: Matthew Horridge<br>
 * Stanford University<br>
 * Bio-Medical Informatics Research Group<br>
 * Date: 25/03/2013
 */
public class DataPropertyHierarchyParentRemovedEvent extends HierarchyChangedEvent<OWLDataProperty, DataPropertyHierarchyParentRemovedHandler> {

    public transient static final Event.Type<DataPropertyHierarchyParentRemovedHandler> TYPE = new Event.Type<DataPropertyHierarchyParentRemovedHandler>();

    public DataPropertyHierarchyParentRemovedEvent(ProjectId source, OWLDataProperty child, OWLDataProperty parent, HierarchyId hierarchyId) {
        super(source, child, parent, hierarchyId);
    }

    private DataPropertyHierarchyParentRemovedEvent() {
    }

    @Override
    public Event.Type<DataPropertyHierarchyParentRemovedHandler> getAssociatedType() {
        return TYPE;
    }

    @Override
    protected void dispatch(DataPropertyHierarchyParentRemovedHandler handler) {
        handler.handleDataPropertyHierarchyParentRemoved(this);
    }
}
