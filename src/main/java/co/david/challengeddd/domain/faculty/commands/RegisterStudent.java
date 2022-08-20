package co.david.challengeddd.domain.faculty.commands;

import co.com.sofka.domain.generic.Command;
import co.david.challengeddd.domain.faculty.values.FacultyID;
import co.david.challengeddd.domain.faculty.values.StudentID;

public class RegisterStudent extends Command {

  private final FacultyID facultyID;
  private final StudentID studentID;

  public RegisterStudent(FacultyID facultyID, StudentID studentID) {
    this.facultyID = facultyID;
    this.studentID = studentID;
  }

  public FacultyID getFacultyID() {
    return facultyID;
  }

  public StudentID getStudentID() {
    return studentID;
  }
}
