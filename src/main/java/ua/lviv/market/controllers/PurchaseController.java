package ua.lviv.market.controllers;

import org.apache.http.protocol.HTTP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ua.lviv.market.Entity.Book;
import ua.lviv.market.Entity.Purchase;
import ua.lviv.market.service.BookService;
import ua.lviv.market.service.CustomerService;
import ua.lviv.market.service.PurchaseService;

import javax.servlet.http.HttpSession;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Roman on 09.05.2017.
 */
@Controller
public class PurchaseController {

    @Autowired
    private BookService bookService;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private PurchaseService purchaseService;

/*    @RequestMapping(value = "/purchase/{id}")
    public String purchase(@PathVariable Integer id, Principal principal){
        Book book = bookService.findById(id);
        Purchase purchase = new Purchase();
        purchase.setCustomer(customerService.findByLogin(principal.getName()));

        List<Book> bookList = new ArrayList<Book>();
        bookList.add(book);

        int amount=0;
        for (Book b : bookList){
            amount+=b.getPrice();
        }

        purchase.setBookList(bookList);
        purchase.setAmount(amount);

        purchaseService.add(purchase);
        return "redirect:/";
    }*/
    @RequestMapping(value = "/addToBusket/{id}")
    public String addToBusket(@PathVariable Integer id,HttpSession session){
        List<Book> bookList;
        if(session.getAttribute("purchaseBook")!=null){
            bookList = ((List<Book>) session.getAttribute("purchaseBook"));
        } else{
            bookList = new ArrayList<Book>();
        }


        bookList.add(bookService.findById(id));
        System.out.println("***********************");
        for (Book book: bookList){
            System.out.println(book);
        }
        session.setAttribute("purchaseBook", bookList);

        return "redirect:/";
    }

    @RequestMapping(value = "/buy")
    public String buy(Principal principal, HttpSession httpSession){
        Purchase purchase = new Purchase();
        purchase.setCustomer(customerService.findByLogin(principal.getName()));
        List<Book> bookList =(List<Book>) httpSession.getAttribute("purchaseBook");
        int amount= 0;
        for (Book book: bookList){
            amount+=book.getPrice();
        }
        purchase.setBookList(bookList);
        purchase.setAmount(amount);
        purchaseService.add(purchase);
        return "personalPage";
    }
}
