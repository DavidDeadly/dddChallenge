package co.david.challengeddd.domain.faculty.commands;

import co.com.sofka.domain.generic.Command;
import co.david.challengeddd.domain.faculty.values.DirectorID;
import co.david.challengeddd.domain.faculty.values.FacultyID;
import co.david.challengeddd.domain.faculty.values.StudentID;

public class ExpulseStudent extends Command {

  private final FacultyID facultyID;
  private final DirectorID directorID;
  private final StudentID studentID;

  public ExpulseStudent(FacultyID facultyID, DirectorID directorID, StudentID studentID) {
    this.facultyID = facultyID;
    this.directorID = directorID;
    this.studentID = studentID;
  }

  public DirectorID getDirectorID() {
    return directorID;
  }

  public FacultyID getFacultyID() {
    return facultyID;
  }

  public StudentID getStudentID() {
    return studentID;
  }
}
