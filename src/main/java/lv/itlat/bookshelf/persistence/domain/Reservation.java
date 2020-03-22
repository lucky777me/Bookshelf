package lv.itlat.bookshelf.persistence.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity(name="Reservation")
@Table(name="RESERVATION")
public class Reservation implements Serializable {
    @Id
    @Column(name= "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Book book;
    @ManyToOne
    private User user;
    @Column
    @Enumerated(EnumType.STRING)
    private ReservationStatus status;
    @Column
    private LocalDateTime created;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public ReservationStatus getStatus() {
        return status;
    }

    public void setStatus(ReservationStatus status) {
        this.status = status;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }
}
