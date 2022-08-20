package co.david.challengeddd.domain.faculty.commands;

import co.com.sofka.domain.generic.Command;
import co.david.challengeddd.domain.faculty.values.FacultyID;
import co.david.challengeddd.domain.faculty.values.SubjectID;
import co.david.challengeddd.domain.faculty.values.TotalHours;

public class SubtractSubjectTotalHours extends Command {
  private final FacultyID facultyID;
  private final SubjectID subjectID;
  private final TotalHours totalHours;

  public SubtractSubjectTotalHours(FacultyID facultyID, SubjectID subjectID, TotalHours totalHours) {
    this.facultyID = facultyID;
    this.subjectID = subjectID;
    this.totalHours = totalHours;
  }

  public FacultyID getFacultyID() {
    return facultyID;
  }

  public SubjectID getSubjectID() {
    return subjectID;
  }

  public TotalHours getTotalHours() {
    return totalHours;
  }
}
