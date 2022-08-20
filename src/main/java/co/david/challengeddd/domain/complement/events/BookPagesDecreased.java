package co.david.challengeddd.domain.complement.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.david.challengeddd.domain.complement.values.BookID;
import co.david.challengeddd.domain.complement.values.Pages;

public class BookPagesDecreased extends DomainEvent {
  private final BookID bookID;
  private final Pages pages;

  public BookPagesDecreased(BookID bookID, Pages pages) {
    super("david.complement.BookPagesIncreased");
    this.bookID = bookID;
    this.pages = pages;
  }

  public BookID getBookID() {
    return bookID;
  }

  public Pages getPages() {
    return pages;
  }
}
