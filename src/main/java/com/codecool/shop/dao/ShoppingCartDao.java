package com.codecool.shop.dao;

import com.codecool.shop.model.Product;

import java.util.ArrayList;
import java.util.List;

public interface ShoppingCartDao {

    void add(Product product);

    int getCount();

    Product find(int id);

    void remove(int id);

    List<Product> getAll();

    ArrayList<ArrayList<Object>> getLineItems();

    String getTotalPrice();

    void update(String[] productIdsAndQuantities);
}