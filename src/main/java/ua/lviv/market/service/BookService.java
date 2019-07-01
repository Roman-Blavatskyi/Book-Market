package ua.lviv.market.service;

import ua.lviv.market.Entity.Book;

import java.util.List;

/**
 * Created by Roman on 02.05.2017.
 */
public interface BookService {

    void add(String name, String genre, double price, String description, String urlImage);

    void edit(int id, String name, String genre, double price, String description, String urlImage);

    void delete(int id);

    Book findById(int id);

    List<Book> findByGenre(String genre);

    List<Book> findAll();

    List<Book> findByAuthorSurname(String surname);
}
