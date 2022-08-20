package co.david.challengeddd.domain.faculty.commands;

import co.com.sofka.domain.generic.Command;
import co.david.challengeddd.domain.faculty.values.DirectorID;
import co.david.challengeddd.domain.faculty.values.FacultyID;

public class FireDirector extends Command {

  private final FacultyID facultyID;
  private final DirectorID directorID;

  public FireDirector(FacultyID facultyID, DirectorID directorID) {
    this.facultyID = facultyID;
    this.directorID = directorID;
  }

  public FacultyID getFacultyID() {
    return facultyID;
  }

  public DirectorID getDirectorID() {
    return directorID;
  }
}
