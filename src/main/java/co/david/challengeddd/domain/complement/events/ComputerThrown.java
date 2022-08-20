package co.david.challengeddd.domain.complement.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.david.challengeddd.domain.complement.values.ComputerID;

public class ComputerThrown extends DomainEvent {

  private final ComputerID computerID;

  public ComputerThrown(ComputerID computerID) {
    super("david.complement.ComputerThrown");
    this.computerID = computerID;
  }

  public ComputerID getComputerID() {
    return computerID;
  }
}
