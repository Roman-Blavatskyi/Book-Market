package ua.lviv.market.Entity;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Roman on 01.05.2017.
 */
@Entity
@Table
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String genre;
    @Column(nullable = false)
    private double price;
    @Column(nullable = false)
    private String description;
    @Column(nullable = true)
    private String urlImage;
    @ManyToOne(fetch = FetchType.EAGER)
    private Author author;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "Book_Purchase", joinColumns = @JoinColumn(name = "bookId"),inverseJoinColumns = @JoinColumn(name = "purchaseId"))
    private List<Purchase> purchaseList;



    public Book() {
    }

    public Book(String name, String genre, double price, String description) {
        this.name = name;
        this.genre = genre;
        this.price = price;
        this.description = description;
    }

    public Book(String name, String genre, double price, String description, String urlImage) {
        this.name = name;
        this.genre = genre;
        this.price = price;
        this.description = description;
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

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public List<Purchase> getPurchaseList() {
        return purchaseList;
    }

    public void setPurchaseList(List<Purchase> purchaseList) {
        this.purchaseList = purchaseList;
    }
}
