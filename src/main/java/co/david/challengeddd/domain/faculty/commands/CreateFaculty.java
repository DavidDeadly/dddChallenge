package co.david.challengeddd.domain.faculty.commands;

import co.com.sofka.domain.generic.Command;
import co.david.challengeddd.domain.faculty.values.FacultyID;

public class CreateFaculty extends Command {

  private final FacultyID facultyID;
  private final String facultyName;

  public CreateFaculty(FacultyID facultyID, String facultyName) {
    this.facultyID = facultyID;
    this.facultyName = facultyName;
  }

  public FacultyID getFacultyID() {
    return facultyID;
  }

  public String getFacultyName() {
    return facultyName;
  }

}
