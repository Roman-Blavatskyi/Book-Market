package ua.lviv.market.dao.implementation;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ua.lviv.market.Entity.Book;
import ua.lviv.market.dao.BookDao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by Roman on 01.05.2017.
 */
@Repository
@Transactional
public class BookDaoImpl implements BookDao {

    @PersistenceContext(unitName = "MainBook")
    private EntityManager entityManager;

    @Transactional
    public void add(Book book) {
        entityManager.persist(book);
    }
    @Transactional
    public void edit(Book book) {
        entityManager.merge(book);
    }
    @Transactional
    public void delete(Book book) {
        entityManager.remove(book);
    }
    @Transactional
    public Book findById(int id) {
        return entityManager.find(Book.class,id);
    }
    @Transactional
    public List<Book> findByGenre(String genre) {
        return entityManager.createQuery("from Book where genre like ?1").setParameter(1,genre).getResultList();
    }

    @Transactional
    public List<Book> findAll() {
        return entityManager.createQuery("SELECT c FROM Book c").getResultList();
    }

    @Transactional
    public  List<Book> findByAuthorSurname(String surname){
        return  entityManager.createQuery("FROM Book where author.surname = ?1").setParameter(1,surname).getResultList();
    }
}
