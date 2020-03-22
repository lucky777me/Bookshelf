package lv.itlat.bookshelf.persistence.repository;

import lv.itlat.bookshelf.persistence.domain.Reservation;
import lv.itlat.bookshelf.persistence.domain.ReservationStatus;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;


@Named
@RequestScoped
public class ReservationRepository {


    @PersistenceContext(unitName = "bookshelfPU")
    private EntityManager em;

    public EntityManager getEntityManager() {
        return em;
    }

    @Transactional
    public Reservation create(Reservation reservation) {
        final EntityManager entityManager = getEntityManager();
        entityManager.persist(reservation);
        entityManager.flush();

        return reservation;
    }

    @Transactional
    public void update(Reservation reservation) {
        getEntityManager().merge(reservation);
    }

    public List<Reservation> retrieve() {
        return getEntityManager().createQuery("SELECT r FROM Reservation b", Reservation.class).getResultList();
    }

    public List<Reservation> getAvailableReservations() {
        return getReservationsByStatus(ReservationStatus.AVAILABLE);
    }

    public List<Reservation> getReservedReservations() {
        return getReservationsByStatus(ReservationStatus.RESERVED);
    }

    public List<Reservation> getNotAvailableReservations() {
        return getReservationsByStatus(ReservationStatus.NOT_AVAILABLE);
    }

    public Reservation findById(Long id) {
        return getEntityManager().find(Reservation.class, id);
    }

    private List<Reservation> getReservationsByStatus(ReservationStatus status) {
        return getEntityManager()
                .createQuery("SELECT r FROM Reservation r where r.status = :definedStatus")
                .setParameter("definedStatus", status)
                .getResultList();

    }

}