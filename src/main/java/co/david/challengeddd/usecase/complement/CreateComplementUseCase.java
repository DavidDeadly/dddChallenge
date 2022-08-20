package co.david.challengeddd.usecase.complement;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.david.challengeddd.domain.complement.Complement;
import co.david.challengeddd.domain.complement.commands.CreateComplement;

public class CreateComplementUseCase extends UseCase<RequestCommand<CreateComplement>, ResponseEvents> {

  @Override
  public void executeUseCase(RequestCommand<CreateComplement> createComplementRequestCommand) {
    CreateComplement command = createComplementRequestCommand.getCommand();

    Complement complement = new Complement(
      command.getComplementID(),
      command.getFacultyID(),
      command.getFacultyName()
    );

    emit().onResponse(new ResponseEvents(complement.getUncommittedChanges()));
  }
}
