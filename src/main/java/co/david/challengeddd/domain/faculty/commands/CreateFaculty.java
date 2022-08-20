package co.david.challengeddd.domain.faculty.commands;

import co.com.sofka.domain.generic.Command;
import co.david.challengeddd.domain.faculty.values.ActiveYears;
import co.david.challengeddd.domain.faculty.values.FacultyID;

public class CreateFaculty extends Command {

  private final FacultyID facultyID;
  private final String facultyName;
  private final ActiveYears activeYears;

  public CreateFaculty(FacultyID facultyID, String facultyName, ActiveYears activeYears) {
    this.facultyID = facultyID;
    this.facultyName = facultyName;
    this.activeYears = activeYears;
  }

  public ActiveYears getActiveYears() {
    return activeYears;
  }

  public FacultyID getFacultyID() {
    return facultyID;
  }

  public String getFacultyName() {
    return facultyName;
  }

}
