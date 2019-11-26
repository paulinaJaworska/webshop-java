package com.codecool.shop.controller;

import com.codecool.shop.config.TemplateEngineUtil;
import com.codecool.shop.dao.ProductCategoryDao;
import com.codecool.shop.dao.ProductDao;
import com.codecool.shop.dao.ShoppingCartDao;
import com.codecool.shop.dao.implementation.ProductCategoryDaoMem;
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


@WebServlet(urlPatterns = {"/"})
public class ProductController extends HttpServlet {

    public static final String PRODUCTS = "products";
    public static final String CATEGORY = "category";
    public static final String COUNTER = "counter";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProductDao productDataStore = ProductDaoMem.getInstance();
        ProductCategoryDao productCategoryDataStore = ProductCategoryDaoMem.getInstance();
        ShoppingCartDao shoppingCart = ShoppingCartDaoMem.getInstance();

        TemplateEngine engine = TemplateEngineUtil.getTemplateEngine(req.getServletContext());
        WebContext context = new WebContext(req, resp, req.getServletContext());
        context.setVariable(CATEGORY, productCategoryDataStore.find(1));
        context.setVariable(PRODUCTS, productDataStore.getAll());  // getBy(productCategoryDataStore.find(1)));
        context.setVariable(COUNTER, shoppingCart.getCount());

        engine.process("index.html", context, resp.getWriter());
    }


    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        res.sendRedirect(req.getContextPath());

        ShoppingCartDao shoppingCart = ShoppingCartDaoMem.getInstance();

        //WebContext context = new WebContext(req, res, req.getServletContext());
        //context.setVariable("counter", shoppingCart.getCount());

        // Don't return anything at all in the response, just set the status to 204 (No Response).
        // The browser will continue to display the same page that made the request.
        //res.setStatus(HttpServletResponse.SC_NO_CONTENT);

        Integer id = Integer.valueOf(req.getParameter("product"));
        Product product = ProductDaoMem.getInstance().find(id);  // fixme: try catch
        shoppingCart.add(product);


    }

}
