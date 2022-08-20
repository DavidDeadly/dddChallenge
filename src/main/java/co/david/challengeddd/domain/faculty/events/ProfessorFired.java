package co.david.challengeddd.domain.faculty.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.david.challengeddd.domain.faculty.values.DirectorID;

public class ProfessorFired extends DomainEvent {

  private final DirectorID directorID;

  public ProfessorFired(DirectorID directorID) {
    super("david.faculty.ProfessorFired");
    this.directorID = directorID;
  }

  public DirectorID getDirectorID() {
    return directorID;
  }
}
