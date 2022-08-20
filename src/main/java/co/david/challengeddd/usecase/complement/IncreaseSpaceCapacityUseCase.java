package co.david.challengeddd.usecase.complement;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.david.challengeddd.domain.complement.Complement;
import co.david.challengeddd.domain.complement.commands.IncreaseSpaceCapacity;

public class IncreaseSpaceCapacityUseCase extends UseCase<RequestCommand<IncreaseSpaceCapacity>, ResponseEvents> {

  @Override
  public void executeUseCase(RequestCommand<IncreaseSpaceCapacity> increaseSpaceCapacityRequestCommand) {
    IncreaseSpaceCapacity command = increaseSpaceCapacityRequestCommand.getCommand();

    Complement complement = Complement.from(
            command.getComplementID(),
            retrieveEvents(command.getComplementID().value())
    );

    complement.increaseSpaceCapacity(
        command.getSpaceID(),
        command.getCapacity()
    );

    emit().onResponse(new ResponseEvents(complement.getUncommittedChanges()));

  }
}
