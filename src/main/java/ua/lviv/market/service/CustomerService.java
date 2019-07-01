package ua.lviv.market.service;

import ua.lviv.market.Entity.Customer;

/**
 * Created by Roman on 02.05.2017.
 */
public interface CustomerService {

    void add(String name, String surname, String phone, String email, String login, String password, double discount);

    void edit(int id, String name, String surname, String phone, String email, String login, String password, double discount);

    void delete(int id);

    Customer findById(int id);

    Customer findByLogin(String login);
}
