package co.david.challengeddd.domain.complement.commands;

import co.com.sofka.domain.generic.Command;
import co.david.challengeddd.domain.complement.values.BookID;
import co.david.challengeddd.domain.complement.values.BookTitle;
import co.david.challengeddd.domain.complement.values.ComplementID;

public class RemakeBookName extends Command {

  private final ComplementID complementID;
  private final BookID bookID;
  private final BookTitle title;

  public RemakeBookName(ComplementID complementID, BookID bookID, BookTitle title) {
    this.complementID = complementID;
    this.bookID = bookID;
    this.title = title;
  }

  public ComplementID getComplementID() {
    return complementID;
  }

  public BookID getBookID() {
    return bookID;
  }

  public BookTitle getTitle() {
    return title;
  }
}
