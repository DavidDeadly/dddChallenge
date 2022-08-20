package co.david.challengeddd.domain.faculty.commands;

import co.com.sofka.domain.generic.Command;
import co.david.challengeddd.domain.faculty.values.FacultyID;
import co.david.challengeddd.domain.faculty.values.Points;
import co.david.challengeddd.domain.faculty.values.SubjectID;

public class DecreaseSubjectPoints extends Command {
  private final FacultyID facultyID;
  private final SubjectID subjectID;
  private final Points points;

  public DecreaseSubjectPoints(FacultyID facultyID, SubjectID subjectID, Points points) {
    this.facultyID = facultyID;
    this.subjectID = subjectID;
    this.points = points;
  }

  public FacultyID getFacultyID() {
    return facultyID;
  }

  public SubjectID getSubjectID() {
    return subjectID;
  }

  public Points getPoints() {
    return points;
  }
}
