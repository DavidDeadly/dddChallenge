package co.david.challengeddd.domain.complement.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.david.challengeddd.domain.complement.values.ComputerID;

public class ComputerBuyed extends DomainEvent {

  private final ComputerID computerID;

  public ComputerBuyed(ComputerID computerID) {
    super("david.complement.ComputerBuyed");
    this.computerID = computerID;
  }

  public ComputerID getComputerID() {
    return computerID;
  }
}
