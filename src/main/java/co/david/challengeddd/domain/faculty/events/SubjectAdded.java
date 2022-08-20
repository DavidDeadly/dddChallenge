package co.david.challengeddd.domain.faculty.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.david.challengeddd.domain.faculty.values.SubjectID;

public class SubjectAdded extends DomainEvent {

  private final SubjectID subjectID;

  public SubjectAdded(SubjectID subjectID) {
    super("david.faculty.SubjectAdded");
    this.subjectID = subjectID;
  }

  public SubjectID getSubjectID() {
    return subjectID;
  }
}
