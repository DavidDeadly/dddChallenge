package co.david.challengeddd.usecase.faculty;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.david.challengeddd.domain.faculty.Faculty;
import co.david.challengeddd.domain.faculty.commands.AssignSubjectProfessor;

public class AssignSubjectProfessorUseCase extends UseCase<RequestCommand<AssignSubjectProfessor>, ResponseEvents> {

  @Override
  public void executeUseCase(RequestCommand<AssignSubjectProfessor> assignSubjectProfessorRequestCommand) {
    AssignSubjectProfessor assignCommand = assignSubjectProfessorRequestCommand.getCommand();

    Faculty faculty = Faculty.from(
      assignCommand.getFacultyID(),
      retrieveEvents(assignCommand.getFacultyID().value())
    );

    faculty.assignSubjectProfessor(assignCommand.getSubjectID(), assignCommand.getProfessorID());

    emit().onResponse(new ResponseEvents(faculty.getUncommittedChanges()));
  }
}
