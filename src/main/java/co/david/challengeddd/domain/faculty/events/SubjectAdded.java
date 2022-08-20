package co.david.challengeddd.domain.faculty.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.david.challengeddd.domain.faculty.values.Points;
import co.david.challengeddd.domain.faculty.values.SubjectID;
import co.david.challengeddd.domain.faculty.values.SubjectName;
import co.david.challengeddd.domain.faculty.values.TotalHours;

public class SubjectAdded extends DomainEvent {

  private final SubjectID subjectID;
  private final SubjectName subjectName;
  private final Points points;
  private final TotalHours hours;

  public SubjectAdded(SubjectID subjectID, SubjectName subjectName, Points points, TotalHours hours) {
    super("david.faculty.SubjectAdded");
    this.subjectID = subjectID;
    this.subjectName = subjectName;
    this.points = points;
    this.hours = hours;
  }

  public SubjectName getSubjectName() {
    return subjectName;
  }

  public Points getPoints() {
    return points;
  }

  public TotalHours getHours() {
    return hours;
  }

  public SubjectID getSubjectID() {
    return subjectID;
  }
}
