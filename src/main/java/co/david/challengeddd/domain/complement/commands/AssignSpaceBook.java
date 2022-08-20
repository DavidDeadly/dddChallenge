package co.david.challengeddd.domain.complement.commands;

import co.com.sofka.domain.generic.Command;
import co.david.challengeddd.domain.complement.values.BookID;
import co.david.challengeddd.domain.complement.values.ComplementID;
import co.david.challengeddd.domain.complement.values.SpaceID;

public class AssignSpaceBook extends Command {

  private final ComplementID complementID;
  private final SpaceID spaceID;
  private final BookID bookID;

  public AssignSpaceBook(ComplementID complementID, SpaceID spaceID, BookID bookID) {
    this.complementID = complementID;
    this.spaceID = spaceID;
    this.bookID = bookID;
  }

  public ComplementID getComplementID() {
    return complementID;
  }

  public SpaceID getSpaceID() {
    return spaceID;
  }

  public BookID getBookID() {
    return bookID;
  }
}
