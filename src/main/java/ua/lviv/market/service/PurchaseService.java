package ua.lviv.market.service;

import ua.lviv.market.Entity.Purchase;

import java.util.Date;
import java.util.List;

/**
 * Created by Roman on 02.05.2017.
 */
public interface PurchaseService {

    void add(Purchase purchase);

    void edit(Purchase purchase);

    void delete(int id);

    Purchase findById(int id);

    List<Purchase> findAllCustomerPurchases(String login);
}
