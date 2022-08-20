package co.david.challengeddd.domain.complement;

import co.com.sofka.domain.generic.Entity;
import co.david.challengeddd.domain.complement.values.*;

import java.util.Set;

public class Space extends Entity<SpaceID> {

  private SpaceName spaceName;
  private TypeOfSpace typeOfSpace;
  private Capacity capacity;
  private Set<BookID> books;

  public Space(SpaceID spaceID, SpaceName spaceName, TypeOfSpace typeOfSpace, Capacity capacity, Set<BookID> books) {
    super(spaceID);
    this.spaceName = spaceName;
    this.typeOfSpace = typeOfSpace;
    this.capacity = capacity;
    this.books = books;
  }

  public void remakeSpaceName(SpaceName spaceName) {
    this.spaceName = spaceName;
  }

  public void reflectCapacityInType(TypeOfSpace typeOfSpace) {
    this.typeOfSpace = typeOfSpace;
  }

  public static TypeOfSpace getTypeOfSpace(Capacity capacity) {
    return capacity.value() > 50 ?
      new TypeOfSpace(TypeOfSpaceE.auditorium)
      : new TypeOfSpace(TypeOfSpaceE.classroom);
  }

  public void increaseCapacity(Capacity capacity) {
    this.capacity = new Capacity(this.capacity.value() + capacity.value());
  }

  public void decreaseCapacity(Capacity capacity) {
    this.capacity = new Capacity(this.capacity.value() - capacity.value());
  }

  public void assignBook(BookID bookID) {
    this.books.add(bookID);
  }

  public void retrieveBook(BookID bookID) {
    this.books.removeIf(bookIdentity -> bookIdentity.value().equals(bookID.value()));
  }

  public SpaceName SpaceName() {
    return spaceName;
  }

  public TypeOfSpace TypeOfSpace() {
    return typeOfSpace;
  }

  public Capacity Capacity() {
    return capacity;
  }

  public Set<BookID> Books() {
    return books;
  }
}
