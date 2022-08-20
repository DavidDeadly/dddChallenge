package co.david.challengeddd.domain.complement.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.david.challengeddd.domain.faculty.values.FacultyID;
import co.david.challengeddd.domain.faculty.values.FacultyName;

public class ComplementCreated extends DomainEvent {

  private final FacultyID facultyID;
  private final FacultyName facultyName;

  public ComplementCreated(FacultyID facultyID, FacultyName facultyName) {
    super("david.complement.ComplementCreated");
    this.facultyID = facultyID;
    this.facultyName = facultyName;
  }

  public FacultyID getFacultyID() {
    return facultyID;
  }

  public FacultyName getFacultyName() {
    return facultyName;
  }
}
