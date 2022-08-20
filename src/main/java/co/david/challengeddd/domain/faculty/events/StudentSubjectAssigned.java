package co.david.challengeddd.domain.faculty.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.david.challengeddd.domain.faculty.values.StudentID;
import co.david.challengeddd.domain.faculty.values.SubjectID;

public class StudentSubjectAssigned extends DomainEvent {

  private final StudentID studentID;
  private final SubjectID subjectID;

  public StudentSubjectAssigned(StudentID studentID, SubjectID subjectID) {
    super("david.faculty.StudentSubjectAssigned");
    this.studentID = studentID;
    this.subjectID = subjectID;
  }

  public StudentID getStudentID() {
    return studentID;
  }

  public SubjectID getSubjectID() {
    return subjectID;
  }
}
