package co.david.challengeddd.usecase.complement;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.david.challengeddd.domain.complement.Complement;
import co.david.challengeddd.domain.complement.commands.AssignComputerStudentID;

public class AssignComputerStudentUseCase extends UseCase<RequestCommand<AssignComputerStudentID>, ResponseEvents> {

  @Override
  public void executeUseCase(RequestCommand<AssignComputerStudentID> assignComputerStudentIDRequestCommand) {
    AssignComputerStudentID command = assignComputerStudentIDRequestCommand.getCommand();

    Complement complement = Complement.from(
      command.getComplementID(),
      retrieveEvents(command.getComplementID().value())
    );

    complement.assignComputerStudentID(command.getComputerID(), command.getStudentID());

    emit().onResponse(new ResponseEvents(complement.getUncommittedChanges()));
  }
}
