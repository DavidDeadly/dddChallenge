package co.david.challengeddd.domain.faculty;

import co.com.sofka.domain.generic.Entity;
import co.david.challengeddd.domain.faculty.values.Account;
import co.david.challengeddd.domain.faculty.values.ProfessorID;
import co.david.challengeddd.domain.faculty.values.Title;
import co.david.challengeddd.domain.faculty.values.YearsOfExperience;

import java.util.List;

public class Professor extends Entity<ProfessorID> {

  private Account account;
  private YearsOfExperience yearsOfExperience;
  private List<Title> titles;

  public Professor(ProfessorID professorID, Account account, YearsOfExperience yearsOfExperience, List<Title> titles) {
    super(professorID);
    this.account = account;
    this.yearsOfExperience = yearsOfExperience;
    this.titles = titles;
  }

  public void turnExpertiseYears(YearsOfExperience yearsOfExperience) {
    this.yearsOfExperience = yearsOfExperience;
  }

  public void addTitles(Title title) {
    this.titles.add(title);
  }

  public Account account() {
    return account;
  }

  public YearsOfExperience tearsOfExperience() {
    return yearsOfExperience;
  }

  public List<Title> titles() {
    return titles;
  }
}
