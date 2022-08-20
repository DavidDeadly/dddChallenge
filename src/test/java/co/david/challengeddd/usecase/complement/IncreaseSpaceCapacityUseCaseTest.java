package co.david.challengeddd.usecase.complement;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.david.challengeddd.domain.complement.commands.IncreaseSpaceCapacity;
import co.david.challengeddd.domain.complement.events.ComplementCreated;
import co.david.challengeddd.domain.complement.events.SpaceCapacityIncreased;
import co.david.challengeddd.domain.complement.events.SpaceRegistered;
import co.david.challengeddd.domain.complement.values.Capacity;
import co.david.challengeddd.domain.complement.values.ComplementID;
import co.david.challengeddd.domain.complement.values.SpaceID;
import co.david.challengeddd.domain.complement.values.SpaceName;
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
class IncreaseSpaceCapacityUseCaseTest {
  private final String ROOT_ID = "73183";

  @Mock
  private DomainEventRepository repository;

  @Test
  void increaseSpaceCapacityUseCaseTest() {
    ComplementCreated createEvent = new ComplementCreated(
      new FacultyID("723712"),
      new FacultyName("Philosophy")
    );
    createEvent.setAggregateRootId(ROOT_ID);

    SpaceRegistered spaceEvent = new SpaceRegistered(
      new SpaceID("37283"),
      new SpaceName("Main ClassRoom"),
      new Capacity(35)
    );

    IncreaseSpaceCapacity increaseCommand = new IncreaseSpaceCapacity(
      new ComplementID(ROOT_ID),
      spaceEvent.getSpaceID(),
      new Capacity(60)
    );

    IncreaseSpaceCapacityUseCase increaseSpaceCapacityUseCase = new IncreaseSpaceCapacityUseCase();

    Mockito.when(repository.getEventsBy(ROOT_ID)).thenReturn(List.of(createEvent, spaceEvent));
    increaseSpaceCapacityUseCase.addRepository(repository);

    List<DomainEvent> domainEvents = UseCaseHandler
            .getInstance()
            .syncExecutor(increaseSpaceCapacityUseCase, new RequestCommand<>(increaseCommand))
            .orElseThrow()
            .getDomainEvents();

    SpaceCapacityIncreased domainEvent = (SpaceCapacityIncreased) domainEvents.get(0);

    assertEquals(increaseCommand.getCapacity().value(), domainEvent.getCapacity().value());
  }

}