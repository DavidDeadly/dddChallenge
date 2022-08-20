package co.david.challengeddd.domain.faculty.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.david.challengeddd.domain.faculty.values.Account;
import co.david.challengeddd.domain.faculty.values.Age;
import co.david.challengeddd.domain.faculty.values.StudentID;

public class StudentRegistered extends DomainEvent {

  private final StudentID studentID;
  private final Account account;
  private final Age age;

  public StudentRegistered(StudentID studentID, Account account, Age age) {
    super("david.faculty.StudentRegistered");
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

  public StudentID getStudentID() {
    return studentID;
  }
}
