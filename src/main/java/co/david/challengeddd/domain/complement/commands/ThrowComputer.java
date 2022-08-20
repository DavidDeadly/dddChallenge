package co.david.challengeddd.domain.complement.commands;

import co.com.sofka.domain.generic.Command;
import co.david.challengeddd.domain.complement.values.ComplementID;
import co.david.challengeddd.domain.complement.values.ComputerID;

public class ThrowComputer extends Command {

  private final ComplementID complementID;
  private final ComputerID computerID;

  public ThrowComputer(ComplementID complementID, ComputerID computerID) {
    this.complementID = complementID;
    this.computerID = computerID;
  }

  public ComplementID getComplementID() {
    return complementID;
  }

  public ComputerID getComputerID() {
    return computerID;
  }
}
