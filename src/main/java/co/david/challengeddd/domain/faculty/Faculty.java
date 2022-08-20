package co.david.challengeddd.domain.faculty;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import co.david.challengeddd.domain.faculty.events.*;
import co.david.challengeddd.domain.faculty.values.*;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public class Faculty extends AggregateEvent<FacultyID> {

  protected FacultyName facultyName;
  protected ActiveYears activeYears;
  protected Director director;
  protected Set<Subject> subjects;
  protected Set<Student> students;
  protected Set<Professor> professors;

  public Faculty(FacultyID facultyID, FacultyName facultyName, ActiveYears activeYears) {
    super(facultyID);
    appendChange(new FacultyCreated(facultyName, activeYears));
  }

  public Faculty(FacultyID facultyID) {
    super(facultyID);
    subscribe(new FacultyChange(this));
  }

  public static Faculty from(FacultyID facultyID, List<DomainEvent> events) {
    Faculty faculty = new Faculty(facultyID);
    events.forEach(faculty::applyEvent);
    return faculty;
  }

  public void renameFaculty(FacultyName facultyName) {
    appendChange(new FacultyRenamed(facultyName)).apply();
  }

  public void renewActiveYears(ActiveYears activeYears) {
    appendChange(new ActiveYearsRenewed(activeYears)).apply();
  }

  public void assignDirector(DirectorID directorID, Account account) {
    appendChange(new DirectorAssigned(directorID, account)).apply();
  }

  public void FireDirector(DirectorID directorID) {
    appendChange(new DirectorFired(directorID)).apply();
  }

  public void addSubject(SubjectID subjectID, SubjectName subjectName, Points points, TotalHours hours) {
    appendChange(new SubjectAdded(subjectID, subjectName, points, hours)).apply();
  }

  public void removeSubject(SubjectID subjectID) {
    appendChange(new SubjectRemoved(subjectID)).apply();
  }

  public void registerStudent(StudentID studentID, Account account, Age age) {
    appendChange(new StudentRegistered(studentID, account, age)).apply();
  }

  public void hireProfessor(ProfessorID professorID, Account account, YearsOfExperience yearsOfExperience, List<Title> titles) {
    appendChange(new ProfessorHired(professorID, account, yearsOfExperience, titles)).apply();
  }

  public void increaseSubjectPoints(SubjectID subjectID, Points points) {
    appendChange(new SubjectPointsIncreased(subjectID, points)).apply();
  }

  public void decreaseSubjectPoints(SubjectID subjectID, Points points) {
    appendChange(new SubjectPointsDecreased(subjectID, points)).apply();
  }

  public void addSubjectTotalHours(SubjectID subjectID, TotalHours totalHours) {
    appendChange(new SubjectTotalHoursAdded(subjectID, totalHours)).apply();
  }

  public void subtractSubjectTotalHours(SubjectID subjectID, TotalHours totalHours) {
    appendChange(new SubjectTotalHoursSubtracted(subjectID, totalHours)).apply();
  }

  public void assignSubjectProfessor(SubjectID subjectId, ProfessorID professorID) {
    appendChange(new SubjectProfessorAssigned(subjectId, professorID)).apply();
  }

  public void turnStudentYears(StudentID studentId, Age age) {
    appendChange(new StudentBirthDay(studentId, age)).apply();
  }

  public void assignStudentSubject(StudentID studentId, SubjectID subjectId) {
    appendChange(new StudentSubjectAssigned(studentId, subjectId)).apply();
  }

  public void completeStudentSubject(StudentID studentId, SubjectID subjectId) {
    appendChange(new StudentSubjectComplete(studentId, subjectId)).apply();
  }

  public void turnProfessorExpertiseYears(ProfessorID professorId, YearsOfExperience yearsOfExperience){
    appendChange(new ProfessorExpertiseIncreased(professorId, yearsOfExperience)).apply();
  }

  public void passStudentSemester(DirectorID directorId, StudentID studentId) {
    appendChange(new StudentSemesterPassed(directorId, studentId)).apply();
  }

  public void addProfessorTitle(ProfessorID professorId, Title title) {
    appendChange(new ProfessorTitleAdded(professorId, title)).apply();
  }

  public void renewDirectorYearInCharge(DirectorID directorId, YearsInCharge yearsInCharge) {
    appendChange(new DirectorYearInChargeRenewed(directorId, yearsInCharge)).apply();
  }

  public void graduateStudent(DirectorID directorID, StudentID studentId) {
    appendChange(new StudentGraduated(directorID, studentId)).apply();
  }

  public void expulseStudent(DirectorID directorID, StudentID studentId) {
    appendChange(new StudentExpulsed(directorID, studentId)).apply();
  }

  public void fireProfessor(DirectorID directorId, ProfessorID professorID) {
    appendChange(new ProfessorFired(directorId, professorID)).apply();
  }

  public Optional<Subject> getSubjectById(SubjectID subjectID) {
    return subjects().stream()
            .filter(subject -> subject.identity().equals(subjectID))
            .findFirst();
  }

  public Optional<Student> getStudentById(StudentID studentID) {
    return students().stream()
            .filter(student -> student.identity().equals(studentID))
            .findFirst();
  }
  public Optional<Professor> getProfessorById(ProfessorID professorID) {
    return professors().stream()
            .filter(professor -> professor.identity().equals(professorID))
            .findFirst();
  }

  public FacultyName facultyName() {
    return facultyName;
  }

  public ActiveYears activeYears() {
    return activeYears;
  }

  public Director director() {
    return director;
  }

  public Set<Subject> subjects() {
    return subjects;
  }

  public Set<Student> students() {
    return students;
  }

  public Set<Professor> professors() {
    return professors;
  }
}
