package com.cafe.cafemenu.entity;

import javax.persistence.*;

@Entity
@Table(name = "menu")
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "menu_id")
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "item_price")
    private String itemPrice;

    @Column(name = "description")
    private String description;

    @Column(name = "status")
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

