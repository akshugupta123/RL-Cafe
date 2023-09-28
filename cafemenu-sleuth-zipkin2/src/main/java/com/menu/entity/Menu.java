 

package com.menu.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Entity
@Table(name = "menu")
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "menu_id")
    private int id;

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

	public int getId() {
		return id;
	}

	public void setId(int id) {
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

	public Menu( String name, String itemPrice, String description, String status) {
		super();
		
		this.name = name;
		this.itemPrice = itemPrice;
		this.description = description;
		this.status = status;
	}

	@Override
	public String toString() {
		return "Menu [id=" + id + ", name=" + name + ", itemPrice=" + itemPrice + ", description=" + description
				+ ", status=" + status + "]";
	}

 
}

