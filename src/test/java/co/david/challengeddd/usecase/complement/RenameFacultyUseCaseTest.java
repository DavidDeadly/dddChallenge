package co.david.challengeddd.usecase.complement;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.TriggeredEvent;
import co.com.sofka.domain.generic.DomainEvent;
import co.david.challengeddd.domain.complement.commands.CreateComplement;
import co.david.challengeddd.domain.complement.commands.RenameFaculty;
import co.david.challengeddd.domain.complement.events.ComplementCreated;
import co.david.challengeddd.domain.complement.events.FacultyRenamed;
import co.david.challengeddd.domain.complement.values.ComplementID;
import co.david.challengeddd.domain.faculty.values.FacultyID;
import co.david.challengeddd.domain.faculty.values.FacultyName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class RenameFacultyUseCaseTest {

  private final String ROOT_ID = "283812";

  @Mock
  private DomainEventRepository repository;

  @Test
  void renameFacultyUseCaseTest() {
    ComplementCreated createEvent = new ComplementCreated(
      new FacultyID("81283"),
      new FacultyName("Sciences")
    );
    createEvent.setAggregateRootId(ROOT_ID);

    RenameFacultyUseCase renameFacultyUseCase = new RenameFacultyUseCase();

    Mockito.when(repository.getEventsBy(ROOT_ID)).thenReturn(List.of(createEvent));
    renameFacultyUseCase.addRepository(repository);

    List<DomainEvent> domainEvents = UseCaseHandler
            .getInstance()
            .syncExecutor(renameFacultyUseCase, new TriggeredEvent<>(createEvent))
            .orElseThrow()
            .getDomainEvents();

    FacultyRenamed domainEvent = (FacultyRenamed) domainEvents.get(0);

    assertEquals(createEvent.getFacultyName().value() + ".complemented", domainEvent.getFacultyName().value());

  }
}