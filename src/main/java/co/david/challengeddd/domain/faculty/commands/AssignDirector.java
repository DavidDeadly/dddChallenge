package co.david.challengeddd.domain.faculty.commands;

import co.com.sofka.domain.generic.Command;
import co.david.challengeddd.domain.faculty.values.Account;
import co.david.challengeddd.domain.faculty.values.DirectorID;
import co.david.challengeddd.domain.faculty.values.FacultyID;

public class AssignDirector extends Command {

  private final FacultyID facultyID;
  private final DirectorID directorID;
  private final Account account;

  public AssignDirector(FacultyID facultyID, DirectorID directorID, Account account) {
    this.facultyID = facultyID;
    this.directorID = directorID;
    this.account = account;
  }

  public Account getAccount() {
    return account;
  }

  public FacultyID getFacultyID() {
    return facultyID;
  }

  public DirectorID getDirectorID() {
    return directorID;
  }
}
