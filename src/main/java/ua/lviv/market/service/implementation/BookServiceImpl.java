package ua.lviv.market.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.lviv.market.Entity.Book;
import ua.lviv.market.dao.AuthorDao;
import ua.lviv.market.dao.BookDao;
import ua.lviv.market.service.BookService;

import java.util.List;

/**
 * Created by Roman on 02.05.2017.
 */
@Service
@Transactional
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDao bookDao;

    @Autowired
    private AuthorDao authorDao;

    public void add(String name,  String genre, double price, String description, String urlImage) {
        Book book = new Book(name, genre, price, description,urlImage);
        bookDao.add(book);
    }

    public void edit(int id, String name, String genre, double price, String description, String urlImage) {
        Book book= bookDao.findById(id);

        if(name!=null && !name.equalsIgnoreCase("")){
            book.setName(name);
        }


        if(genre!=null && !genre.equalsIgnoreCase("")){
            book.setGenre(genre);
        }

        if(price!=0){
            book.setPrice(price);
        }

        if(description!=null && !description.equalsIgnoreCase("")){
            book.setDescription(description);
        }

        if(urlImage!=null && !urlImage.equalsIgnoreCase("")){
            book.setUrlImage(urlImage);
        }

        bookDao.edit(book);

    }

    public void delete(int id) {
        bookDao.delete(bookDao.findById(id));
    }

    public Book findById(int id) {
        return bookDao.findById(id);
    }

    public List<Book> findByGenre(String genre) {
        return bookDao.findByGenre(genre);
    }

    public List<Book> findAll() {
        return bookDao.findAll();
    }

    public List<Book> findByAuthorSurname(String surname) {
        return bookDao.findByAuthorSurname(surname);
    }
}
