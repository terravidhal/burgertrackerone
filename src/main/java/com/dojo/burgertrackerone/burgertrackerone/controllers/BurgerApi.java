package com.dojo.burgertrackerone.burgertrackerone.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dojo.burgertrackerone.burgertrackerone.models.Burger;
import com.dojo.burgertrackerone.burgertrackerone.service.BurgerService;



@RestController
public class BurgerApi {
    private final BurgerService burgerService;

    public BurgerApi(BurgerService burgerService){
        this.burgerService = burgerService;
    }
    
    //return all burgers
    @RequestMapping("/api/burgers")
    public List<Burger> index() {
        return burgerService.allBurgers();
    }

    //return One specific burger
    @RequestMapping("/api/burgers/{id}")
    public Burger show(@PathVariable("id") Long id) {
        Burger Burger = burgerService.findBurger(id);
        return Burger;
    }


    //create burgers
    @RequestMapping(value="/api/burgers", method=RequestMethod.POST)
    public Burger create(@RequestParam(value="burger") String burger, 
                         @RequestParam(value="restau") String restaurant, 
                         @RequestParam(value="rating") Integer rating, 
                         @RequestParam(value="notes") String notes) {
        Burger Burger = new Burger(burger, restaurant, rating, notes);
        return burgerService.createBurger(Burger);
    }

    

    // update
	@RequestMapping(value="/api/burgers/{id}", method=RequestMethod.PUT)
    public Burger update(@PathVariable("id") Long id, 
                       @RequestParam(value="burger") String burger, 
                       @RequestParam(value="restau") String restaurant, 
                       @RequestParam(value="rating") Integer rating, 
                       @RequestParam(value="notes") String notes) {
        Burger Burger = new Burger(burger, restaurant, rating, notes);
        Burger.setId(id);
        return burgerService.updateBurger(Burger);
    }
    
    // delete
    @RequestMapping(value="/api/burgers/{id}", method=RequestMethod.DELETE)
    public void destroy(@PathVariable("id") Long id) {
        burgerService.deleteBurger(id);
    }
}
