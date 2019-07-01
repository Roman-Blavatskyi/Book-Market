package ua.lviv.market.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.lviv.market.Entity.Author;
import ua.lviv.market.dao.AuthorDao;
import ua.lviv.market.service.AuthorService;

/**
 * Created by Roman on 25.05.2017.
 */
@Service
@Transactional
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    private AuthorDao authorDao;

    public void add(String name, String surname, int age, String country, String urlImage) {
        Author author = new Author(name,surname,age,country,urlImage);
        authorDao.add(author);
    }

    public void edit(int id, String name, String surname, int age, String country, String urlImage) {
        Author author = authorDao.findById(id);

        if(name!=null && !name.equalsIgnoreCase("")){
            author.setName(name);
        }

        if(surname!=null && !surname.equalsIgnoreCase("")){
            author.setSurname(surname);
        }

        if(age!=0){
            author.setAge(age);
        }

        if(country!=null && !country.equalsIgnoreCase("")){
            author.setCountry(country);
        }

        if(urlImage!=null && !urlImage.equalsIgnoreCase("")){
            author.setUrlImage(urlImage);
        }

        authorDao.edit(author);

    }

    public void remove(int id) {
        authorDao.delete(authorDao.findById(id));
    }

    public Author findById(int id) {
        return authorDao.findById(id);
    }
}
