package com.cafe.cafemenu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import com.cafe.cafemenu.repository.MenuRepository;
import com.cafe.cafemenu.entity.Menu;


@EnableEurekaClient
@SpringBootApplication
public class CafemenuApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(CafemenuApplication.class, args);
    }

    @Autowired
    @Qualifier("menuRepository")
    private MenuRepository menuRepository; // Inject the MenuRepository

    @Override
    public void run(String... args) throws Exception {
        // Example: Saving a menu item
        Menu menuItem1 = new Menu("Burger", "10.99", "Delicious burger with cheese and fries", "Available");
        Menu menuItem2 = new Menu("Pizza", "12.99", "Pepperoni pizza with extra cheese", "Available");
        Menu menuItem3 = new Menu("Salad", "7.99", "Fresh garden salad with vinaigrette dressing", "Available");
        Menu menuItem4 = new Menu("Pasta", "9.99", "Spaghetti with marinara sauce and garlic bread", "Available");
        Menu menuItem5 = new Menu("Sushi", "14.99", "Assorted sushi rolls with soy sauce and wasabi", "Available");
        Menu menuItem6 = new Menu("Steak", "19.99", "Grilled ribeye steak with mashed potatoes and gravy", "Available");
        menuRepository.save(menuItem1);
        menuRepository.save(menuItem2);
        menuRepository.save(menuItem3);
        menuRepository.save(menuItem4);
        menuRepository.save(menuItem5);
        menuRepository.save(menuItem6);

        // Example: Retrieving all menu items and printing them
        Iterable<Menu> allMenuItems = menuRepository.findAll();
        for (Menu item : allMenuItems) {
            System.out.println(item);
        }
    }
}
