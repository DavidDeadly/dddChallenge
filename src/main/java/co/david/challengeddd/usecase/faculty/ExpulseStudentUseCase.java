package co.david.challengeddd.usecase.faculty;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.david.challengeddd.domain.faculty.Faculty;
import co.david.challengeddd.domain.faculty.commands.ExpulseStudent;

public class ExpulseStudentUseCase extends UseCase<RequestCommand<ExpulseStudent>, ResponseEvents> {

  @Override
  public void executeUseCase(RequestCommand<ExpulseStudent> expulseStudentRequestCommand) {
    ExpulseStudent expulseCommand = expulseStudentRequestCommand.getCommand();

    Faculty faculty = Faculty.from(
            expulseCommand.getFacultyID(),
            retrieveEvents(expulseCommand.getFacultyID().value())
    );


    faculty.expulseStudent(expulseCommand.getDirectorID(), expulseCommand.getStudentID());

    emit().onResponse(new ResponseEvents(faculty.getUncommittedChanges()));
  }
}
