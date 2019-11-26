package com.codecool.shop.dao.implementation;

import com.codecool.shop.dao.ShoppingCartDao;
import com.codecool.shop.model.Product;

import java.lang.reflect.Array;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ShoppingCartDaoMem implements ShoppingCartDao {
    final int DIGITS_TO_TRUNCATE_USD  = 4;
    private NumberFormat nf = NumberFormat.getNumberInstance();
    //nf.setRoundingMode(RoundingMode.FLOOR);


    List<Product> shoppingCart = new ArrayList<>();
    private static ShoppingCartDaoMem instance = null;

    /* A private Constructor prevents any other class from instantiating.
     */
    private ShoppingCartDaoMem() {
    }

    public static ShoppingCartDaoMem getInstance() {
        if (instance == null) {
            instance = new ShoppingCartDaoMem();
        }
        return instance;
    }


    @Override
    public void add(Product product) {
        shoppingCart.add(product);
    }

    @Override
    public int getCount() {
        return shoppingCart.size();
    }

    @Override
    public Product find(int id) {
        return shoppingCart.stream().filter(t -> t.getId() == id).findFirst().orElse(null);
    }

    @Override
    public void remove(int id) {
        shoppingCart.remove(find(id));
    }

    @Override
    public List<Product> getAll() {
        return shoppingCart;
    }

    private Map<Product, Long> getProductsAndTheirCount() {

        return shoppingCart
                .stream()
                .collect(Collectors.groupingBy(e -> e, Collectors.counting()));



        /*counts.entrySet().forEach(entry->{
            System.out.println(entry.getKey() + "---" + entry.getValue());
        });*/


    }

    @Override
    public ArrayList<ArrayList<Object>> getLineItems() {
        nf.setRoundingMode(RoundingMode.FLOOR);

        ArrayList<ArrayList<Object>> listItems = new ArrayList<>();

        for (Map.Entry<Product, Long> entry : this.getProductsAndTheirCount().entrySet()) {
            ArrayList<Object> line = new ArrayList<>();
            Integer productId = entry.getKey().getId();
            String name = entry.getKey().getName();
            Integer count = entry.getValue().intValue();
            double price = Double.parseDouble(entry.getKey().getPrice().substring(0, entry.getKey().getPrice().length() - DIGITS_TO_TRUNCATE_USD));
            String priceString = nf.format(price);
            String subtotal = nf.format(price * count);

            line.add(productId);
            line.add(name);
            line.add(priceString);
            line.add(count);
            line.add(subtotal);

            listItems.add(line);
        }
        return listItems;
    }


    @Override
    public String getTotalPrice() {
        nf.setRoundingMode(RoundingMode.FLOOR);
        return  String.valueOf(nf.format(shoppingCart.stream()
                .map(e -> Double.parseDouble(e.getPrice().substring(0, e.getPrice().length() - DIGITS_TO_TRUNCATE_USD)))
                .reduce(0.0, Double::sum)));/*
        shoppingCart.stream().reduce(i -> i.getPrice()).sum();
        shoppingCart.stream().reduce(i -> sum(i.getPrice()))*/


    }

    private int getCountByProductId(int productId) {
        int counter = 0;
        for(Product product: shoppingCart) {
            if(product.getId() == productId) {
                counter ++;
            }
        }
        return counter;
    }

    @Override
    public void update(String[] productIdsAndQuantities) {
        for(int i = 0; i < productIdsAndQuantities.length; i++) {

            String[] idAndQuantity = productIdsAndQuantities[i].split("-");
            int productId = Integer.valueOf(idAndQuantity[0]);
            int newQuantity = Integer.valueOf(idAndQuantity[1]);
            int oldQuantity = getCountByProductId(productId);

            if (newQuantity < oldQuantity) {
                for(int k=0; k < (oldQuantity - newQuantity); k++) {
                    shoppingCart.remove(find(productId));
                }
            } else if(newQuantity > oldQuantity) {
                for(int k=0; k < (newQuantity - oldQuantity); k++) {
                    shoppingCart.add(find(productId));
                }
            }
        }
    }
}
