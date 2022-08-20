package co.david.challengeddd.usecase.complement;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.david.challengeddd.domain.complement.commands.AddBook;
import co.david.challengeddd.domain.complement.events.BookAdded;
import co.david.challengeddd.domain.complement.events.ComplementCreated;
import co.david.challengeddd.domain.complement.values.*;
import co.david.challengeddd.domain.faculty.values.FacultyID;
import co.david.challengeddd.domain.faculty.values.FacultyName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class AddBookUseCaseTest {

  private final String ROOT_ID = "47238";

  @Mock
  private DomainEventRepository repository;

  @Test
  void addBookUseCaseTest() {

    ComplementCreated createEvent = new ComplementCreated(
            new FacultyID("723173"),
            new FacultyName("Literature")
    );
    createEvent.setAggregateRootId(ROOT_ID);

    AddBook bookCommand = new AddBook(
            new ComplementID(ROOT_ID),
            new BookID("83128"),
            new BookTitle("Why read save lifes?"),
            Set.of(new Author("David Rueda")),
            new Pages(450)
    );

    AddBookUseCase addBookUseCase = new AddBookUseCase();

    Mockito.when(repository.getEventsBy(ROOT_ID)).thenReturn(List.of(createEvent));
    addBookUseCase.addRepository(repository);

    List<DomainEvent> domainEvents = UseCaseHandler
            .getInstance()
            .syncExecutor(addBookUseCase, new RequestCommand<>(bookCommand))
            .orElseThrow()
            .getDomainEvents();

    BookAdded domainEvent = (BookAdded) domainEvents.get(0);

    assertEquals(bookCommand.getBookTitle().value(), domainEvent.getBookTitle().value());


  }

}