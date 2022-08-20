package co.david.challengeddd.domain.faculty.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.david.challengeddd.domain.faculty.values.Account;
import co.david.challengeddd.domain.faculty.values.ProfessorID;
import co.david.challengeddd.domain.faculty.values.Title;
import co.david.challengeddd.domain.faculty.values.YearsOfExperience;

import java.util.List;

public class ProfessorHired extends DomainEvent {

  private final ProfessorID professorID;
  private final Account account;
  private final YearsOfExperience yearsOfExperience;
  private final List<Title> titles;

  public ProfessorHired(ProfessorID professorID, Account account, YearsOfExperience yearsOfExperience, List<Title> titles) {
    super("david.faculty.ProfessorHired");
    this.professorID = professorID;
    this.account = account;
    this.yearsOfExperience = yearsOfExperience;
    this.titles = titles;
  }

  public Account getAccount() {
    return account;
  }

  public YearsOfExperience getYearsOfExperience() {
    return yearsOfExperience;
  }

  public List<Title> getTitles() {
    return titles;
  }

  public ProfessorID getProfessorID() {
    return professorID;
  }
}
