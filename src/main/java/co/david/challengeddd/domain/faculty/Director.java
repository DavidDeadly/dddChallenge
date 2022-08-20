package co.david.challengeddd.domain.faculty;

import co.com.sofka.domain.generic.Entity;
import co.david.challengeddd.domain.faculty.values.*;

import java.util.Set;

public class Director extends Entity<DirectorID> {

  private Account account;
  private YearsInCharge yearsInCharge;

  public Director(DirectorID directorID, Account account, YearsInCharge yearsInCharge) {
    super(directorID);
    this.account = account;
    this.yearsInCharge = yearsInCharge;
  }

  public void renewYearInCharge() {
    this.yearsInCharge = new YearsInCharge(this.yearsInCharge.value() + 1);
  }

  public void graduateStudent(Student student) { student.getGraduated();}

  public void passStudentSemester(Student student) { student.passCurrentSemester();  }

  public void expulseStudent(Set<Student> students, StudentID studentID) {
    students.removeIf(student -> student.identity().equals(studentID));
  }

  public void fireProfessor(Set<Professor> professors, ProfessorID professorID) {
    professors.removeIf(professor -> professor.identity().equals(professorID));
  }

  public Account account() {
    return account;
  }

  public YearsInCharge yearsInCharge() {
    return yearsInCharge;
  }
}
