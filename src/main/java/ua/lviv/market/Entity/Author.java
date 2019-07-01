package ua.lviv.market.Entity;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Roman on 25.05.2017.
 */
@Entity
@Table
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;
    @Column
    private String name;
    @Column
    private String surname;
    @Column(nullable = true)
    private int  age;
    @Column(nullable = true)
    private String country;
    @Column(nullable = true)
    private String urlImage;
    @OneToMany(mappedBy = "author",fetch = FetchType.EAGER)
    List<Book> bookList;
    public Author() {
    }

    public Author(String name, String surname, int age, String country, String urlImage) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.country = country;
        this.urlImage = urlImage;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }
}
