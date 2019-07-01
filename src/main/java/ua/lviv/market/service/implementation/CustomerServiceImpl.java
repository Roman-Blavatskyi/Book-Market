package ua.lviv.market.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ua.lviv.market.Entity.Customer;
import ua.lviv.market.dao.CustomerDao;
import ua.lviv.market.service.CustomerService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Roman on 02.05.2017.
 */
@Service("userDetailsService")
public class CustomerServiceImpl implements CustomerService, UserDetailsService {

    @Autowired
    private CustomerDao customerDao;

    public void add(String name, String surname, String phone, String email, String login, String password, double discount) {
        Customer customer = new Customer(name, surname, phone, email, login, password, discount);
        customerDao.add(customer);
    }

    public void edit(int id, String name, String surname, String phone, String email, String login, String password, double discount) {
        Customer customer = customerDao.findById(id);

        if(name!=null && !name.equalsIgnoreCase("")){
            customer.setName(name);
        }

        if(surname!=null && !surname.equalsIgnoreCase("")){
            customer.setSurname(surname);
        }

        if(phone!=null && !phone.equalsIgnoreCase("")){
            customer.setPhone(phone);
        }

        if(email!=null && !email.equalsIgnoreCase("")){
            customer.setEmail(email);
        }

        if(login!=null && !login.equalsIgnoreCase("")){
            customer.setLogin(login);
        }

        if(password!=null && !password.equalsIgnoreCase("")){
            customer.setPassword(password);
        }

        if(discount!=0){
            customer.setDiscount(discount);
        }

        customerDao.edit(customer);

    }

    public void delete(int id) {
        customerDao.remove(customerDao.findById(id));
    }

    public Customer findById(int id) {
        return customerDao.findById(id);
    }

    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {

        Customer customer = customerDao.findByLogin(login);

        List<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();
        authorities.add(new SimpleGrantedAuthority("ROLE_USER"));

        return new User(customer.getLogin(), customer.getPassword(), authorities);
    }

    public Customer findByLogin(String login) {
        return customerDao.findByLogin(login);
    }
}
