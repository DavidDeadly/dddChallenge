package co.david.challengeddd.domain.faculty.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.david.challengeddd.domain.faculty.values.DirectorID;
import co.david.challengeddd.domain.faculty.values.StudentID;

public class StudentSemesterPassed extends DomainEvent {

  private final DirectorID directorID;
  private final StudentID studentID;

  public StudentSemesterPassed(DirectorID directorID, StudentID studentID) {
    super("david.faculty.StudentSemesterPassed");
    this.directorID = directorID;
    this.studentID = studentID;
  }

  public DirectorID getDirectorID() {
    return directorID;
  }

  public StudentID getStudentID() {
    return studentID;
  }
}
