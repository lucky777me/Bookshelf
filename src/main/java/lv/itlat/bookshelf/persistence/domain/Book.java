package lv.itlat.bookshelf.persistence.domain;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity(name = "Book")
@Table(name = "BOOK")
public class Book implements Serializable {
    @Id
    @Column(name="Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Long id;

    @NotEmpty(message = "Title must not be empty")
    @Size(max=200)
    @Column(name="title" , length = 200, nullable=false)
    private String title;
    @NotEmpty
   @Size(min=10, max=50)
    @Column(name="isbn",length = 50 ,nullable = false,unique = true)
    private String isbn;
    @NotEmpty
    @Size(max=200)
    @Column(name="author", length = 200,nullable = false)
    private String author;
    @Min(value=1)
    @NotEmpty
    @NotNull
    @Column(name="year" ,nullable = false)
   private int year;
    @Size(max=1000)
    @Column(name="description",length=1000)
   private String description;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
