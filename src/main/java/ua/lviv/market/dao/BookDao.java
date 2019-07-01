package ua.lviv.market.dao;

import ua.lviv.market.Entity.Book;

import java.util.List;

/**
 * Created by Roman on 01.05.2017.
 */
public interface BookDao {

    void add(Book book);

    void edit(Book book);

    void delete(Book book);

    Book findById(int id);

    List<Book> findByGenre(String genre);

    List<Book> findAll();

    List<Book> findByAuthorSurname(String surname);

}
