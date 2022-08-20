package co.david.challengeddd.usecase.faculty;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.david.challengeddd.domain.faculty.Faculty;
import co.david.challengeddd.domain.faculty.commands.AddSubject;
import co.david.challengeddd.domain.faculty.events.FacultyCreated;
import co.david.challengeddd.domain.faculty.events.SubjectAdded;
import co.david.challengeddd.domain.faculty.values.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
class AddSubjectUseCaseTest {

  private final String ROOT_ID = "138843";

  @Mock
  private DomainEventRepository repository;

  @Test
  void addSubjectUseCaseTest() {
    FacultyCreated createEvent = new FacultyCreated(
      new FacultyName("Music"),
      new ActiveYears(7)
    );
    createEvent.setAggregateRootId(ROOT_ID);

    AddSubject addCommand = new AddSubject(
      new FacultyID(ROOT_ID),
      new SubjectID("321312"),
      new SubjectName("Rithm"),
      new Points(23),
      new TotalHours(80)
    );

    AddSubjectUseCase addUseCase = new AddSubjectUseCase();

    Mockito.when(repository.getEventsBy(ROOT_ID)).thenReturn(List.of(createEvent));
    addUseCase.addRepository(repository);

    List<DomainEvent> domainEvents = UseCaseHandler
            .getInstance()
            .syncExecutor(addUseCase, new RequestCommand<>(addCommand))
            .orElseThrow()
            .getDomainEvents();


    SubjectAdded domainEvent = (SubjectAdded) domainEvents.get(0);

    Assertions.assertEquals(
    "Rithm", domainEvent.getSubjectName().value()
    );
  }
}