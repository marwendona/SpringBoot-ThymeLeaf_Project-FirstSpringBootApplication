package tn.iit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;

@Controller
@RequestMapping("/hello")
public class HelloController {
    @GetMapping("/index")
    public String gotoHello(Model model){
        model.addAttribute("serverTime", LocalDateTime.now());
        return "hello"; //aller a la page hello.html //n importe quelle chaine est convertie en fichier .html
    }

    //2eme methode
    @GetMapping("/index2")
    public ModelAndView gotoHello2(){
        ModelAndView modelAndView = new ModelAndView(); //envoie model vers view
        modelAndView.addObject("serverTime", LocalDateTime.now());
        modelAndView.setViewName("hello");
        return  modelAndView;
    }
}
