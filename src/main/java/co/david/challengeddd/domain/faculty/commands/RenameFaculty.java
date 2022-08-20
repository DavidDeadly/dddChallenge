package co.david.challengeddd.domain.faculty.commands;

import co.com.sofka.domain.generic.Command;
import co.david.challengeddd.domain.faculty.values.FacultyID;
import co.david.challengeddd.domain.faculty.values.FacultyName;

public class RenameFaculty extends Command {

  private final FacultyID facultyID;
  private final FacultyName facultyName;

  public RenameFaculty(FacultyID facultyID, FacultyName facultyName) {
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
