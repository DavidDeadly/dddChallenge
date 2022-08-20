package co.david.challengeddd.usecase.faculty;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.david.challengeddd.domain.faculty.Faculty;
import co.david.challengeddd.domain.faculty.commands.AddSubject;

public class AddSubjectUseCase extends UseCase<RequestCommand<AddSubject>, ResponseEvents> {

  @Override
  public void executeUseCase(RequestCommand<AddSubject> addSubjectRequestCommand) {
    AddSubject addCommand = addSubjectRequestCommand.getCommand();

    Faculty faculty = Faculty.from(
      addCommand.getFacultyID(),
      retrieveEvents(addCommand.getFacultyID().value()
    ));

    faculty.addSubject(
      addCommand.getSubjectID(),
      addCommand.getSubjectName(),
      addCommand.getPoints(),
      addCommand.getHours()
    );

    emit().onResponse(new ResponseEvents(faculty.getUncommittedChanges()));
  }
}
