/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.Serializable;

/**
 *
 * @author Алексей
 */
public class OrderPosition implements Serializable {

    private String product;
    private double price;
    private int number;

    public OrderPosition(String product, double price, int number) {
        this.product = product;
        this.price = price;
        this.number = number;

    }

}
