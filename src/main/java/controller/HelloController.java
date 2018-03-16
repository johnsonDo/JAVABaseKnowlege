package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by DEllComputer on 2018/3/15.
 */

@Controller
public class HelloController {


    @RequestMapping(value = "/hello" , method = RequestMethod.GET)
    public String hello(){
        System.out.println("hihi");

        return "index";
    }
}
