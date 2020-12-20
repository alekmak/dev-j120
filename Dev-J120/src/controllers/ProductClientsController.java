/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.util.List;
import models.Product;

/**
 *
 * @author Алексей
 */
public class ProductClientsController {

    private List<Product> products;

    public ProductClientsController(List<Product> products) {
        this.products = products;
    }

    public int getProductsCount() {
        return products.size();
    }

    public Product get(int index) {
        return products.get(index);
    }
}
