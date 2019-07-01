package ua.lviv.market.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.market.Entity.Purchase;
import ua.lviv.market.dao.PurchaseDao;
import ua.lviv.market.service.PurchaseService;

import java.util.Date;
import java.util.List;

/**
 * Created by Roman on 02.05.2017.
 */
@Service
public class PurchaseServiceImpl implements PurchaseService {

    @Autowired
    private PurchaseDao purchaseDao;

    public void add(Purchase purchase) {
        purchaseDao.add(purchase);
    }

    public void edit(Purchase purchase) {
        purchaseDao.edit(purchase);
    }

    public void delete(int id) {
        purchaseDao.remove(purchaseDao.findById(id));
    }

    public Purchase findById(int id) {
        return purchaseDao.findById(id);
    }

    public List<Purchase> findAllCustomerPurchases(String login) {
        return purchaseDao.findAllCustomerPurchases(login);
    }
}
