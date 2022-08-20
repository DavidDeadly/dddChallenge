package co.david.challengeddd.domain.faculty.commands;

import co.com.sofka.domain.generic.Command;
import co.david.challengeddd.domain.faculty.values.FacultyID;
import co.david.challengeddd.domain.faculty.values.IsGraduated;
import co.david.challengeddd.domain.faculty.values.StudentID;

public class GraduateStudent extends Command {

  private final FacultyID facultyID;
  private final StudentID studentID;
  private final IsGraduated isGraduated;

  public GraduateStudent(FacultyID facultyID, StudentID studentID, IsGraduated isGraduated) {
    this.facultyID = facultyID;
    this.studentID = studentID;
    this.isGraduated = isGraduated;
  }

  public FacultyID getFacultyID() {
    return facultyID;
  }

  public StudentID getStudentID() {
    return studentID;
  }

  public IsGraduated getIsGraduated() {
    return isGraduated;
  }
}
