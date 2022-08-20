package co.david.challengeddd.domain.faculty.commands;

import co.com.sofka.domain.generic.Command;
import co.david.challengeddd.domain.faculty.values.FacultyID;
import co.david.challengeddd.domain.faculty.values.ProfessorID;
import co.david.challengeddd.domain.faculty.values.YearOfExperience;

public class TurnProfessorExpertiseYears extends Command {

  private final FacultyID facultyID;
  private final ProfessorID professorID;
  private final YearOfExperience yearOfExperience;

  public TurnProfessorExpertiseYears(FacultyID facultyID, ProfessorID professorID, YearOfExperience yearOfExperience) {
    this.facultyID = facultyID;
    this.professorID = professorID;
    this.yearOfExperience = yearOfExperience;
  }

  public FacultyID getFacultyID() {
    return facultyID;
  }

  public ProfessorID getProfessorID() {
    return professorID;
  }

  public YearOfExperience getYearOfExperience() {
    return yearOfExperience;
  }
}
