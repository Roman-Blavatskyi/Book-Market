package ua.lviv.market.Entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * Created by Roman on 01.05.2017.
 */
@Entity
@Table
public class Purchase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;
    @Column(nullable = false)
    private double amount;
    @Column(nullable = true)
    private Date date;
    @ManyToOne
    private Customer customer;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "Book_Purchase",joinColumns = @JoinColumn(name = "purchaseId"),inverseJoinColumns = @JoinColumn(name = "bookId"))
    private List<Book> bookList;

    public Purchase() {
    }

    public Purchase(double amount, Date date) {
        this.amount = amount;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }
}
