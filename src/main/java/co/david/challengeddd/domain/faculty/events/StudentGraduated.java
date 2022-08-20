package co.david.challengeddd.domain.faculty.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.david.challengeddd.domain.faculty.values.IsGraduated;
import co.david.challengeddd.domain.faculty.values.StudentID;

public class StudentGraduated extends DomainEvent {

  private final StudentID studentID;
  private final IsGraduated isGraduated;

  public StudentGraduated(StudentID studentID, IsGraduated isGraduated) {
    super("david.faculty.StudentGraduated");
    this.studentID = studentID;
    this.isGraduated = isGraduated;
  }

  public StudentID getStudentID() {
    return studentID;
  }

  public IsGraduated getIsGraduated() {
    return isGraduated;
  }
}
