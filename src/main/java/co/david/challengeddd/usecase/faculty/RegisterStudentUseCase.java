package co.david.challengeddd.usecase.faculty;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.david.challengeddd.domain.faculty.Faculty;
import co.david.challengeddd.domain.faculty.commands.RegisterStudent;

public class RegisterStudentUseCase extends UseCase<RequestCommand<RegisterStudent>, ResponseEvents> {

  @Override
  public void executeUseCase(RequestCommand<RegisterStudent> registerStudentRequestCommand) {
    RegisterStudent registerCommand = registerStudentRequestCommand.getCommand();

    Faculty faculty = Faculty.from(
            registerCommand.getFacultyID(),
            retrieveEvents(registerCommand.getFacultyID().value())
    );

    faculty.registerStudent(
            registerCommand.getStudentID(),
            registerCommand.getAccount(),
            registerCommand.getAge()
    );

    emit().onResponse(new ResponseEvents(faculty.getUncommittedChanges()));
  }
}
