package ua.lviv.market.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ua.lviv.market.Entity.Author;
import ua.lviv.market.Entity.Book;
import ua.lviv.market.Entity.Purchase;
import ua.lviv.market.service.BookService;
import ua.lviv.market.service.CustomerService;
import ua.lviv.market.service.PurchaseService;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Roman on 02.05.2017.
 */
@Controller
public class BookController {

    @Autowired
    private BookService bookService;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private PurchaseService purchaseService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(Model model){
        List<Book> bookList = bookService.findAll();
        model.addAttribute("b",bookList);
        return "home";
    }

    @RequestMapping(value = "/addBook", method = RequestMethod.GET)
    public String addNewBook(){
        return "addNewBook";
    }

    @RequestMapping(value = "/newBook", method = RequestMethod.POST)
    public String addNewBook(@RequestParam("bookName") String name,
                             @RequestParam("genreName") String genre,
                             @RequestParam("priceName") Double price,
                             @RequestParam("descriptionName") String description,
                             @RequestParam("urlName") String urlImage){
        bookService.add(name,genre,price,description,urlImage);
        return "redirect:/";
    }

    @RequestMapping(value = "/book/edit/{id}", method = RequestMethod.GET)
    public String editBook(@PathVariable Integer id, Model model){
        Book book = bookService.findById(id);
        model.addAttribute("books",book);
        return "editBook";
    }

    @RequestMapping(value = "/editBooks", method = RequestMethod.POST)
    public String editBooks(@RequestParam("bookId") Integer id,
                           @RequestParam("bookName") String name,
                           @RequestParam("authorName") String surname,
                           @RequestParam("genreName") String genre,
                           @RequestParam("priceName") Double price,
                           @RequestParam("descriptionName") String description,
                           @RequestParam("urlName") String urlImage){

        bookService.edit(id,name,genre,price,description,urlImage);
        return "redirect:/";
    }

    @RequestMapping(value = "/deleteBook/{id}")
    public String deleteBook(@PathVariable Integer id){
        bookService.delete(id);
        return "redirect:/";
    }





    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(){
           return "registration";
    }

    @RequestMapping(value = "/registrationw", method = RequestMethod.POST)
    public String registration(@RequestParam("name") String name,
                               @RequestParam("secondName") String secondName,
                               @RequestParam("email") String email,
                               @RequestParam("phone") String phone,
                               @RequestParam("login") String login,
                               @RequestParam("password") String password,
                               @RequestParam("discount") Double discount){
        customerService.add(name,secondName,email,phone,login,password,discount);
        return "redirect:/";
    }

    @RequestMapping(value = "/loginpage", method = RequestMethod.GET)
    public String loginpage(){
        return "login";
    }

    @RequestMapping(value = "/myBook/{id}",method = RequestMethod.GET)
    public String myBook(@PathVariable Integer id,Model model){
        Book book = bookService.findById(id);
        model.addAttribute("bookPage",book);
        return "book";
    }

    @RequestMapping(value = "/getBooksByGenre/{genre}",method = RequestMethod.GET)
    public String getBooksByGenre(@PathVariable("genre")String genre, Model model){
        List<Book> bookList = (List<Book>) bookService.findByGenre(genre);
        model.addAttribute("b", bookList);
        return "bookByGenre";
    }
    @RequestMapping(value = "/bookByAuthor/{surname}",method = RequestMethod.GET)
    public String bookByAuthor(@PathVariable("surname") String surname,Model model){
        List<Book> bookList = (List<Book>) bookService.findByAuthorSurname(surname);
        model.addAttribute("bA",bookList);
        return "authorBooks";
    }

}
