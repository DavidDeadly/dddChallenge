package co.david.challengeddd.usecase.faculty;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.david.challengeddd.domain.faculty.commands.AddSubject;
import co.david.challengeddd.domain.faculty.commands.AssignSubjectProfessor;
import co.david.challengeddd.domain.faculty.commands.HireProfessor;
import co.david.challengeddd.domain.faculty.events.FacultyCreated;
import co.david.challengeddd.domain.faculty.events.ProfessorHired;
import co.david.challengeddd.domain.faculty.events.SubjectAdded;
import co.david.challengeddd.domain.faculty.events.SubjectProfessorAssigned;
import co.david.challengeddd.domain.faculty.values.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class AssignSubjectProfessorUseCaseTest {

  private final String ROOT_ID = "732837";

  @Mock
  private DomainEventRepository repository;

  @Test
  void assignSubjectProfessorUseCaseTest() {
    FacultyCreated createEvent = new FacultyCreated(
            new FacultyName("Medicine"),
            new ActiveYears(20)
    );
    createEvent.setAggregateRootId(ROOT_ID);

    SubjectAdded surgeryEvent = new SubjectAdded(
            new SubjectID("71327"),
            new SubjectName("Sirgury"),
            new Points(15),
            new TotalHours(35)
    );

    ProfessorHired professorEvent = new ProfessorHired(
      new ProfessorID("2381823812"),
      new Account("Sandra Jaramillo", "droop@mail.com"),
      new YearsOfExperience(2),
      List.of(new Title("engineer"))
    );

    AssignSubjectProfessor assignCommand = new AssignSubjectProfessor(
      FacultyID.of(ROOT_ID),
      surgeryEvent.getSubjectID(),
      professorEvent.getProfessorID()
    );

    AssignSubjectProfessorUseCase assignSubjectProfessorUseCase = new AssignSubjectProfessorUseCase();

    Mockito.when(repository.getEventsBy(ROOT_ID)).thenReturn(List.of(createEvent, surgeryEvent, professorEvent));
    assignSubjectProfessorUseCase.addRepository(repository);

    List<DomainEvent> domainEvents = UseCaseHandler
            .getInstance()
            .syncExecutor(assignSubjectProfessorUseCase, new RequestCommand<>(assignCommand))
            .orElseThrow()
            .getDomainEvents();

    SubjectProfessorAssigned domainEvent = (SubjectProfessorAssigned) domainEvents.get(0);

    Assertions.assertEquals(assignCommand.getSubjectID().value(), domainEvent.getSubjectID().value());
  }
}