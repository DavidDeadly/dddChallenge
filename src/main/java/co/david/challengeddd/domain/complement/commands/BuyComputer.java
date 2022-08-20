package co.david.challengeddd.domain.complement.commands;

import co.com.sofka.domain.generic.Command;
import co.david.challengeddd.domain.complement.values.*;

public class BuyComputer extends Command {

  private final ComplementID complementID;
  private final ComputerID computerID;
  private final Brand brand;
  private final Cpu cpu;
  private final Ram ram;

  public BuyComputer(ComplementID complementID, ComputerID computerID, Brand brand, Cpu cpu, Ram ram) {
    this.complementID = complementID;
    this.computerID = computerID;
    this.brand = brand;
    this.cpu = cpu;
    this.ram = ram;
  }

  public Brand getBrand() {
    return brand;
  }

  public Cpu getCpu() {
    return cpu;
  }

  public Ram getRam() {
    return ram;
  }

  public ComplementID getComplementID() {
    return complementID;
  }

  public ComputerID getComputerID() {
    return computerID;
  }
}
