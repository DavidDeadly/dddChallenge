package co.david.challengeddd.domain.faculty.commands;

import co.com.sofka.domain.generic.Command;
import co.david.challengeddd.domain.faculty.values.ActiveYears;
import co.david.challengeddd.domain.faculty.values.FacultyID;

public class RenewActiveYears extends Command {

  private final FacultyID facultyID;
  private final ActiveYears activeYears;

  public RenewActiveYears(FacultyID facultyID, ActiveYears activeYears) {
    this.facultyID = facultyID;
    this.activeYears = activeYears;
  }

  public FacultyID getFacultyID() {
    return facultyID;
  }

  public ActiveYears getActiveYears() {
    return activeYears;
  }
}
