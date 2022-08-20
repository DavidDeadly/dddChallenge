package co.david.challengeddd.usecase.complement;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;
import co.david.challengeddd.domain.complement.Complement;
import co.david.challengeddd.domain.complement.commands.RenameFaculty;
import co.david.challengeddd.domain.complement.events.ComplementCreated;
import co.david.challengeddd.domain.complement.values.ComplementID;
import co.david.challengeddd.domain.faculty.values.FacultyName;

public class RenameFacultyUseCase extends UseCase<TriggeredEvent<ComplementCreated>, ResponseEvents> {

  @Override
  public void executeUseCase(TriggeredEvent<ComplementCreated> complementCreatedTriggeredEvent) {
    ComplementCreated domainEvent = complementCreatedTriggeredEvent.getDomainEvent();

    Complement complement = Complement.from(
            new ComplementID(domainEvent.aggregateRootId()),
            retrieveEvents(domainEvent.aggregateRootId())
    );

    complement.renameFaculty(
      new FacultyName(
    domainEvent.getFacultyName().value() + ".complemented"
      )
    );

    emit().onResponse(new ResponseEvents(complement.getUncommittedChanges()));
  }
}
