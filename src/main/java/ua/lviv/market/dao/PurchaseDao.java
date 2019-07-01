package ua.lviv.market.dao;

import ua.lviv.market.Entity.Purchase;

import java.util.List;

/**
 * Created by Roman on 01.05.2017.
 */
public interface PurchaseDao {

    void add(Purchase purchase);

    void edit(Purchase purchase);

    void remove(Purchase purchase);

    Purchase findById(int id);

    List<Purchase> findAllCustomerPurchases(String login);
}
