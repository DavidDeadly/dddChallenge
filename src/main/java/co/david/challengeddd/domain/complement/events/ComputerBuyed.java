package co.david.challengeddd.domain.complement.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.david.challengeddd.domain.complement.values.Brand;
import co.david.challengeddd.domain.complement.values.ComputerID;
import co.david.challengeddd.domain.complement.values.Cpu;
import co.david.challengeddd.domain.complement.values.Ram;

public class ComputerBuyed extends DomainEvent {

  private final ComputerID computerID;
  private final Brand brand;
  private final Cpu cpu;
  private final Ram ram;

  public ComputerBuyed(ComputerID computerID, Brand brand, Cpu cpu, Ram ram) {
    super("david.complement.ComputerBuyed");
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

  public ComputerID getComputerID() {
    return computerID;
  }
}
