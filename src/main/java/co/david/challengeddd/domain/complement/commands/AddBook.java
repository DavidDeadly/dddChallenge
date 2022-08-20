package co.david.challengeddd.domain.complement.commands;

import co.com.sofka.domain.generic.Command;
import co.david.challengeddd.domain.complement.values.*;

import java.util.Set;

public class AddBook extends Command {

  private final ComplementID complementID;
  private final BookID bookID;
  private final BookTitle bookTitle;
  private final Set<Author> authors;
  private final Pages pages;

  public AddBook(ComplementID complementID, BookID bookID, BookTitle bookTitle, Set<Author> authors, Pages pages) {
    this.complementID = complementID;
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

  public ComplementID getComplementID() {
    return complementID;
  }

  public BookID getBookID() {
    return bookID;
  }
}
