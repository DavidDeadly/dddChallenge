package co.david.challengeddd.domain.faculty.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.david.challengeddd.domain.faculty.values.SubjectID;
import co.david.challengeddd.domain.faculty.values.TotalHours;

public class SubjectTotalHoursAdded extends DomainEvent {

  private final SubjectID subjectID;
  private final TotalHours totalHours;

  public SubjectTotalHoursAdded(SubjectID subjectID, TotalHours totalHours) {
    super("david.faculty.SubjectTotalHoursAdded");
    this.subjectID = subjectID;
    this.totalHours = totalHours;
  }

  public SubjectID getSubjectID() {
    return subjectID;
  }

  public TotalHours getTotalHours() {
    return totalHours;
  }
}
