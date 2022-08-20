package co.david.challengeddd.domain.faculty;

import co.com.sofka.domain.generic.Entity;
import co.david.challengeddd.domain.faculty.values.*;

import java.util.Set;

public class Student extends Entity<StudentID> {

  private Account account;
  private Age age;
  private Set<SubjectID> subjects;
  private IsGraduated isGraduated;
  private CurrentSemester currentSemester;

  public Student(StudentID studentID, Account account, Age age, Set<SubjectID> subjects, IsGraduated isGraduated, CurrentSemester currentSemester) {
    super(studentID);
    this.account = account;
    this.age = age;
    this.subjects = subjects;
    this.isGraduated = isGraduated;
    this.currentSemester = currentSemester;
  }

  public void turnYears(Age age) {
    this.age = age;
  }

  public void assignSubject(SubjectID subjectID) {
    this.subjects.add(subjectID);
  }

  public void getGraduated(IsGraduated isGraduated) {
    this.isGraduated = isGraduated;
  }

  public void passCurrentSemester(CurrentSemester currentSemester) {
    this.currentSemester = currentSemester;
  }

  public Account account() {
    return account;
  }

  public Age age() {
    return age;
  }

  public Set<SubjectID> subjects() {
    return subjects;
  }

  public IsGraduated isGraduated() {
    return isGraduated;
  }

  public CurrentSemester currentSemester() {
    return currentSemester;
  }
}
