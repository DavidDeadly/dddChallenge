package co.david.challengeddd.domain.complement.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.david.challengeddd.domain.complement.values.SpaceID;

public class SpaceRegistered extends DomainEvent {

  private final SpaceID spaceID;

  public SpaceRegistered(SpaceID spaceID) {
    super("david.complement.SpaceRegistered");
    this.spaceID = spaceID;
  }

  public SpaceID getSpaceID() {
    return spaceID;
  }
}
