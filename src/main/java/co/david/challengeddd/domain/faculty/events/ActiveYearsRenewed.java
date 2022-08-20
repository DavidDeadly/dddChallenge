package co.david.challengeddd.domain.faculty.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.david.challengeddd.domain.faculty.values.ActiveYears;

public class ActiveYearsRenewed extends DomainEvent {

  private final ActiveYears activeYears;

  public ActiveYearsRenewed(ActiveYears activeYears) {
    super("david.faculty.ActiveYearsRenewed");
    this.activeYears = activeYears;
  }

  public ActiveYears getActiveYears() {
    return activeYears;
  }
}
