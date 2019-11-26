package com.codecool.shop.dao.DBImplementation;

//package com.codecool.shop.dao.DBImplementation;

import com.codecool.shop.config.DBConfig;
import com.codecool.shop.dao.ProductCategoryDao;
import com.codecool.shop.model.ProductCategory;

import java.beans.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ProductCategoryDaoDB implements ProductCategoryDao {

    DBConfig configuration = new DBConfig();

    @Override
    public void add(ProductCategory category) {}

    @Override
    public ProductCategory find(int id) {
        return null;
    }

    @Override
    public void remove(int id) {

    }

    @Override
    public List<ProductCategory> getAll() {
        return null;
    }


    /*public static void viewTable (Connection con) throws SQLException {*/

           /* String query = "select COF_NAME, SUP_ID, PRICE, " +
                    "SALES, TOTAL " +
                    "from COFFEES";

            try (Statement stmt = con.createStatement()) {

                ResultSet rs = stmt.executeQuery(query);

                while (rs.next()) {
                    String coffeeName = rs.getString("COF_NAME");
                    int supplierID = rs.getInt("SUP_ID");
                    float price = rs.getFloat("PRICE");
                    int sales = rs.getInt("SALES");
                    int total = rs.getInt("TOTAL");
                    System.out.println(coffeeName + ", " + supplierID +
                            ", " + price + ", " + sales +
                            ", " + total);
                }
            } catch (SQLException e) {
                JDBCTutorialUtilities.printSQLException(e);
            }*/
        }
//    }
//}