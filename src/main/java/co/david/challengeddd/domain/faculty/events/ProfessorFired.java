package co.david.challengeddd.domain.faculty.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.david.challengeddd.domain.faculty.values.DirectorID;
import co.david.challengeddd.domain.faculty.values.ProfessorID;

public class ProfessorFired extends DomainEvent {

  private final DirectorID directorID;
  private final ProfessorID professorID;

  public ProfessorFired(DirectorID directorID, ProfessorID professorID) {
    super("david.faculty.ProfessorFired");
    this.directorID = directorID;
    this.professorID = professorID;
  }

  public ProfessorID getProfessorID() {
    return professorID;
  }

  public DirectorID getDirectorID() {
    return directorID;
  }
}
