package co.david.challengeddd.usecase.complement;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.david.challengeddd.domain.complement.Complement;
import co.david.challengeddd.domain.complement.commands.BuyComputer;

public class BuyComputerUseCase extends UseCase<RequestCommand<BuyComputer>, ResponseEvents> {

  @Override
  public void executeUseCase(RequestCommand<BuyComputer> buyComputerRequestCommand) {
    BuyComputer command = buyComputerRequestCommand.getCommand();

    Complement complement = Complement.from(
      command.getComplementID(),
      retrieveEvents(command.getComplementID().value())
    );

    complement.buyComputer(
      command.getComputerID(),
      command.getBrand(),
      command.getCpu(),
      command.getRam()
    );

    emit().onResponse(new ResponseEvents(complement.getUncommittedChanges()));
  }
}
