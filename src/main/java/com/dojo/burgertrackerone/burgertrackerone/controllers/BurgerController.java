package com.dojo.burgertrackerone.burgertrackerone.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dojo.burgertrackerone.burgertrackerone.models.Burger;
import com.dojo.burgertrackerone.burgertrackerone.service.BurgerService;

import jakarta.validation.Valid;



@Controller
public class BurgerController {
    private final BurgerService burgerService;

    public BurgerController(BurgerService burgerService){
        this.burgerService = burgerService;
    }
    
    //home redirect
    @RequestMapping("/")
    public String index() {
        return "redirect:/burgers";
    }

    //home page all burgers
    @RequestMapping("/burgers")
    public String show_all(Model model) {

        List<Burger> burgers = burgerService.allBurgers();
        model.addAttribute("burgers", burgers);
        return "index.jsp";
    }
   
    // details page , specific burger
    @RequestMapping("/burger/{id}")
    public String show_one(@PathVariable("id") Long id,
                            Model model) {
        Burger burger = burgerService.findBurger(id);
        model.addAttribute("burger", burger);
    	return "details.jsp";
    }


    // form page / create new burger
    @RequestMapping("/burger/new")
    public String new_burger(@ModelAttribute("burgerAttr") Burger burger) { // on passe l'objet vide burger grâce au @ModelAttribute
        return "burger_form.jsp";
    }


    // processing request create new burger
    @RequestMapping(value="/process_burger", method=RequestMethod.POST)
    public String create(@Valid @ModelAttribute("burgerAttr") Burger burger, // on récupère l'objet déja rempli
                         BindingResult result) {
        if (result.hasErrors()) {
            return "burger_form.jsp";
        } else {
            burgerService.createBurger(burger);
            return "redirect:/burgers";
        }
    }
}
