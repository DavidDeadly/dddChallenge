package co.david.challengeddd.usecase.faculty;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.david.challengeddd.domain.faculty.commands.CreateFaculty;
import co.david.challengeddd.domain.faculty.events.FacultyCreated;
import co.david.challengeddd.domain.faculty.values.ActiveYears;
import co.david.challengeddd.domain.faculty.values.FacultyID;
import co.david.challengeddd.domain.faculty.values.FacultyName;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
class CreateFacultyUseCaseTest {

  @Test
  void createFacultyUseCaseTest() {
    CreateFaculty createCommand = new CreateFaculty(
            new FacultyID("231432"),
            new FacultyName("Physics"),
            new ActiveYears(5)
    );

    CreateFacultyUseCase createUseCase = new CreateFacultyUseCase();

    List<DomainEvent> domainEvents = UseCaseHandler
            .getInstance()
            .syncExecutor(createUseCase, new RequestCommand<>(createCommand))
            .orElseThrow(() -> new IllegalStateException("CreateFacultyCommand went wrong"))
            .getDomainEvents();

    FacultyCreated createEvent = (FacultyCreated) domainEvents.get(0);

    Assertions.assertEquals(
            createCommand.getFacultyName().value(), createEvent.getFacultyName().value()
    );
  }
}