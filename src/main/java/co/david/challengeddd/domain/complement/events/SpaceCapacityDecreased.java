package co.david.challengeddd.domain.complement.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.david.challengeddd.domain.complement.values.Capacity;
import co.david.challengeddd.domain.complement.values.SpaceID;

public class SpaceCapacityDecreased extends DomainEvent {

  private final SpaceID spaceID;
  private final Capacity capacity;

  public SpaceCapacityDecreased(SpaceID spaceID, Capacity capacity) {
    super("david.complement.SpaceCapacityDecreased");
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
