package co.david.challengeddd.domain.faculty;

import co.com.sofka.domain.generic.EventChange;
import co.david.challengeddd.domain.faculty.events.*;
import co.david.challengeddd.domain.faculty.values.CurrentSemester;
import co.david.challengeddd.domain.faculty.values.IsGraduated;
import co.david.challengeddd.domain.faculty.values.YearsInCharge;

import java.util.HashSet;
import java.util.Optional;

public class FacultyChange extends EventChange {
  public FacultyChange(Faculty faculty) {

    apply((FacultyCreated event) -> {
      faculty.facultyName = event.getFacultyName();
      faculty.activeYears = event.getActiveYears();
      faculty.director = null;
      faculty.subjects = new HashSet<>();
      faculty.professors = new HashSet<>();
      faculty.students = new HashSet<>();
    });

    apply((FacultyRenamed event) -> faculty.facultyName = event.getFacultyName());

    apply((ActiveYearsRenewed event) -> faculty.activeYears = event.getActiveYears());

    apply((DirectorAssigned event) -> faculty.director = new Director(
            event.getDirectorID(),
            event.getAccount(),
            new YearsInCharge(0)
    ));

    apply((DirectorFired event) -> faculty.director = null);

    apply((SubjectAdded event) -> faculty.subjects.add(
      new Subject(
        event.getSubjectID(),
        event.getSubjectName(),
        event.getPoints(),
        event.getHours()
      )
    ));

    apply((SubjectRemoved event) -> faculty.subjects.removeIf(subject -> subject.identity().equals(event.getSubjectID())));

    apply((StudentRegistered event) -> faculty.students.add(
      new Student(
        event.getStudentID(),
        event.getAccount(),
        event.getAge(),
        new HashSet<>(),
        new IsGraduated(false),
        new CurrentSemester(1)
      )
    ));

    apply((ProfessorHired event) -> faculty.professors.add(
      new Professor(
        event.getProfessorID(),
        event.getAccount(),
        event.getYearsOfExperience(),
        event.getTitles()
      )
    ));

    apply((SubjectPointsIncreased event) -> {
      Optional<Subject> subjectById = faculty.getSubjectById(event.getSubjectID());
      subjectById.ifPresent(subject -> subject.increasePoints(event.getPoints()));
    });

    apply((SubjectPointsDecreased event) -> {
      Optional<Subject> subjectById = faculty.getSubjectById(event.getSubjectID());
      subjectById.ifPresent(subject -> subject.decreasePoints(event.getPoints()));
    });

    apply((SubjectTotalHoursAdded event) -> {
      Optional<Subject> subjectById = faculty.getSubjectById(event.getSubjectID());
      subjectById.ifPresent(subject -> subject.addTotalHours(event.getTotalHours()));
    });

    apply((SubjectTotalHoursSubtracted event) -> {
      Optional<Subject> subjectById = faculty.getSubjectById(event.getSubjectID());
      subjectById.ifPresent(subject -> subject.subtractTotalHours(event.getTotalHours()));
    });

    apply((SubjectProfessorAssigned event) -> {
      Optional<Subject> subjectById = faculty.getSubjectById(event.getSubjectID());
      subjectById.ifPresent(subject -> subject.assignProfessorID(event.getProfessorID()));
    });

    apply((StudentBirthDay event) -> {
      Optional<Student> studentById = faculty.getStudentById(event.getStudentID());
      studentById.ifPresent(Student::turnYears);
    });

    apply((StudentSubjectAssigned event) -> {
      Optional<Student> studentById = faculty.getStudentById(event.getStudentID());
      studentById.ifPresent(student -> student.assignSubject(event.getSubjectID()));
    });

    apply((StudentSubjectComplete event) -> {
      Optional<Student> studentById = faculty.getStudentById(event.getStudentID());
      studentById.ifPresent(student -> student.completeSubject(event.getSubjectID()));
    });

    apply((ProfessorExpertiseIncreased event) -> {
      Optional<Professor> professorById = faculty.getProfessorById(event.getProfessorID());
      professorById.ifPresent(Professor::turnExpertiseYears);
    });

    apply((StudentSemesterPassed event) -> {
      Optional<Student> studentById = faculty.getStudentById(event.getStudentID());
      studentById.ifPresent(student -> {
        Director director = faculty.director;
        if(director == null) return;
        if(director.identity() == event.getDirectorID()) director.passStudentSemester(student);
      });
    });

    apply((ProfessorTitleAdded event) -> {
      Optional<Professor> professorById = faculty.getProfessorById(event.getProfessorID());
      professorById.ifPresent(professor -> {
        professor.addTitle(event.getTitle());
      });
    });

    apply((DirectorYearInChargeRenewed event) -> {
      Director director = faculty.director;
      if(director == null) return;
      if(director.identity() == event.getDirectorID()) director.renewYearInCharge();
    });

    apply((StudentGraduated event) -> {
      Optional<Student> studentById = faculty.getStudentById(event.getStudentID());
      studentById.ifPresent(student -> {
        Director director = faculty.director;
        if(director == null) return;
        if(director.identity() == event.getDirectorID()) director.graduateStudent(student);
      });
    });

    apply((StudentExpulsed event) -> {
      Director director = faculty.director;
      if(director == null) return;
      if(director.identity() == event.getDirectorID()) director.expulseStudent(faculty.students, event.getStudentID());
    });

    apply((ProfessorFired event) -> {
      Director director = faculty.director;
      if(director == null) return;
      if(director.identity() == event.getDirectorID()) director.fireProfessor(faculty.professors, event.getProfessorID());
    });
  }
}
