package co.david.challengeddd.domain.faculty.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.david.challengeddd.domain.faculty.values.Account;
import co.david.challengeddd.domain.faculty.values.DirectorID;

public class DirectorAssigned extends DomainEvent {

  private final DirectorID directorID;
  private final Account account;

  public DirectorAssigned(DirectorID directorID, Account account) {
    super("david.faculty.DirectorAssigned");
    this.directorID = directorID;
    this.account = account;
  }

  public Account getAccount() {
    return account;
  }

  public DirectorID getDirectorID() {
    return directorID;
  }
}
