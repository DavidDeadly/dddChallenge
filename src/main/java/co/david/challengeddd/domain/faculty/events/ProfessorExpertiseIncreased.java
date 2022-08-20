package co.david.challengeddd.domain.faculty.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.david.challengeddd.domain.faculty.values.ProfessorID;
import co.david.challengeddd.domain.faculty.values.YearsOfExperience;

public class ProfessorExpertiseIncreased extends DomainEvent {

  private final ProfessorID professorID;
  private final YearsOfExperience yearsOfExperience;

  public ProfessorExpertiseIncreased(ProfessorID professorID, YearsOfExperience yearsOfExperience) {
    super("david.faculty.ProfessorExpertiseIncreased");
    this.professorID = professorID;
    this.yearsOfExperience = yearsOfExperience;
  }

  public ProfessorID getProfessorID() {
    return professorID;
  }

  public YearsOfExperience getYearOfExperience() {
    return yearsOfExperience;
  }
}
