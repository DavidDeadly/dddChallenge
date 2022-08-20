package co.david.challengeddd.domain.faculty.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.david.challengeddd.domain.faculty.values.StudentID;

public class StudentRegistered extends DomainEvent {

  private final StudentID studentID;

  public StudentRegistered(StudentID studentID) {
    super("david.faculty.StudentRegistered");
    this.studentID = studentID;
  }

  public StudentID getStudentID() {
    return studentID;
  }
}
