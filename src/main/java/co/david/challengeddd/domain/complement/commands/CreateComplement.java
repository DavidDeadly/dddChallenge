package co.david.challengeddd.domain.complement.commands;

import co.com.sofka.domain.generic.Command;
import co.david.challengeddd.domain.complement.values.ComplementID;
import co.david.challengeddd.domain.faculty.values.FacultyID;
import co.david.challengeddd.domain.faculty.values.FacultyName;

public class CreateComplement extends Command {

  private final ComplementID complementID;
  private final FacultyID facultyID;
  private final FacultyName facultyName;

  public CreateComplement(ComplementID complementID, FacultyID facultyID, FacultyName facultyName) {
    this.complementID = complementID;
    this.facultyID = facultyID;
    this.facultyName = facultyName;
  }

  public ComplementID getComplementID() {
    return complementID;
  }

  public FacultyID getFacultyID() {
    return facultyID;
  }

  public FacultyName getFacultyName() {
    return facultyName;
  }
}
