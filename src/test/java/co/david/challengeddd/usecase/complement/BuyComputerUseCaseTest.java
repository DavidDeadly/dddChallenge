package co.david.challengeddd.usecase.complement;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.david.challengeddd.domain.complement.commands.BuyComputer;
import co.david.challengeddd.domain.complement.events.ComplementCreated;
import co.david.challengeddd.domain.complement.events.ComputerBuyed;
import co.david.challengeddd.domain.complement.values.*;
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
class BuyComputerUseCaseTest {

  private final String ROOT_ID = "89123";

  @Mock
  private DomainEventRepository repository;

  @Test
  void buyComputerUseCaseTest() {
    ComplementCreated createEvent = new ComplementCreated(
      new FacultyID("317232"),
      new FacultyName("Math")
    );
    createEvent.setAggregateRootId(ROOT_ID);

    BuyComputer buyCommand = new BuyComputer(
      new ComplementID(ROOT_ID),
      new ComputerID("39127"),
      new Brand("HP"),
      new Cpu("Intel Core 5"),
      new Ram(4)
    );

    BuyComputerUseCase buyComputerUseCase = new BuyComputerUseCase();

    Mockito.when(repository.getEventsBy(ROOT_ID)).thenReturn(List.of(createEvent));
    buyComputerUseCase.addRepository(repository);

    List<DomainEvent> domainEvents = UseCaseHandler
            .getInstance()
            .syncExecutor(buyComputerUseCase, new RequestCommand<>(buyCommand))
            .orElseThrow()
            .getDomainEvents();

    ComputerBuyed domainEvent = (ComputerBuyed) domainEvents.get(0);

    assertEquals(buyCommand.getBrand().value(), domainEvent.getBrand().value());
  }

}