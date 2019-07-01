package ua.lviv.market.dao;

import ua.lviv.market.Entity.Author;
import ua.lviv.market.Entity.Book;

import java.util.List;

/**
 * Created by Roman on 25.05.2017.
 */
public interface AuthorDao {

    void add(Author author);

    void edit(Author author);

    void delete(Author author);

    Author findById(int id);



}
