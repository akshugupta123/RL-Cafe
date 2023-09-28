package com.cafe.DTO;



public class Menu {

    
 
    private long id;


    private String name;

   
    private String itemPrice;

   
    private String description;

   
    private String status;

    public Menu() {
    }

    public Menu(String name, String itemPrice, String description, String status) {
        this.name = name;
        this.itemPrice = itemPrice;
        this.description = description;
        this.status = status;
    }

    // Getters and setters

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(String itemPrice) {
        this.itemPrice = itemPrice;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Menu [id=" + id + ", name=" + name + ", itemPrice=" + itemPrice +
                ", description=" + description + ", status=" + status + "]";
    }
}

