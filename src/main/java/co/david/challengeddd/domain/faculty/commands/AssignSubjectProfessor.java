package co.david.challengeddd.domain.faculty.commands;

import co.com.sofka.domain.generic.Command;
import co.david.challengeddd.domain.faculty.values.FacultyID;
import co.david.challengeddd.domain.faculty.values.ProfessorID;
import co.david.challengeddd.domain.faculty.values.SubjectID;

public class AssignSubjectProfessor extends Command {

  private final FacultyID facultyID;
  private final SubjectID subjectID;
  private final ProfessorID professorID;

  public AssignSubjectProfessor(FacultyID facultyID, SubjectID subjectID, ProfessorID professorID) {
    this.facultyID = facultyID;
    this.subjectID = subjectID;
    this.professorID = professorID;
  }

  public FacultyID getFacultyID() {
    return facultyID;
  }

  public SubjectID getSubjectID() {
    return subjectID;
  }

  public ProfessorID getProfessorID() {
    return professorID;
  }
}
