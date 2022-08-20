package co.david.challengeddd.domain.complement.commands;

import co.com.sofka.domain.generic.Command;
import co.david.challengeddd.domain.complement.values.BookID;
import co.david.challengeddd.domain.complement.values.ComplementID;

public class RemoveBook extends Command {

  private final ComplementID complementID;
  private final BookID bookID;

  public RemoveBook(ComplementID complementID, BookID bookID) {
    this.complementID = complementID;
    this.bookID = bookID;
  }

  public ComplementID getComplementID() {
    return complementID;
  }

  public BookID getBookID() {
    return bookID;
  }
}
