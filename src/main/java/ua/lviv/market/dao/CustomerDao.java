package ua.lviv.market.dao;

import ua.lviv.market.Entity.Customer;

/**
 * Created by Roman on 01.05.2017.
 */
public interface CustomerDao {

    void add(Customer customer);

    void edit(Customer customer);

    void remove(Customer customer);

    Customer findById(int id);

    Customer findByLogin(String login);

}
