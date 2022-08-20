package co.david.challengeddd.domain.complement.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.david.challengeddd.domain.complement.values.Capacity;
import co.david.challengeddd.domain.complement.values.SpaceID;
import co.david.challengeddd.domain.complement.values.SpaceName;

public class SpaceRegistered extends DomainEvent {

  private final SpaceID spaceID;
  private final SpaceName spaceName;
  private final Capacity capacity;


  public SpaceRegistered(SpaceID spaceID, SpaceName spaceName, Capacity capacity) {
    super("david.complement.SpaceRegistered");
    this.spaceID = spaceID;
    this.spaceName = spaceName;
    this.capacity = capacity;
  }

  public SpaceName getSpaceName() {
    return spaceName;
  }

  public Capacity getCapacity() {
    return capacity;
  }

  public SpaceID getSpaceID() {
    return spaceID;
  }
}
