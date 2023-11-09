package com.dojo.burgertrackerone.burgertrackerone.models;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;




@Entity
@Table(name="burgers")
public class Burger {
    @Id  // primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min = 5, max = 200)
    private String burger;

    @NotNull
    @Size(min = 5, max = 200) //@Size L'annotation est utilisée pour valider la longueur d'une chaîne
    private String restaurant;

    //NEW
    @NotNull( message="Must not be blank." )
    @Min(1) // @Minet @Maxles annotations sont utilisées pour valider la plage d’un nombre. 
    @Max(value=5, message="The rating must be between 0 and 5")
    private Integer rating;

    @NotNull
    @Size(min = 5, max = 200)
    private String notes;

    // This will not allow the createdAt column to be updated after creation
    @Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
    
    // 02 constructeurs , tjrs en avoir 02
    public Burger() {
    }
    public Burger(String burger, String restaurant, int rating, String notes) {
        this.burger = burger;
        this.restaurant = restaurant;
        this.rating = rating;
        this.notes = notes;
    }
    
    // other getters and setters removed for brevity
    @PrePersist // extrait la date actuelle avant de l'enregistrer dns la database
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate // enregistr chaq fois q l'on fera une mise à jour
    protected void onUpdate(){
        this.updatedAt = new Date();
    }
    

    // getters and setters
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getBurger() {
        return burger;
    }
    public void setBurger(String burger) {
        this.burger = burger;
    }
    public String getRestaurant() {
        return restaurant;
    }
    public void setRestaurant(String restaurant) {
        this.restaurant = restaurant;
    }
    public Integer getRating() {
        return rating;
    }
    public void setRating(Integer rating) {
        this.rating = rating;
    }
    public String getNotes() {
        return notes;
    }
    public void setNotes(String notes) {
        this.notes = notes;
    }
    public Date getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
    public Date getUpdatedAt() {
        return updatedAt;
    }
    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

}
