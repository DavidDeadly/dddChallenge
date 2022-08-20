package co.david.challengeddd.domain.faculty.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.david.challengeddd.domain.faculty.values.ProfessorID;
import co.david.challengeddd.domain.faculty.values.SubjectID;

public class SubjectProfessorAssign extends DomainEvent {

  private final SubjectID subjectID;
  private final ProfessorID professorID;

  public SubjectProfessorAssign(SubjectID subjectID, ProfessorID professorID) {
    super("david.faculty.SubjectProfessorAssign");
    this.subjectID = subjectID;
    this.professorID = professorID;
  }

  public SubjectID getSubjectID() {
    return subjectID;
  }

  public ProfessorID getProfessorID() {
    return professorID;
  }
}
