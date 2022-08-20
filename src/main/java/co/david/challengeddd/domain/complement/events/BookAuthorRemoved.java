package co.david.challengeddd.domain.complement.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.david.challengeddd.domain.complement.values.Author;
import co.david.challengeddd.domain.complement.values.BookID;

public class BookAuthorRemoved extends DomainEvent {

  private final BookID bookID;
  private final Author author;

  public BookAuthorRemoved(BookID bookID, Author author) {
    super("david.complement.BookAuthorRemove");
    this.bookID = bookID;
    this.author = author;
  }

  public BookID getBookID() {
    return bookID;
  }

  public Author getAuthor() {
    return author;
  }
}
