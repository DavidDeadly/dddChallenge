package co.david.challengeddd.domain.complement;

import co.com.sofka.domain.generic.EventChange;
import co.david.challengeddd.domain.complement.events.*;

import java.util.HashSet;
import java.util.Optional;

public class ComplementChange extends EventChange {
  public ComplementChange(Complement complement) {
    apply((ComplementCreated event) -> {
      complement.facultyName = event.getFacultyName();
      complement.facultyID = event.getFacultyID();
      complement.books = new HashSet<>();
      complement.spaces = new HashSet<>();
      complement.computers = new HashSet<>();
    });

    apply((FacultyRenamed event) -> complement.facultyName = event.getFacultyName());

    apply((BookAdded event) -> complement.books.add(
      new Book(
        event.getBookID(),
        event.getBookTitle(),
        event.getAuthors(),
        event.getPages()
      )
    ));

    apply((BookRemoved event) -> complement.books.removeIf(book -> book.identity().equals(event.getBookID())));

    apply((SpaceRegistered event) -> complement.spaces.add(
      new Space(
        event.getSpaceID(),
        event.getSpaceName(),
        Space.getTypeOfSpace(event.getCapacity()),
        event.getCapacity(),
        new HashSet<>()
      )
    ));

    apply((ComputerBuyed event) -> complement.computers.add(
      new Computer(
        event.getComputerID(),
        event.getBrand(),
        event.getCpu(),
        event.getRam()
      )
    ));

    apply((ComputerThrown event) -> complement.computers.removeIf(computer -> computer.identity().equals(event.getComputerID())));

    apply((CapacityInTypeSpaceReflected event) -> {
      Optional<Space> spaceById = complement.getSpaceById(event.getSpaceID());
      spaceById.ifPresent(space -> space.reflectCapacityInType(Space.getTypeOfSpace(event.getCapacity())));
    });

    apply((SpaceCapacityIncreased event) -> {
      Optional<Space> spaceById = complement.getSpaceById(event.getSpaceID());
      spaceById.ifPresent(space -> space.increaseCapacity(event.getCapacity()));
    });

    apply((SpaceCapacityDecreased event) -> {
      Optional<Space> spaceById = complement.getSpaceById(event.getSpaceID());
      spaceById.ifPresent(space -> space.decreaseCapacity(event.getCapacity()));
    });

    apply((SpaceBookAssigned event) -> {
      Optional<Space> spaceById = complement.getSpaceById(event.getSpaceID());
      spaceById.ifPresent(space -> space.assignBook(event.getBookID()));
    });

    apply((SpaceBookRetrieved event) -> {
      Optional<Space> spaceById = complement.getSpaceById(event.getSpaceID());
      spaceById.ifPresent(space -> space.retrieveBook(event.getBookID()));
    });

    apply((ComputerStudentIDAssigned event) -> {
      Optional<Computer> computerById = complement.getComputerById(event.getComputerID());
      computerById.ifPresent(computer -> computer.assignStudentID(event.getStudentID()));
    });

    apply((ComputerStudentIDRetrieved event) -> {
      Optional<Computer> computerById = complement.getComputerById(event.getComputerID());
      computerById.ifPresent(computer -> computer.removeStudentID(event.getStudentID()));
    });

    apply((BookNameRemade event) -> {
      Optional<Book> bookById = complement.getBookById(event.getBookID());
      bookById.ifPresent(book -> book.remakeTitle(event.getTitle()));
    });

    apply((BookAuthorAdded event) -> {
      Optional<Book> bookById = complement.getBookById(event.getBookID());
      bookById.ifPresent(book -> book.addAuthor(event.getAuthor()));
    });

    apply((BookAuthorRemoved event) -> {
      Optional<Book> bookById = complement.getBookById(event.getBookID());
      bookById.ifPresent(book -> book.removeAuthor(event.getAuthor()));
    });

    apply((BookPagesIncreased event) -> {
      Optional<Book> bookById = complement.getBookById(event.getBookID());
      bookById.ifPresent(book -> book.increasePages(event.getPages()));
    });

    apply((BookPagesDecreased event) -> {
      Optional<Book> bookById = complement.getBookById(event.getBookID());
      bookById.ifPresent(book -> book.decreasePages(event.getPages()));
    });
  }
}
