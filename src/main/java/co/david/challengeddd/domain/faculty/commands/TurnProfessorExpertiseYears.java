package co.david.challengeddd.domain.faculty.commands;

import co.com.sofka.domain.generic.Command;
import co.david.challengeddd.domain.faculty.values.FacultyID;
import co.david.challengeddd.domain.faculty.values.ProfessorID;
import co.david.challengeddd.domain.faculty.values.YearsOfExperience;

public class TurnProfessorExpertiseYears extends Command {

  private final FacultyID facultyID;
  private final ProfessorID professorID;
  private final YearsOfExperience yearsOfExperience;

  public TurnProfessorExpertiseYears(FacultyID facultyID, ProfessorID professorID, YearsOfExperience yearsOfExperience) {
    this.facultyID = facultyID;
    this.professorID = professorID;
    this.yearsOfExperience = yearsOfExperience;
  }

  public FacultyID getFacultyID() {
    return facultyID;
  }

  public ProfessorID getProfessorID() {
    return professorID;
  }

  public YearsOfExperience getYearOfExperience() {
    return yearsOfExperience;
  }
}
