package co.david.challengeddd.usecase.complement;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.david.challengeddd.domain.complement.commands.CreateComplement;
import co.david.challengeddd.domain.complement.events.ComplementCreated;
import co.david.challengeddd.domain.complement.values.ComplementID;
import co.david.challengeddd.domain.faculty.values.FacultyID;
import co.david.challengeddd.domain.faculty.values.FacultyName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CreateComplementUseCaseTest {

  @Test
  void createComplementUseCaseTest() {
    CreateComplement createCommand = new CreateComplement(
      new ComplementID("231238"),
      new FacultyID("3218323"),
      new FacultyName("Physics")
    );

    CreateComplementUseCase createComplementUseCase = new CreateComplementUseCase();

    List<DomainEvent> domainEvents = UseCaseHandler
            .getInstance()
            .syncExecutor(createComplementUseCase, new RequestCommand<>(createCommand))
            .orElseThrow()
            .getDomainEvents();

    ComplementCreated domainEvent = (ComplementCreated) domainEvents.get(0);

    assertEquals(createCommand.getFacultyName().value(), domainEvent.getFacultyName().value());
  }

}