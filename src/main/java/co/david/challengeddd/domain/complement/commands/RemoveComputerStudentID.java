package co.david.challengeddd.domain.complement.commands;

import co.com.sofka.domain.generic.Command;
import co.david.challengeddd.domain.complement.values.ComplementID;
import co.david.challengeddd.domain.complement.values.ComputerID;
import co.david.challengeddd.domain.faculty.values.StudentID;

public class RemoveComputerStudentID extends Command {

  private final ComplementID complementID;
  private final ComputerID computerID;
  private final StudentID studentID;

  public RemoveComputerStudentID(ComplementID complementID, ComputerID computerID, StudentID studentID) {
    this.complementID = complementID;
    this.computerID = computerID;
    this.studentID = studentID;
  }

  public ComplementID getComplementID() {
    return complementID;
  }

  public ComputerID getComputerID() {
    return computerID;
  }

  public StudentID getStudentID() {
    return studentID;
  }
}
