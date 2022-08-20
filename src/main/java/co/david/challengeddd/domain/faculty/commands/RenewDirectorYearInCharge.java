package co.david.challengeddd.domain.faculty.commands;

import co.com.sofka.domain.generic.Command;
import co.david.challengeddd.domain.faculty.values.DirectorID;
import co.david.challengeddd.domain.faculty.values.FacultyID;
import co.david.challengeddd.domain.faculty.values.YearsInCharge;

public class RenewDirectorYearInCharge extends Command {

  private final FacultyID facultyID;
  private final DirectorID directorID;
  private final YearsInCharge yearsInCharge;

  public RenewDirectorYearInCharge(FacultyID facultyID, DirectorID directorID, YearsInCharge yearsInCharge) {
    this.facultyID = facultyID;
    this.directorID = directorID;
    this.yearsInCharge = yearsInCharge;
  }

  public FacultyID getFacultyID() {
    return facultyID;
  }

  public DirectorID getDirectorID() {
    return directorID;
  }

  public YearsInCharge getYearsInCharge() {
    return yearsInCharge;
  }
}
