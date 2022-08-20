package co.david.challengeddd.usecase.faculty;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.david.challengeddd.domain.faculty.Faculty;
import co.david.challengeddd.domain.faculty.commands.CreateFaculty;

public class CreateFacultyUseCase extends UseCase<RequestCommand<CreateFaculty>, ResponseEvents> {

  @Override
  public void executeUseCase(RequestCommand<CreateFaculty> createFacultyRequestCommand) {
    CreateFaculty command = createFacultyRequestCommand.getCommand();
    Faculty faculty = new Faculty(
            command.getFacultyID(),
            command.getFacultyName(),
            command.getActiveYears()
    );

    emit().onResponse(new ResponseEvents(faculty.getUncommittedChanges()));
  }
}
