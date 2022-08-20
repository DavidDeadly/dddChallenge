package co.david.challengeddd.domain.faculty.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.david.challengeddd.domain.faculty.values.DirectorID;
import co.david.challengeddd.domain.faculty.values.YearsInCharge;

public class DirectorYearInChargeRenewed extends DomainEvent {

  private final DirectorID directorID;
  private final YearsInCharge yearsInCharge;

  public DirectorYearInChargeRenewed(DirectorID directorID, YearsInCharge yearsInCharge) {
    super("david.faculty.DirectorYearInChargeRenewed");
    this.directorID = directorID;
    this.yearsInCharge = yearsInCharge;
  }

  public DirectorID getDirectorID() {
    return directorID;
  }

  public YearsInCharge getYearsInCharge() {
    return yearsInCharge;
  }
}
