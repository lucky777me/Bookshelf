package lv.itlat.bookshelf.controller;

import lv.itlat.bookshelf.persistence.domain.Book;
import lv.itlat.bookshelf.persistence.repository.BookRepository;
import org.apache.log4j.Logger;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;


@Named
@RequestScoped
public class MyBooksController implements Serializable {
    private Logger logger = Logger.getLogger(MyBooksController.class);

    @Inject
    private BookRepository bookRepository;
    private List<Book> availableBooks ;
    private List<Book> reservedBooks;

    public void prepare(){
        availableBooks = bookRepository.retrieve();
    }
    public void reserve(Long id) {
        logger.info("Reservation by id" + id);
    }

    public List<Book> getAvailableBooks() {
        return availableBooks;
    }

    public void setAvailableBooks(List<Book> availableBooks) {
        this.availableBooks = availableBooks;
    }
}
