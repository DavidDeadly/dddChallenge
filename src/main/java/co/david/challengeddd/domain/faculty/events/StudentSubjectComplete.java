package co.david.challengeddd.domain.faculty.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.david.challengeddd.domain.faculty.values.StudentID;
import co.david.challengeddd.domain.faculty.values.SubjectID;

public class StudentSubjectComplete extends DomainEvent {
  private final StudentID studentID;
  private final SubjectID subjectID;

  public StudentSubjectComplete(StudentID studentID, SubjectID subjectID) {
    super("david.faculty.StudentSubjectComplete");
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
