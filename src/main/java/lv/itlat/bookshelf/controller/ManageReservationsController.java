package lv.itlat.bookshelf.controller;

import lv.itlat.bookshelf.persistence.domain.Book;
import lv.itlat.bookshelf.persistence.domain.Reservation;
import lv.itlat.bookshelf.persistence.domain.ReservationStatus;
import lv.itlat.bookshelf.persistence.repository.ReservationRepository;
import org.apache.log4j.Logger;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
@RequestScoped
public class ManageReservationsController {

    private Logger logger = Logger.getLogger(ManageReservationsController.class);


    private List<Reservation> availableReservations;
    private List<Reservation> reservedReservations;
    private List<Reservation> notAvailableReservation;

    @Inject
    private ReservationRepository reservationRepository;

    public void prepare() {
        availableReservations = reservationRepository.getAvailableReservations();
        reservedReservations = reservationRepository.getReservedReservations();
        notAvailableReservation = reservationRepository.getNotAvailableReservations();
    }

    public void reserve(Long id) {
//        logger.info("Trying to reserve book " + id
//                + " for user " + currentUser.getUser().getId());
//
//        Book book = bookRepository.findById(id);
//
//        Reservation reservation = new Reservation();
//        reservation.setBook(book);
//        reservation.setUser(currentUser.getUser());
//        reservation.setStatus(ReservationStatus.RESERVED);
//        reservationRepository.create(reservation);
    }

    public List<Reservation> getAvailableReservations() {
        return availableReservations;
    }

    public void setAvailableReservations(List<Reservation> availableReservations) {
        this.availableReservations = availableReservations;
    }

    public List<Reservation> getReservedReservations() {
        return reservedReservations;
    }

    public void setReservedReservations(List<Reservation> reservedReservations) {
        this.reservedReservations = reservedReservations;
    }

    public List<Reservation> getNotAvailableReservation() {
        return notAvailableReservation;
    }

    public void setNotAvailableReservation(List<Reservation> notAvailableReservation) {
        this.notAvailableReservation = notAvailableReservation;
    }
}