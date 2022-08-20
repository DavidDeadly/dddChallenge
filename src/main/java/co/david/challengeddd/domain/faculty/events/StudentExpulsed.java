package co.david.challengeddd.domain.faculty.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.david.challengeddd.domain.faculty.values.StudentID;

public class StudentExpulsed extends DomainEvent {

  private final StudentID studentID;

  public StudentExpulsed(StudentID studentID) {
    super("david.faculty.StudentExpulsed");
    this.studentID = studentID;
  }

  public StudentID getStudentID() {
    return studentID;
  }
}
