package co.david.challengeddd.usecase.faculty;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;
import co.david.challengeddd.domain.faculty.Faculty;
import co.david.challengeddd.domain.faculty.events.FacultyCreated;
import co.david.challengeddd.domain.faculty.values.Account;
import co.david.challengeddd.domain.faculty.values.DirectorID;
import co.david.challengeddd.domain.faculty.values.FacultyID;

public class AssignDirectorUseCase extends UseCase<TriggeredEvent<FacultyCreated>, ResponseEvents> {

  @Override
  public void executeUseCase(TriggeredEvent<FacultyCreated> facultyCreatedTriggeredEvent) {
    FacultyCreated domainEvent = facultyCreatedTriggeredEvent.getDomainEvent();
    Faculty faculty = Faculty.from(FacultyID.of(domainEvent.aggregateRootId()), retrieveEvents());

    DirectorID universityDirector = new DirectorID("2312321");
    Account universityDirectorAccount = new Account("DavidDeadly", "david@mail.com");

    faculty.assignDirector(universityDirector, universityDirectorAccount);

    emit().onResponse(new ResponseEvents(faculty.getUncommittedChanges()));
  }
}
