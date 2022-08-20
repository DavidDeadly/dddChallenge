package co.david.challengeddd.domain.complement.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.david.challengeddd.domain.faculty.values.FacultyName;

public class FacultyRenamed extends DomainEvent {

  private final FacultyName facultyName;

  public FacultyRenamed(FacultyName facultyName) {
    super("david.complement.FacultyRenamed");
    this.facultyName = facultyName;
  }

  public FacultyName getFacultyName() {
    return facultyName;
  }
}
