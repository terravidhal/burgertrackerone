package com.dojo.burgertrackerone.burgertrackerone.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dojo.burgertrackerone.burgertrackerone.models.Burger;



@Repository
public interface BurgerRepository extends CrudRepository<Burger, Long> { // pas besoin de l'implementer dns "Service" à  cause du extends
	
	//  cette méthode récupère tous les livres de la base de données 
    
    
         List<Burger> findAll();
}
