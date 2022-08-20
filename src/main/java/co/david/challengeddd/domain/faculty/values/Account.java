package co.david.challengeddd.domain.faculty.values;

import co.com.sofka.domain.generic.ValueObject;

public class Account implements ValueObject<Account.Values> {

  private final String username;
  private final String email;

  public Account(String username, String email) {
    this.username = username;
    this.email = email;
  }

  @Override
  public Values value() {
    return new Values() {
      @Override
      public String username() {
        return username;
      }

      @Override
      public String email() {
        return email;
      }
    };
  }

  public interface Values {
    String username();
    String email();
  }
}
