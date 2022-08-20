package co.david.challengeddd.domain.complement.commands;

import co.com.sofka.domain.generic.Command;
import co.david.challengeddd.domain.complement.values.ComplementID;
import co.david.challengeddd.domain.faculty.values.FacultyName;

public class RenameFaculty extends Command {

  private final ComplementID complementID;
  private final FacultyName facultyName;

  public RenameFaculty(ComplementID complementID, FacultyName facultyName) {
    this.complementID = complementID;
    this.facultyName = facultyName;
  }

  public ComplementID getComplementID() {
    return complementID;
  }

  public FacultyName getFacultyName() {
    return facultyName;
  }
}
