package ua.lviv.market.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Roman on 26.05.2017.
 */
@Controller
public class ServiceController {


    @RequestMapping(value = "/contacts",method = RequestMethod.GET)
    public String contact(){
        return "contacts";
    }
}
