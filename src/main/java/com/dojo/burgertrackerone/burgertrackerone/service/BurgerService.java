package com.dojo.burgertrackerone.burgertrackerone.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.dojo.burgertrackerone.burgertrackerone.models.Burger;
import com.dojo.burgertrackerone.burgertrackerone.repositories.BurgerRepository;


@Service
public class BurgerService {
     // adding the Burger repository as a dependency
     private final BurgerRepository burgerRepository;
    
     public BurgerService(BurgerRepository burgerRepository) {
         this.burgerRepository = burgerRepository;
     }

     
     // returns all the books
     public List<Burger> allBurgers() {
         return burgerRepository.findAll();
     }

     // retrieves a Burger
     public Burger findBurger(Long id) {
        /*/Optional<Burger>: Il s'agit d'un type générique qui représente 
          une valeur possible de type Burger.  Le OptionalLa classe est 
          utilisée pour gérer la possibilité que la valeur soit nulle. 
         */
         Optional<Burger> optionalBurger = burgerRepository.findById(id);
         if(optionalBurger.isPresent()) {
             return optionalBurger.get();
         } else {
             return null;
         }
     }
     


     // creates a Burger
     public Burger createBurger(Burger b) {
         return burgerRepository.save(b);
     }

     // update
	public Burger updateBurger(Burger b) {
		return burgerRepository.save(b);
	}
	//delete
	public void deleteBurger(Long id) {
		Optional<Burger> optionalBurger = burgerRepository.findById(id);
		if(optionalBurger.isPresent()) {
			burgerRepository.deleteById(id);
		}
	}
}
