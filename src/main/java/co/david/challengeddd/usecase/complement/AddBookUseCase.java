package co.david.challengeddd.usecase.complement;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.david.challengeddd.domain.complement.Complement;
import co.david.challengeddd.domain.complement.commands.AddBook;

public class AddBookUseCase extends UseCase<RequestCommand<AddBook>, ResponseEvents> {

  @Override
  public void executeUseCase(RequestCommand<AddBook> addBookRequestCommand) {
    AddBook command = addBookRequestCommand.getCommand();

    Complement complement = Complement.from(
      command.getComplementID(),
      retrieveEvents(command.getComplementID().value())
    );

    complement.addBook(
      command.getBookID(),
      command.getBookTitle(),
      command.getAuthors(),
      command.getPages()
    );

    emit().onResponse(new ResponseEvents(complement.getUncommittedChanges()));
  }
}
