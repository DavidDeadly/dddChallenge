package co.david.challengeddd.domain.faculty.values;

import co.com.sofka.domain.generic.Identity;

public class FacultyID extends Identity {

  public FacultyID(String uuid) {
    super(uuid);
  }

  public FacultyID() {
  }

  public static FacultyID of(String uuid) { return new FacultyID(uuid);}
}
