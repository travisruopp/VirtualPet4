package org.wecancodeit.virtualpet4.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
/**
 * 
 */
@Controller
public class HomeController {

    @GetMapping ("/")
    public String goHome(){
        return "home/index";
    }
    
}
