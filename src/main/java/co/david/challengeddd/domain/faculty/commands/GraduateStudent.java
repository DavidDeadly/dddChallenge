package co.david.challengeddd.domain.faculty.commands;

import co.com.sofka.domain.generic.Command;
import co.david.challengeddd.domain.faculty.values.DirectorID;
import co.david.challengeddd.domain.faculty.values.FacultyID;
import co.david.challengeddd.domain.faculty.values.IsGraduated;
import co.david.challengeddd.domain.faculty.values.StudentID;

public class GraduateStudent extends Command {

  private final FacultyID facultyID;

  private final DirectorID directorID;
  private final StudentID studentID;


  public GraduateStudent(FacultyID facultyID,  DirectorID directorID, StudentID studentID) {
    this.facultyID = facultyID;
    this.studentID = studentID;
    this.directorID = directorID;
  }

  public FacultyID getFacultyID() {
    return facultyID;
  }

  public DirectorID getDirectorID() {
    return directorID;
  }

  public StudentID getStudentID() {
    return studentID;
  }

}
