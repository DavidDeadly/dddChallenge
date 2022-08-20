package co.david.challengeddd.domain.faculty.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.david.challengeddd.domain.faculty.values.DirectorID;

public class DirectorFired extends DomainEvent {

  private final DirectorID directorID;

  public DirectorFired(DirectorID directorID) {
    super("david.faculty.DirectorFired");
    this.directorID = directorID;
  }

  public DirectorID getDirectorID() {
    return directorID;
  }
}
