package co.david.challengeddd.usecase.faculty;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.david.challengeddd.domain.faculty.Faculty;
import co.david.challengeddd.domain.faculty.Student;
import co.david.challengeddd.domain.faculty.commands.ExpulseStudent;
import co.david.challengeddd.domain.faculty.commands.RegisterStudent;
import co.david.challengeddd.domain.faculty.events.DirectorAssigned;
import co.david.challengeddd.domain.faculty.events.FacultyCreated;
import co.david.challengeddd.domain.faculty.events.StudentExpulsed;
import co.david.challengeddd.domain.faculty.events.StudentRegistered;
import co.david.challengeddd.domain.faculty.values.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Set;

@ExtendWith(MockitoExtension.class)
class ExpulseStudentUseCaseTest {

  private final String ROOT_ID = "84853";

  @Mock
  private DomainEventRepository repository;

  @Test
  void expulseStudentUseCaseTest() {
    FacultyCreated createEvent = new FacultyCreated(
            new FacultyName("Music"),
            new ActiveYears(7)
    );
    createEvent.setAggregateRootId(ROOT_ID);

    StudentRegistered registerEvent = new StudentRegistered(
            new StudentID("1029821"),
            new Account("Henry Magüiro", "guiro@mail.com"),
            new Age(24)
    );

    DirectorAssigned directorEvent = new DirectorAssigned(
            new DirectorID("218321"),
            new Account("Zizou", "zizou@mail.com")
    );

    ExpulseStudent expulseCommand = new ExpulseStudent(
            FacultyID.of(ROOT_ID),
            directorEvent.getDirectorID(),
            registerEvent.getStudentID()
    );

    ExpulseStudentUseCase expulseUseCase = new ExpulseStudentUseCase();

    Mockito.when(repository.getEventsBy(ROOT_ID)).thenReturn(List.of(createEvent, directorEvent, registerEvent));
    expulseUseCase.addRepository(repository);

    List<DomainEvent> domainEvents = UseCaseHandler
      .getInstance()
      .syncExecutor(expulseUseCase, new RequestCommand<>(expulseCommand))
      .orElseThrow()
      .getDomainEvents();

    StudentExpulsed domainEvent = (StudentExpulsed) domainEvents.get(0);


//    Mockito.when(repository.getEventsBy(ROOT_ID)).thenReturn(List.of(createEvent, directorEvent, registerEvent, domainEvent));
//    Set<Student> students = Faculty.from(FacultyID.of(ROOT_ID), expulseUseCase.retrieveEvents(ROOT_ID)).students();
//    Assertions.assertEquals(expulseCommand.getStudentID(), domainEvent.getStudentID());
    Assertions.assertEquals(expulseCommand.getStudentID(), domainEvent.getStudentID());

  }
}