package co.david.challengeddd.domain.complement.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.david.challengeddd.domain.complement.values.BookID;
import co.david.challengeddd.domain.complement.values.BookTitle;

public class BookNameRemade extends DomainEvent {

  private final BookID bookID;
  private final BookTitle title;

  public BookNameRemade(BookID bookID, BookTitle title) {
    super("david.complement.BookNameRemade");
    this.bookID = bookID;
    this.title = title;
  }

  public BookID getBookID() {
    return bookID;
  }

  public BookTitle getTitle() {
    return title;
  }
}
