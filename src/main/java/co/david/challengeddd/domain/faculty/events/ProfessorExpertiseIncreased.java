package co.david.challengeddd.domain.faculty.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.david.challengeddd.domain.faculty.values.ProfessorID;
import co.david.challengeddd.domain.faculty.values.YearOfExperience;

public class ProfessorExpertiseIncreased extends DomainEvent {

  private final ProfessorID professorID;
  private final YearOfExperience yearOfExperience;

  public ProfessorExpertiseIncreased(ProfessorID professorID, YearOfExperience yearOfExperience) {
    super("david.faculty.ProfessorExpertiseIncreased");
    this.professorID = professorID;
    this.yearOfExperience = yearOfExperience;
  }

  public ProfessorID getProfessorID() {
    return professorID;
  }

  public YearOfExperience getYearOfExperience() {
    return yearOfExperience;
  }
}
