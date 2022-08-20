package co.david.challengeddd.usecase.faculty;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.david.challengeddd.domain.faculty.commands.RegisterStudent;
import co.david.challengeddd.domain.faculty.events.FacultyCreated;
import co.david.challengeddd.domain.faculty.events.StudentRegistered;
import co.david.challengeddd.domain.faculty.values.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class RegisterStudentUseCaseTest {

  private final String ROOT_ID = "102589";

  @Mock
  private DomainEventRepository repository;

  @Test
  void registerStudentUseCaseTest() {
    FacultyCreated createEvent = new FacultyCreated(
            new FacultyName("Physics"),
            new ActiveYears(15)
    );
    createEvent.setAggregateRootId(ROOT_ID);

    RegisterStudent registerCommand = new RegisterStudent(
            FacultyID.of(ROOT_ID),
            new StudentID("231312"),
            new Account("MiCuadrado", "micuadrado@email.com"),
            new Age(19)
    );

    RegisterStudentUseCase registerUseCase = new RegisterStudentUseCase();

    Mockito.when(repository.getEventsBy(ROOT_ID)).thenReturn(List.of(createEvent));
    registerUseCase.addRepository(repository);

    List<DomainEvent> domainEvents = UseCaseHandler
            .getInstance()
            .syncExecutor(registerUseCase, new RequestCommand<>(registerCommand))
            .orElseThrow()
            .getDomainEvents();

    StudentRegistered domainEvent = (StudentRegistered) domainEvents.get(0);

    Assertions.assertEquals(
      registerCommand.getAge().value(), domainEvent.getAge().value()
    );
  }

}