package co.david.challengeddd.usecase.faculty;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.TriggeredEvent;
import co.com.sofka.domain.generic.DomainEvent;
import co.david.challengeddd.domain.faculty.events.DirectorAssigned;
import co.david.challengeddd.domain.faculty.events.FacultyCreated;
import co.david.challengeddd.domain.faculty.values.ActiveYears;
import co.david.challengeddd.domain.faculty.values.FacultyName;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
class AssignDirectorUseCaseTest {

  private final String ROOT_ID = "2312312";

  @Mock
  private DomainEventRepository repository;

  @Test
  void assignDirectorUseCaseTest () {
    FacultyCreated createEvent = new FacultyCreated(
      new FacultyName("Philosophy"),
      new ActiveYears(2)
    );
    createEvent.setAggregateRootId(ROOT_ID);

    AssignDirectorUseCase defaultDirectorUseCase = new AssignDirectorUseCase();

    Mockito.when(repository.getEventsBy(ROOT_ID)).thenReturn(List.of(createEvent));

    defaultDirectorUseCase.addRepository(repository);

    List<DomainEvent> domainEvents = UseCaseHandler
            .getInstance()
            .setIdentifyExecutor(ROOT_ID)
            .syncExecutor(defaultDirectorUseCase, new TriggeredEvent<>(createEvent))
            .orElseThrow(() -> new IllegalStateException("Error assigning default director"))
            .getDomainEvents();

    DirectorAssigned domainEvent = (DirectorAssigned) domainEvents.get(0);

    Assertions.assertEquals(
    "DavidDeadly", domainEvent.getAccount().value().username()
    );

    Mockito.verify(repository).getEventsBy(ROOT_ID);

  }

}