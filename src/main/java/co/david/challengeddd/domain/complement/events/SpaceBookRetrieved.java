package co.david.challengeddd.domain.complement.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.david.challengeddd.domain.complement.values.BookID;
import co.david.challengeddd.domain.complement.values.SpaceID;

public class SpaceBookRetrieved extends DomainEvent {

  private final SpaceID spaceID;
  private final BookID bookID;

  public SpaceBookRetrieved(SpaceID spaceID, BookID bookID) {
    super("david.complement.SpaceBookRetrieved");
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
