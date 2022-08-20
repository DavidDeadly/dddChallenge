package co.david.challengeddd.domain.complement.commands;

import co.com.sofka.domain.generic.Command;
import co.david.challengeddd.domain.complement.values.Author;
import co.david.challengeddd.domain.complement.values.BookID;
import co.david.challengeddd.domain.complement.values.ComplementID;

public class RemoveBookAuthor extends Command {

  private final ComplementID complementID;
  private final BookID bookID;
  private final Author author;

  public RemoveBookAuthor(ComplementID complementID, BookID bookID, Author author) {
    this.complementID = complementID;
    this.bookID = bookID;
    this.author = author;
  }

  public ComplementID getComplementID() {
    return complementID;
  }

  public BookID getBookID() {
    return bookID;
  }

  public Author getAuthor() {
    return author;
  }
}
