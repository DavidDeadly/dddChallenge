package co.david.challengeddd.domain.faculty.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.david.challengeddd.domain.faculty.values.SubjectID;

public class SubjectRemoved extends DomainEvent {

  private final SubjectID subjectID;

  public SubjectRemoved(SubjectID subjectID) {
    super("david.faculty.SubjectRemoved");
    this.subjectID = subjectID;
  }

  public SubjectID getSubjectID() {
    return subjectID;
  }
}
