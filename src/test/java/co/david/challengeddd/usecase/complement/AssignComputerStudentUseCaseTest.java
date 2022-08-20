package co.david.challengeddd.usecase.complement;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.david.challengeddd.domain.complement.commands.AssignComputerStudentID;
import co.david.challengeddd.domain.complement.commands.BuyComputer;
import co.david.challengeddd.domain.complement.events.ComplementCreated;
import co.david.challengeddd.domain.complement.events.ComputerBuyed;
import co.david.challengeddd.domain.complement.events.ComputerStudentIDAssigned;
import co.david.challengeddd.domain.complement.values.*;
import co.david.challengeddd.domain.faculty.values.FacultyID;
import co.david.challengeddd.domain.faculty.values.FacultyName;
import co.david.challengeddd.domain.faculty.values.StudentID;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class AssignComputerStudentUseCaseTest {

  private final String ROOT_ID = "32173";

  @Mock
  private DomainEventRepository repository;

  @Test
  void assignComputerStudentUseCaseTest() {
    ComplementCreated createEvent = new ComplementCreated(
            new FacultyID("92183"),
            new FacultyName("Software")
    );
    createEvent.setAggregateRootId(ROOT_ID);

    ComputerBuyed buyEvent = new ComputerBuyed(
      new ComputerID("72123"),
      new Brand("HP"),
      new Cpu("Intel Core 7"),
      new Ram(8)
    );

    AssignComputerStudentID assignComputerCommand = new AssignComputerStudentID(
      new ComplementID(ROOT_ID),
      buyEvent.getComputerID(),
      new StudentID("737132")
    );

    AssignComputerStudentUseCase assignComputerStudentUseCase = new AssignComputerStudentUseCase();

    Mockito.when(repository.getEventsBy(ROOT_ID)).thenReturn(List.of(createEvent, buyEvent));
    assignComputerStudentUseCase.addRepository(repository);

    List<DomainEvent> domainEvents = UseCaseHandler
            .getInstance()
            .syncExecutor(assignComputerStudentUseCase, new RequestCommand<>(assignComputerCommand))
            .orElseThrow()
            .getDomainEvents();

    ComputerStudentIDAssigned domainEvent = (ComputerStudentIDAssigned) domainEvents.get(0);

    Assertions.assertEquals(assignComputerCommand.getStudentID().value(), domainEvent.getStudentID().value());
  }
}