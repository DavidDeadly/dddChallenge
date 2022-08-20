package co.david.challengeddd.domain.complement.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.david.challengeddd.domain.complement.values.Author;
import co.david.challengeddd.domain.complement.values.BookID;
import co.david.challengeddd.domain.complement.values.BookTitle;
import co.david.challengeddd.domain.complement.values.Pages;

import java.util.Set;

public class BookAdded extends DomainEvent {

  private final BookID bookID;
  private final BookTitle bookTitle;
  private final Set<Author> authors;
  private final Pages pages;

  public BookAdded(BookID bookID, BookTitle bookTitle, Set<Author> authors, Pages pages) {
    super("david.complement.BookAdded");
    this.bookID = bookID;
    this.bookTitle = bookTitle;
    this.authors = authors;
    this.pages = pages;
  }

  public BookTitle getBookTitle() {
    return bookTitle;
  }

  public Set<Author> getAuthors() {
    return authors;
  }

  public Pages getPages() {
    return pages;
  }

  public BookID getBookID() {
    return bookID;
  }
}
