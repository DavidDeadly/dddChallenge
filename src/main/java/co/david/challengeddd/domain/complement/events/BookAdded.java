package co.david.challengeddd.domain.complement.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.david.challengeddd.domain.complement.values.BookID;

public class BookAdded extends DomainEvent {

  private final BookID bookID;

  public BookAdded(BookID bookID) {
    super("david.complement.BookAdded");
    this.bookID = bookID;
  }

  public BookID getBookID() {
    return bookID;
  }
}
