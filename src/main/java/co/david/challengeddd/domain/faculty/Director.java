package co.david.challengeddd.domain.faculty;

import co.com.sofka.domain.generic.Entity;
import co.david.challengeddd.domain.faculty.values.*;

public class Director extends Entity<DirectorID> {

  private Account account;
  private YearsInCharge yearsInCharge;

  public Director(DirectorID directorID, Account account, YearsInCharge yearsInCharge) {
    super(directorID);
    this.account = account;
    this.yearsInCharge = yearsInCharge;
  }

  public void renewYearInCharge(YearsInCharge yearsInCharge) {
    this.yearsInCharge = yearsInCharge;
  }

  public void graduateStudent(StudentID studentID) {

  }

  public void passStudentSemester(StudentID studentID) {

  }

  public void expulseStudent(StudentID studentID) {}

  public void fireProfessor(ProfessorID professorID) {}

  public Account account() {
    return account;
  }

  public YearsInCharge yearsInCharge() {
    return yearsInCharge;
  }
}
