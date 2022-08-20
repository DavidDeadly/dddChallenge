package co.david.challengeddd.domain.faculty.commands;

import co.com.sofka.domain.generic.Command;
import co.david.challengeddd.domain.faculty.values.FacultyID;
import co.david.challengeddd.domain.faculty.values.ProfessorID;
import co.david.challengeddd.domain.faculty.values.Title;

public class AddProfessorTitle extends Command {

  private final FacultyID facultyID;
  private final ProfessorID professorID;
  private final Title title;

  public AddProfessorTitle(FacultyID facultyID, ProfessorID professorID, Title title) {
    this.facultyID = facultyID;
    this.professorID = professorID;
    this.title = title;
  }

  public FacultyID getFacultyID() {
    return facultyID;
  }

  public ProfessorID getProfessorID() {
    return professorID;
  }

  public Title getTitle() {
    return title;
  }
}
