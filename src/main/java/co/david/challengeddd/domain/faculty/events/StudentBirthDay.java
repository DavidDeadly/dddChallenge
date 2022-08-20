package co.david.challengeddd.domain.faculty.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.david.challengeddd.domain.faculty.values.Age;
import co.david.challengeddd.domain.faculty.values.StudentID;

public class StudentBirthDay extends DomainEvent {

  private final StudentID studentID;
  private final Age age;

  public StudentBirthDay(StudentID studentID, Age age) {
    super("david.faculty.StudentBirthDay");
    this.studentID = studentID;
    this.age = age;
  }

  public StudentID getStudentID() {
    return studentID;
  }

  public Age getAge() {
    return age;
  }
}
