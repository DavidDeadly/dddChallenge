package co.david.challengeddd.domain.faculty.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.david.challengeddd.domain.faculty.values.DirectorID;
import co.david.challengeddd.domain.faculty.values.IsGraduated;
import co.david.challengeddd.domain.faculty.values.StudentID;

public class StudentGraduated extends DomainEvent {

  private final DirectorID directorID;
  private final StudentID studentID;

  public StudentGraduated(DirectorID directorID, StudentID studentID) {
    super("david.faculty.StudentGraduated");
    this.directorID = directorID;
    this.studentID = studentID;
  }

  public StudentID getStudentID() {
    return studentID;
  }

  public DirectorID getDirectorID() {
    return directorID;
  }
}
