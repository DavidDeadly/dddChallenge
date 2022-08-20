package co.david.challengeddd.domain.complement.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.david.challengeddd.domain.complement.values.BookID;
import co.david.challengeddd.domain.complement.values.SpaceID;

public class SpaceBookAssigned extends DomainEvent {

  private final SpaceID spaceID;
  private final BookID bookID;

  public SpaceBookAssigned(SpaceID spaceID, BookID bookID) {
    super("david.complement.SpaceBookAssigned");
    this.spaceID = spaceID;
    this.bookID = bookID;
  }

  public SpaceID getSpaceID() {
    return spaceID;
  }

  public BookID getBookID() {
    return bookID;
  }
}
