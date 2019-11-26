package com.codecool.shop.controller;

import com.codecool.shop.dao.ShoppingCartDao;
import com.codecool.shop.config.TemplateEngineUtil;
import com.codecool.shop.dao.implementation.ProductDaoMem;
import com.codecool.shop.dao.implementation.ShoppingCartDaoMem;
import com.codecool.shop.model.Product;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"shoppingCart"})
public class ShoppingCartController extends HttpServlet {

    public static final String COUNTER = "counter";
    public static final String TOTAL = "total";
    public static final String LINE_ITEMS = "lineItems";

    ShoppingCartDao shoppingCart = ShoppingCartDaoMem.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        TemplateEngine engine = TemplateEngineUtil.getTemplateEngine(req.getServletContext());
        WebContext context = new WebContext(req, resp, req.getServletContext());
        context.setVariable(LINE_ITEMS, shoppingCart.getLineItems());
        context.setVariable(TOTAL, shoppingCart.getTotalPrice());
        context.setVariable(COUNTER, shoppingCart.getCount());
        engine.process("cart.html", context, resp.getWriter());
    }


    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        res.sendRedirect(req.getServletPath());

        String[] productIds = req.getParameterValues("productId");
        String[] quantities = req.getParameterValues("quantity");

        String[] productIdsAndNewQuantities = new String[quantities.length];
        for (int x = 0; x < shoppingCart.getLineItems().size(); x++) {
            productIdsAndNewQuantities[x] = productIds[x] + "-" + quantities[x];
        }
        shoppingCart.update(productIdsAndNewQuantities);
    }

}


