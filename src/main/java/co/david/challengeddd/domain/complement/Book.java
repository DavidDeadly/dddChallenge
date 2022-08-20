package co.david.challengeddd.domain.complement;

import co.com.sofka.domain.generic.Entity;
import co.david.challengeddd.domain.complement.values.Author;
import co.david.challengeddd.domain.complement.values.BookID;
import co.david.challengeddd.domain.complement.values.BookTitle;
import co.david.challengeddd.domain.complement.values.Pages;

import java.util.Set;

public class Book extends Entity<BookID> {

  private BookTitle bookTitle;
  private Set<Author> authors;
  private Pages pages;

  public Book(BookID bookID, BookTitle bookTitle, Set<Author> authors, Pages pages) {
    super(bookID);
    this.bookTitle = bookTitle;
    this.authors = authors;
    this.pages = pages;
  }

  public void remakeTitle(BookTitle bookTitle) {
    this.bookTitle = bookTitle;
  }

  public void addAuthor(Author author) {
    this.authors.add(author);
  }

  public void removeAuthor(Author author) {
    this.authors.removeIf(auth -> auth.value().equals(author.value()));
  }

  public void increasePages(Pages pages) {
    this.pages = new Pages(this.pages.value() + pages.value());
  }

  public void decreasePages(Pages pages) {
    this.pages = new Pages(this.pages.value() - pages.value());
  }

  public BookTitle BookTitle() {
    return bookTitle;
  }

  public Set<Author> Authors() {
    return authors;
  }

  public Pages Pages() {
    return pages;
  }
}
