package co.david.challengeddd.domain.complement;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import co.david.challengeddd.domain.complement.events.*;
import co.david.challengeddd.domain.complement.values.*;
import co.david.challengeddd.domain.faculty.values.FacultyID;
import co.david.challengeddd.domain.faculty.values.FacultyName;
import co.david.challengeddd.domain.faculty.values.StudentID;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public class Complement extends AggregateEvent<ComplementID> {

  private FacultyName facultyName;
  private FacultyID facultyID;
  private Set<Book> books;
  private Set<Space> spaces;
  private Set<Computer> computers;

  public Complement(ComplementID complementID, FacultyID facultyId, FacultyName facultyName) {
    super(complementID);
    appendChange(new ComplementCreated(facultyId, facultyName)).apply();
  }

  private Complement(ComplementID complementID) {
    super(complementID);
    subscribe(new ComplementChange(this));
  }

  public static Complement from(ComplementID complementID, List<DomainEvent> events) {
    Complement complement = new Complement(complementID);
    events.forEach(complement::applyEvent);
    return complement;
  }

  public void renameFaculty(FacultyName facultyName) {
    appendChange(new FacultyRenamed(facultyName)).apply();
  }

  public void addBook(BookID bookId) {
    appendChange(new BookAdded(bookId)).apply();
  }

  public void removeBook(BookID bookId) {
    appendChange(new BookRemoved(bookId)).apply();
  }

  public void registerSpace(SpaceID spaceID) {
    appendChange(new SpaceRegistered(spaceID)).apply();
  }

  public void buyComputer(ComputerID computerId) {
    appendChange(new ComputerBuyed(computerId)).apply();
  }

  public void throwComputer(ComputerID computerID) {
    appendChange(new ComputerThrown(computerID)).apply();
  }

  public void reflectCapacitySpaceInType(SpaceID spaceId, Capacity capacity) {
    appendChange(new CapacityInTypeSpaceReflected(spaceId, capacity)).apply();
  }

  public void increaseSpaceCapacity(SpaceID spaceId, Capacity capacity) {
    appendChange(new SpaceCapacityIncreased(spaceId, capacity)).apply();
  }

  public void decreaseSpaceCapacity(SpaceID spaceID, Capacity capacity) {
    appendChange(new SpaceCapacityDecreased(spaceID, capacity)).apply();
  }

  public void assignSpaceBook(SpaceID spaceId, BookID bookId) {
    appendChange(new SpaceBookAssigned(spaceId, bookId)).apply();
  }

  public void retrieveSpaceBook(SpaceID spaceId, BookID bookId) {
    appendChange(new SpaceBookRetrieved(spaceId, bookId)).apply();
  }

  public void assignComputerStudentID(ComputerID computerId, StudentID studentId) {
    appendChange(new ComputerStudentIDAssigned(computerId, studentId)).apply();
  }

  public void removeComputerStudentID(ComputerID computerId, StudentID studentId) {
    appendChange(new ComputerStudentIDRetrieved(computerId, studentId)).apply();
  }

  public void remakeBookName(BookID bookID, BookTitle bookTitle) {
    appendChange(new BookNameRemade(bookID, bookTitle)).apply();
  }

  public void addBookAuthor(BookID bookID, Author author) {
    appendChange(new BookAuthorAdded(bookID, author)).apply();
  }

  public void removeBookAuthor(BookID bookID, Author author) {
    appendChange(new BookAuthorRemoved(bookID, author)).apply();
  }

  public void increaseBookPages(BookID bookID, Pages pages) {
    appendChange(new BookPagesIncreased(bookID, pages)).apply();
  }

  public void decreaseBookPages(BookID bookID, Pages pages) {
    appendChange(new BookPagesDecreased(bookID, pages)).apply();
  }


  public Optional<Space> getSpaceById(SpaceID spaceID){
    return spaces().stream()
            .filter(referee -> referee.identity().equals(spaceID))
            .findFirst();
  }

  public Optional<Computer> getComputerById(ComputerID computerID){
    return computers().stream()
            .filter(computer -> computer.identity().equals(computerID))
            .findFirst();
  }

  public Optional<Book> getBookById(BookID bookID){
    return books().stream()
            .filter(book -> book.identity().equals(bookID))
            .findFirst();
  }


  public FacultyName facultyName() {
    return facultyName;
  }

  public FacultyID facultyID() {
    return facultyID;
  }

  public Set<Book> books() {
    return books;
  }

  public Set<Space> spaces() {
    return spaces;
  }

  public Set<Computer> computers() {
    return computers;
  }
}
