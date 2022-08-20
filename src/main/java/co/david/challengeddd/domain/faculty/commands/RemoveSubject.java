package co.david.challengeddd.domain.faculty.commands;

import co.com.sofka.domain.generic.Command;
import co.david.challengeddd.domain.faculty.values.FacultyID;
import co.david.challengeddd.domain.faculty.values.SubjectID;

public class RemoveSubject extends Command {

  private final FacultyID facultyID;
  private final SubjectID subjectID;

  public RemoveSubject(FacultyID facultyID, SubjectID subjectID) {
    this.facultyID = facultyID;
    this.subjectID = subjectID;
  }

  public FacultyID getFacultyID() {
    return facultyID;
  }

  public SubjectID getSubjectID() {
    return subjectID;
  }
}
