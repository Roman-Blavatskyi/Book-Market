package ua.lviv.market.dao.implementation;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ua.lviv.market.Entity.Purchase;
import ua.lviv.market.dao.PurchaseDao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by Roman on 02.05.2017.
 */
@Repository
public class PurchaseDaoImpl implements PurchaseDao{

    @PersistenceContext(unitName = "MainBook")
    private EntityManager entityManager;

    @Transactional
    public void add(Purchase purchase) {
        entityManager.persist(purchase);
    }

    @Transactional
    public void edit(Purchase purchase) {
        entityManager.merge(purchase);
    }

    @Transactional
    public void remove(Purchase purchase) {
        entityManager.remove(purchase);
    }

    @Transactional
    public Purchase findById(int id) {
        return entityManager.find(Purchase.class,id);
    }

    @Transactional
    public List<Purchase> findAllCustomerPurchases(String login) {
        return entityManager.createQuery("SELECT c FROM Purchase c where c.customer.login=:login").setParameter("login",login).getResultList();
    }
}
