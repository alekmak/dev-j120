/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import models.Product;

/**
 *
 * @author Алексей
 */
public class CSVReader {

    public List<Product> readProducts(String filename) {
        List<Product> products = new ArrayList<>();
        try ( FileReader reader = new FileReader(filename, StandardCharsets.UTF_8);  BufferedReader br = new BufferedReader(reader)) {
            String line = br.readLine();
            while (line != null) {
                Product p = mapProduct(line);
                products.add(p);
                line = br.readLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return products;

    }

    private Product mapProduct(String line) {
        Product p = new Product();
        String[] data = line.split(";");

        p.setArticul(data[0]);
        p.setTitle(data[1]);
        p.setColor(data[2]);
        int pr = Integer.parseInt(data[3]);
        int bl = Integer.parseInt(data[4]);
        p.setPrice(pr);
        p.setBalance(bl);
        return p;
    }
}
