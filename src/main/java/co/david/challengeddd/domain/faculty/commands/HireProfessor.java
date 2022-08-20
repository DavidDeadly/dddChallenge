package co.david.challengeddd.domain.faculty.commands;

import co.com.sofka.domain.generic.Command;
import co.david.challengeddd.domain.faculty.values.FacultyID;
import co.david.challengeddd.domain.faculty.values.ProfessorID;

public class HireProfessor extends Command {

  private final FacultyID facultyID;
  private final ProfessorID professorID;

  public HireProfessor(FacultyID facultyID, ProfessorID professorID) {
    this.facultyID = facultyID;
    this.professorID = professorID;
  }

  public FacultyID getFacultyID() {
    return facultyID;
  }

  public ProfessorID getProfessorID() {
    return professorID;
  }
}
