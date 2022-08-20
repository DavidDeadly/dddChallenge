package co.david.challengeddd.domain.faculty.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.david.challengeddd.domain.faculty.values.ActiveYears;
import co.david.challengeddd.domain.faculty.values.FacultyName;

public class FacultyCreated extends DomainEvent {

  private final FacultyName facultyName;
  private final ActiveYears activeYears;


  public FacultyCreated(FacultyName facultyName, ActiveYears activeYears) {
    super("david.faculty.FacultyCreated");
    this.facultyName = facultyName;
    this.activeYears = activeYears;
  }

  public ActiveYears getActiveYears() {
    return activeYears;
  }
  public FacultyName getFacultyName() {
    return facultyName;
  }

  public String getType() {
    return type;
  }
}
