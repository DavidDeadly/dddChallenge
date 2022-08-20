package co.david.challengeddd.domain.complement.values;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.domain.generic.Identity;

public class BookID extends Identity {
  public BookID(String uuid) {
    super(uuid);
  }

  public BookID() {
  }
}
