package co.david.challengeddd.domain.faculty.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.david.challengeddd.domain.faculty.values.DirectorID;

public class DirectorAssigned extends DomainEvent {

  private final DirectorID directorID;

  public DirectorAssigned(DirectorID directorID) {
    super("david.faculty.DirectorAssigned");
    this.directorID = directorID;
  }

  public DirectorID getDirectorID() {
    return directorID;
  }
}
