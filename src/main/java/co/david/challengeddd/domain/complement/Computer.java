package co.david.challengeddd.domain.complement;

import co.com.sofka.domain.generic.Entity;
import co.david.challengeddd.domain.complement.values.Brand;
import co.david.challengeddd.domain.complement.values.ComputerID;
import co.david.challengeddd.domain.complement.values.Cpu;
import co.david.challengeddd.domain.complement.values.Ram;
import co.david.challengeddd.domain.faculty.values.StudentID;

public class Computer extends Entity<ComputerID> {

  private Brand brand;
  private Cpu cpu;
  private Ram ram;
  private StudentID studentID;

  public Computer(ComputerID computerID, Brand brand, Cpu cpu, Ram ram) {
    super(computerID);
    this.brand = brand;
    this.cpu = cpu;
    this.ram = ram;
  }

  public void improveCPU(Cpu cpu) {
    this.cpu = cpu;
  }

  public void improveRam(Ram ram) {
    this.ram = ram;
  }

  public void assignStudentID(StudentID studentID) {
    this.studentID = studentID;
  }

  public void removeStudentID(StudentID studentID) {
    this.studentID = null;
  }

  public Brand Brand() {
    return brand;
  }

  public Cpu Cpu() {
    return cpu;
  }

  public Ram Ram() {
    return ram;
  }

  public StudentID StudentID() {
    return studentID;
  }
}
