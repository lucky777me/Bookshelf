package lv.itlat.bookshelf.persistence.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name="User")
@Table(name="USER")
public class User implements Serializable {
    @Id
    @Column(name="Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
