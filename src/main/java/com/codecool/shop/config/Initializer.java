package com.codecool.shop.config;

import com.codecool.shop.dao.ProductCategoryDao;
import com.codecool.shop.dao.ProductDao;
import com.codecool.shop.dao.ShoppingCartDao;
import com.codecool.shop.dao.SupplierDao;
import com.codecool.shop.dao.implementation.ProductCategoryDaoMem;
import com.codecool.shop.dao.implementation.ProductDaoMem;
import com.codecool.shop.dao.implementation.ShoppingCartDaoMem;
import com.codecool.shop.dao.implementation.SupplierDaoMem;
import com.codecool.shop.model.Product;
import com.codecool.shop.model.ProductCategory;
import com.codecool.shop.model.Supplier;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class Initializer implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ProductDao productDataStore = ProductDaoMem.getInstance();
        ProductCategoryDao productCategoryDataStore = ProductCategoryDaoMem.getInstance();
        SupplierDao supplierDataStore = SupplierDaoMem.getInstance();
        ShoppingCartDao shoppingCart = ShoppingCartDaoMem.getInstance();

        //setting up a new supplier
        Supplier sony = new Supplier("Sony", "Computers and other staff");
        supplierDataStore.add(sony);
        Supplier acme = new Supplier("Acme", "Weapons and housekeeping goods");
        supplierDataStore.add(sony);
        Supplier spacex = new Supplier("SpaceX", "Dreams about space travels and good news for humanity");
        supplierDataStore.add(sony);

        //setting up a new product category
        ProductCategory audioDevices = new ProductCategory("Audio Devices", "Hardware", "What would the world be for us if we could not hear sounds?");
        productCategoryDataStore.add(audioDevices);
        ProductCategory weapons = new ProductCategory("Weapons", "Weapons", "All those staff with which you feel safer in the city, in traveling, during home visits.");
        productCategoryDataStore.add(weapons);
        ProductCategory spaceships = new ProductCategory("Spaceships", "Vehicles", "A vehicle used for travel in space.");
        productCategoryDataStore.add(spaceships);
        ProductCategory wearable = new ProductCategory("Wearable", "Clothes", "Items which can make you a better being. Or just looks fine.");
        productCategoryDataStore.add(wearable);

        //setting up products and printing it
        productDataStore.add(new Product("Sony TPS-L2", 219.49f, "USD", "You may not be a Star Lord, but you can listen to music just like him. Great offer.", audioDevices, sony));
        productDataStore.add(new Product("Quad Blasters", 7499.99f, "USD", "The Quad Blaster has two separate triggers and barrels, for the index and middle finger respectively. Both of which can be fired at the same time and have a lethal and non-lethal attack function.", weapons, acme));
        productDataStore.add(new Product("Big Falcon Rocket (BFR)", 150000000, "USD", "The fully reusable super heavy-lift launch vehicle will consist of two main parts: a reusable booster stage and a reusable second stage with an integrated payload section.", spaceships, spacex));
        productDataStore.add(new Product("Odin's Eye Patch", 1299.99f, "USD", "Original staff. Srly. Only in the Rocket's Pocket.", wearable, acme));
        productDataStore.add(new Product("Thor's Thunder Hammer", 7349.99f, "USD", "Very good quality. Powerful weapon. Only in the Rocket's Pocket.", weapons, acme));
        productDataStore.add(new Product("Some Weapon Item", 100, "USD", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nullam a sollicitudin nibh. Aliquam vestibulum sapien at nisl fermentum, eget ornare tortor eleifend. Integer neque enim, rutrum quis tincidunt id, commodo sit amet leo.", weapons, acme));
        productDataStore.add(new Product("Some Weapon Item", 100, "USD", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nullam a sollicitudin nibh. Aliquam vestibulum sapien at nisl fermentum, eget ornare tortor eleifend. Integer neque enim, rutrum quis tincidunt id, commodo sit amet leo.", weapons, acme));
        productDataStore.add(new Product("Some Weapon Item", 100, "USD", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nullam a sollicitudin nibh. Aliquam vestibulum sapien at nisl fermentum, eget ornare tortor eleifend. Integer neque enim, rutrum quis tincidunt id, commodo sit amet leo.", weapons, acme));
        productDataStore.add(new Product("Some Wearable Item", 100, "USD", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nullam a sollicitudin nibh. Aliquam vestibulum sapien at nisl fermentum, eget ornare tortor eleifend. Integer neque enim, rutrum quis tincidunt id, commodo sit amet leo.", wearable, acme));
        productDataStore.add(new Product("Some Wearable Item", 100, "USD", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nullam a sollicitudin nibh. Aliquam vestibulum sapien at nisl fermentum, eget ornare tortor eleifend. Integer neque enim, rutrum quis tincidunt id, commodo sit amet leo.", wearable, acme));
        productDataStore.add(new Product("Some Wearable Item", 100, "USD", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nullam a sollicitudin nibh. Aliquam vestibulum sapien at nisl fermentum, eget ornare tortor eleifend. Integer neque enim, rutrum quis tincidunt id, commodo sit amet leo.", wearable, acme));
        productDataStore.add(new Product("Some Audio Item", 100, "USD", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nullam a sollicitudin nibh. Aliquam vestibulum sapien at nisl fermentum, eget ornare tortor eleifend. Integer neque enim, rutrum quis tincidunt id, commodo sit amet leo.", audioDevices, acme));
        productDataStore.add(new Product("Some Audio Item", 100, "USD", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nullam a sollicitudin nibh. Aliquam vestibulum sapien at nisl fermentum, eget ornare tortor eleifend. Integer neque enim, rutrum quis tincidunt id, commodo sit amet leo.", audioDevices, acme));
        productDataStore.add(new Product("Some Audio Item", 100, "USD", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nullam a sollicitudin nibh. Aliquam vestibulum sapien at nisl fermentum, eget ornare tortor eleifend. Integer neque enim, rutrum quis tincidunt id, commodo sit amet leo.", audioDevices, acme));
        productDataStore.add(new Product("Some Audio Item", 100, "USD", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nullam a sollicitudin nibh. Aliquam vestibulum sapien at nisl fermentum, eget ornare tortor eleifend. Integer neque enim, rutrum quis tincidunt id, commodo sit amet leo.", audioDevices, acme));
        productDataStore.add(new Product("Some Audio Item", 100, "USD", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nullam a sollicitudin nibh. Aliquam vestibulum sapien at nisl fermentum, eget ornare tortor eleifend. Integer neque enim, rutrum quis tincidunt id, commodo sit amet leo.", audioDevices, acme));
        productDataStore.add(new Product("Some Spaceship", 100, "USD", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nullam a sollicitudin nibh. Aliquam vestibulum sapien at nisl fermentum, eget ornare tortor eleifend. Integer neque enim, rutrum quis tincidunt id, commodo sit amet leo.", spaceships, acme));
        productDataStore.add(new Product("Some Spaceship", 100, "USD", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nullam a sollicitudin nibh. Aliquam vestibulum sapien at nisl fermentum, eget ornare tortor eleifend. Integer neque enim, rutrum quis tincidunt id, commodo sit amet leo.", spaceships, acme));
        productDataStore.add(new Product("Some Spaceship", 100, "USD", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nullam a sollicitudin nibh. Aliquam vestibulum sapien at nisl fermentum, eget ornare tortor eleifend. Integer neque enim, rutrum quis tincidunt id, commodo sit amet leo.", spaceships, acme));
        productDataStore.add(new Product("Some Spaceship", 100, "USD", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nullam a sollicitudin nibh. Aliquam vestibulum sapien at nisl fermentum, eget ornare tortor eleifend. Integer neque enim, rutrum quis tincidunt id, commodo sit amet leo.", spaceships, acme));
    }
}
