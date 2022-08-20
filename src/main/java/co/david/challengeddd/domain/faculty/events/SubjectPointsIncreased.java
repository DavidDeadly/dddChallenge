package co.david.challengeddd.domain.faculty.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.david.challengeddd.domain.faculty.values.Points;
import co.david.challengeddd.domain.faculty.values.SubjectID;

public class SubjectPointsIncreased extends DomainEvent {

  private final SubjectID subjectID;
  private final Points points;

  public SubjectPointsIncreased(SubjectID subjectID, Points points) {
    super("david.faculty.SubjectPointsIncreased");
    this.subjectID = subjectID;
    this.points = points;
  }

  public SubjectID getSubjectID() {
    return subjectID;
  }

  public Points getPoints() {
    return points;
  }
}
