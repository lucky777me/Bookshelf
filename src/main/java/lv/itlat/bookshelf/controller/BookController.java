package lv.itlat.bookshelf.controller;


import lv.itlat.bookshelf.persistence.domain.Book;
import lv.itlat.bookshelf.persistence.domain.Reservation;
import lv.itlat.bookshelf.persistence.domain.ReservationStatus;
import lv.itlat.bookshelf.persistence.repository.BookRepository;
import lv.itlat.bookshelf.persistence.repository.ReservationRepository;
import org.apache.log4j.Logger;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

@Named
@RequestScoped
public class BookController  {
    private Logger logger=Logger.getLogger(BookController.class);

    @Inject
    private CurrentUser currentUser;
    @Inject
    private BookRepository bookRepository;
    @Inject
    private ReservationRepository reservationRepository;
    private Long id;
    private Book book;

    public void openBook() {
        System.out.println("Open book " + id);
        book=bookRepository.findById(id);
    }

    public void reserve(Long id) {
        logger.info("Trying to reserve book" + id
        + "for user " + currentUser.getUser().getId());

      Book book = bookRepository.findById(id);

        Reservation reservation = new Reservation();
        reservation.setBook(book);
        reservation.setUser(currentUser.getUser());
        reservation.setStatus(ReservationStatus.RESERVED);
        reservationRepository.create(reservation);
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
