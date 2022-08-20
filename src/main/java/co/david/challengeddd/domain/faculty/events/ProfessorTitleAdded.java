package co.david.challengeddd.domain.faculty.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.david.challengeddd.domain.faculty.values.ProfessorID;
import co.david.challengeddd.domain.faculty.values.Title;

public class ProfessorTitleAdded extends DomainEvent {

  private final ProfessorID professorID;
  private final Title title;

  public ProfessorTitleAdded(ProfessorID professorID, Title title) {
    super("david.faculty.ProfessorTitleAdded");
    this.professorID = professorID;
    this.title = title;
  }

  public ProfessorID getProfessorID() {
    return professorID;
  }

  public Title getTitle() {
    return title;
  }
}
