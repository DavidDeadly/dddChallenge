package co.david.challengeddd.domain.faculty.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.david.challengeddd.domain.faculty.values.FacultyName;

import java.util.UUID;

public class FacultyCreated extends DomainEvent {

  private final FacultyName facultyName;

  public FacultyCreated(FacultyName facultyName) {
    super("david.faculty.FacultyCreated");
    this.facultyName = facultyName;
  }

  public FacultyName getFacultyName() {
    return facultyName;
  }

  public String getType() {
    return type;
  }
}
