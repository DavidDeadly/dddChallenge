package co.david.challengeddd.domain.complement.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.david.challengeddd.domain.complement.values.Capacity;
import co.david.challengeddd.domain.complement.values.SpaceID;

public class SpaceCapacityIncreased extends DomainEvent {

  private final SpaceID spaceID;
  private final Capacity capacity;

  public SpaceCapacityIncreased(SpaceID spaceID, Capacity capacity) {
    super("david.complement.SpaceCapacityIncreased");
    this.spaceID = spaceID;
    this.capacity = capacity;
  }

  public SpaceID getSpaceID() {
    return spaceID;
  }

  public Capacity getCapacity() {
    return capacity;
  }
}
