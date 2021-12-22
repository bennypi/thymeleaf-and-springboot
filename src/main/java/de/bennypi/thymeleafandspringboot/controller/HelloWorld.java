package de.bennypi.thymeleafandspringboot.controller;

import de.bennypi.thymeleafandspringboot.controller.model.NameModel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
@SessionAttributes("nameModel")
public class HelloWorld {

  @ModelAttribute("nameModel")
  public NameModel nameModel() {
    return new NameModel();
  }

  @GetMapping
  public ModelAndView helloWorld() {
    ModelAndView helloWorld = new ModelAndView("hello-world");
    helloWorld.addObject("greeting", "Hi there!");
    return helloWorld;
  }

  @PostMapping
  public ModelAndView getName(@ModelAttribute NameModel model) {
    ModelAndView helloWorld = new ModelAndView("hello-world");
    helloWorld.addObject("greeting", "Hi " + model.getName() + "!");
    return helloWorld;
  }
}
