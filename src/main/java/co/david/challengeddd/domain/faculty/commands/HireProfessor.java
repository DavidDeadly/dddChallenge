package co.david.challengeddd.domain.faculty.commands;

import co.com.sofka.domain.generic.Command;
import co.david.challengeddd.domain.faculty.values.*;

import java.util.List;

public class HireProfessor extends Command {

  private final FacultyID facultyID;
  private final ProfessorID professorID;
  private final Account account;
  private final YearsOfExperience yearsOfExperience;
  private final List<Title> titles;

  public HireProfessor(FacultyID facultyID, ProfessorID professorID, Account account, YearsOfExperience yearsOfExperience, List<Title> titles) {
    this.facultyID = facultyID;
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

  public FacultyID getFacultyID() {
    return facultyID;
  }

  public ProfessorID getProfessorID() {
    return professorID;
  }
}
