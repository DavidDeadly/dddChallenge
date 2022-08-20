package co.david.challengeddd.domain.faculty.commands;

import co.com.sofka.domain.generic.Command;
import co.david.challengeddd.domain.faculty.values.FacultyID;
import co.david.challengeddd.domain.faculty.values.StudentID;
import co.david.challengeddd.domain.faculty.values.SubjectID;

public class CompleteStudentSubject extends Command {
  private final FacultyID facultyID;
  private final StudentID studentID;
  private final SubjectID subjectID;

  public CompleteStudentSubject(FacultyID facultyID, StudentID studentID, SubjectID subjectID) {
    this.facultyID = facultyID;
    this.studentID = studentID;
    this.subjectID = subjectID;
  }

  public FacultyID getFacultyID() {
    return facultyID;
  }

  public StudentID getStudentID() {
    return studentID;
  }

  public SubjectID getSubjectID() {
    return subjectID;
  }
}
