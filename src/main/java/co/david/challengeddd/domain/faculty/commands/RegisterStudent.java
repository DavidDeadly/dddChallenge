package co.david.challengeddd.domain.faculty.commands;

import co.com.sofka.domain.generic.Command;
import co.david.challengeddd.domain.faculty.values.Account;
import co.david.challengeddd.domain.faculty.values.Age;
import co.david.challengeddd.domain.faculty.values.FacultyID;
import co.david.challengeddd.domain.faculty.values.StudentID;

public class RegisterStudent extends Command {

  private final FacultyID facultyID;
  private final StudentID studentID;
  private final Account account;
  private final Age age;

  public RegisterStudent(FacultyID facultyID, StudentID studentID, Account account, Age age) {
    this.facultyID = facultyID;
    this.studentID = studentID;
    this.account = account;
    this.age = age;
  }

  public Account getAccount() {
    return account;
  }

  public Age getAge() {
    return age;
  }

  public FacultyID getFacultyID() {
    return facultyID;
  }

  public StudentID getStudentID() {
    return studentID;
  }
}
