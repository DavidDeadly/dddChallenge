package co.david.challengeddd.domain.faculty;

import co.com.sofka.domain.generic.Entity;
import co.david.challengeddd.domain.faculty.values.*;

public class Subject  extends Entity<SubjectID> {

  private SubjectName subjectName;
  private Points points;
  private TotalHours totalHours;
  private ProfessorID professorID;

  public Subject(SubjectID subjectID, SubjectName subjectName, Points points, TotalHours totalHours) {
    super(subjectID);
    this.subjectName = subjectName;
    this.points = points;
    this.totalHours = totalHours;
  }

  public void increasePoints(Points points) {
    this.points = new Points(this.points.value() + points.value());
  }

  public void decreasePoints(Points points) {
    this.points = new Points(this.points.value() - points.value());
  }

  public void addTotalHours(TotalHours totalHours) {
    this.totalHours = new TotalHours(this.totalHours.value() + totalHours.value());
  }

  public void subtractTotalHours(TotalHours totalHours) {
    this.totalHours = new TotalHours(this.totalHours.value() - totalHours.value());
  }

  public void assignProfessorID(ProfessorID professorID) {
    this.professorID = professorID;
  }

  public SubjectName subjectName() {
    return subjectName;
  }

  public Points points() {
    return points;
  }

  public TotalHours totalHours() {
    return totalHours;
  }

  public ProfessorID professorID() {
    return professorID;
  }
}
