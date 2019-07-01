package ua.lviv.market.dao.implementation;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ua.lviv.market.Entity.Author;
import ua.lviv.market.Entity.Book;
import ua.lviv.market.dao.AuthorDao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by Roman on 25.05.2017.
 */
@Repository
@Transactional
public class AuthorDaoImpl implements AuthorDao{

    @PersistenceContext(unitName = "MainBook")
    private EntityManager entityManager;

    @Transactional
    public void add(Author author) { entityManager.persist(author);
    }
    @Transactional
    public void edit(Author author) {
        entityManager.merge(author);
    }
    @Transactional
    public void delete(Author author) {
        entityManager.remove(author);
    }
    @Transactional
    public Author findById(int id) {
        return entityManager.find(Author.class,id);
    }

}
