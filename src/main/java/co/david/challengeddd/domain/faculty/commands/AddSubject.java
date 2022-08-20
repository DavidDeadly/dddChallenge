package co.david.challengeddd.domain.faculty.commands;

import co.com.sofka.domain.generic.Command;
import co.david.challengeddd.domain.faculty.values.*;

public class AddSubject extends Command {

  private final FacultyID facultyID;
  private final SubjectID subjectID;
  private final SubjectName subjectName;
  private final Points points;
  private final TotalHours hours;

  public AddSubject(FacultyID facultyID, SubjectID subjectID, SubjectName subjectName, Points points, TotalHours hours) {
    this.facultyID = facultyID;
    this.subjectID = subjectID;
    this.subjectName = subjectName;
    this.points = points;
    this.hours = hours;
  }

  public SubjectName getSubjectName() {
    return subjectName;
  }

  public Points getPoints() {
    return points;
  }

  public TotalHours getHours() {
    return hours;
  }

  public FacultyID getFacultyID() {
    return facultyID;
  }

  public SubjectID getSubjectID() {
    return subjectID;
  }
}
