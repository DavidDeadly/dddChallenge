package co.david.challengeddd.domain.faculty.commands;

import co.com.sofka.domain.generic.Command;
import co.david.challengeddd.domain.faculty.values.Age;
import co.david.challengeddd.domain.faculty.values.FacultyID;
import co.david.challengeddd.domain.faculty.values.StudentID;

public class TurnStudentYears extends Command {

  private final FacultyID facultyID;
  private final StudentID studentID;
  private final Age age;

  public TurnStudentYears(FacultyID facultyID, StudentID studentID, Age age) {
    this.facultyID = facultyID;
    this.studentID = studentID;
    this.age = age;
  }

  public FacultyID getFacultyID() {
    return facultyID;
  }

  public StudentID getStudentID() {
    return studentID;
  }

  public Age getAge() {
    return age;
  }
}
