package ua.lviv.market.service;

import ua.lviv.market.Entity.Author;

/**
 * Created by Roman on 25.05.2017.
 */
public interface AuthorService {

    void add(String name, String surname, int age, String country, String urlImage);

    void edit(int id,String name, String surname, int age, String country, String urlImage);

    void remove(int id);

    Author findById(int id);


}
