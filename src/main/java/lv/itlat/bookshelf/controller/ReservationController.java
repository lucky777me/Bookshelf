package lv.itlat.bookshelf.controller;

import lv.itlat.bookshelf.persistence.domain.Book;
import lv.itlat.bookshelf.persistence.domain.Reservation;
import lv.itlat.bookshelf.persistence.domain.ReservationStatus;
import lv.itlat.bookshelf.persistence.domain.User;
import lv.itlat.bookshelf.persistence.repository.BookRepository;
import lv.itlat.bookshelf.persistence.repository.ReservationRepository;
import lv.itlat.bookshelf.persistence.repository.UserRepository;
import org.apache.log4j.Logger;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.Optional;

import static lv.itlat.bookshelf.persistence.domain.ReservationStatus.*;

@Named
@RequestScoped
public class ReservationController {

    private Logger logger = Logger.getLogger(BookController.class);

    @Inject
    private CurrentUser currentUser;
    @Inject
    private BookRepository bookRepository;
    @Inject
    private ReservationRepository reservationRepository;
    @Inject
    private UserRepository userRepository;
    private Long id;
    private Reservation reservation;

    private String loginName;

    public void openReservation() {
        System.out.println("Opening book " + id);
        reservation = reservationRepository.findById(id);
    }

    public String reserve(Long id) {
        logger.info("Trying to reserve book " + id
                + " for user " + currentUser.getUser().getId());

        final Optional<User> foundedUser = userRepository.findByLoginName(loginName);
        final Reservation reservation = reservationRepository.findById(id);
        if (foundedUser.isPresent()) {
            final User user = foundedUser.get();
            reservation.setUser(user);
        }
        reservation.setStatus(RESERVED);
        reservationRepository.update(reservation);
        return "manage-reservations.xhtml";
    }

    public String available(Long id) {
        logger.info("Trying to reserve book " + id
                + " for user " + currentUser.getUser().getId());

        final Optional<User> foundedUser = userRepository.findByLoginName(loginName);
        final Reservation reservation = reservationRepository.findById(id);
        if (foundedUser.isPresent()) {
            final User user = foundedUser.get();
            reservation.setUser(user);
        }
        reservation.setStatus(AVAILABLE);
        reservationRepository.update(reservation);
        return "manage-reservations.xhtml";
    }

    public String notAvailable(Long id) {
        logger.info("Trying to reserve book " + id
                + " for user " + currentUser.getUser().getId());

        final Optional<User> foundedUser = userRepository.findByLoginName(loginName);
        final Reservation reservation = reservationRepository.findById(id);
        if (foundedUser.isPresent()) {
            final User user = foundedUser.get();
            reservation.setUser(user);
        }
        reservation.setStatus(NOT_AVAILABLE);
        reservationRepository.update(reservation);
        return "manage-reservations.xhtml";
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }
}