package co.david.challengeddd.domain.faculty.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.david.challengeddd.domain.faculty.values.ProfessorID;

public class ProfessorHired extends DomainEvent {

  private final ProfessorID professorID;

  public ProfessorHired(ProfessorID professorID) {
    super("david.faculty.ProfessorHired");
    this.professorID = professorID;
  }

  public ProfessorID getProfessorID() {
    return professorID;
  }
}
