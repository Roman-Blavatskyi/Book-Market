package ua.lviv.market.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ua.lviv.market.Entity.Purchase;
import ua.lviv.market.service.BookService;
import ua.lviv.market.service.CustomerService;
import ua.lviv.market.service.PurchaseService;

import java.security.Principal;
import java.util.List;

/**
 * Created by Roman on 09.05.2017.
 */
@Controller
public class CustomerController {

    @Autowired
    private BookService bookService;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private PurchaseService purchaseService;

    @RequestMapping(value = "/personalPage",method = RequestMethod.GET)
    public String personalPage(Principal principal, Model model){
        List<Purchase> purchaseList = purchaseService.findAllCustomerPurchases(principal.getName());
        model.addAttribute("purchases", purchaseList);
        return "personalPage";
    }
}
