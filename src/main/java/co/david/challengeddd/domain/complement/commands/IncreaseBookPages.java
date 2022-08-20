package co.david.challengeddd.domain.complement.commands;

import co.com.sofka.domain.generic.Command;
import co.david.challengeddd.domain.complement.values.BookID;
import co.david.challengeddd.domain.complement.values.ComplementID;
import co.david.challengeddd.domain.complement.values.Pages;

public class IncreaseBookPages extends Command {

  private final ComplementID complementID;
  private final BookID bookID;
  private final Pages pages;

  public IncreaseBookPages(ComplementID complementID, BookID bookID, Pages pages) {
    this.complementID = complementID;
    this.bookID = bookID;
    this.pages = pages;
  }

  public ComplementID getComplementID() {
    return complementID;
  }

  public BookID getBookID() {
    return bookID;
  }

  public Pages getPages() {
    return pages;
  }
}
