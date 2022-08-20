package co.david.challengeddd.domain.complement.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.david.challengeddd.domain.complement.values.ComputerID;
import co.david.challengeddd.domain.faculty.values.StudentID;

public class ComputerStudentIDAssigned extends DomainEvent {

  private final ComputerID computerID;
  private final StudentID studentID;

  public ComputerStudentIDAssigned(ComputerID computerID, StudentID studentID) {
    super("david.complement.ComputerStudentIDAssigned");
    this.computerID = computerID;
    this.studentID = studentID;
  }

  public ComputerID getComputerID() {
    return computerID;
  }

  public StudentID getStudentID() {
    return studentID;
  }
}
