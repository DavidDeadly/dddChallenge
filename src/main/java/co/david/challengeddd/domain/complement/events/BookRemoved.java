package co.david.challengeddd.domain.complement.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.david.challengeddd.domain.complement.values.BookID;

public class BookRemoved extends DomainEvent {

  private final BookID bookID;

  public BookRemoved(BookID bookID) {
    super("david.complement.BookRemoved");
    this.bookID = bookID;
  }

  public BookID getBookID() {
    return bookID;
  }
}
