/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.nio.charset.StandardCharsets;
import java.util.List;
import models.Product;

/**
 *
 * @author Алексей
 */
public class CSVWriter {

    public void writeProducts(String filename, List<Product> products) {
        try (FileWriter writer = new FileWriter(filename, StandardCharsets.UTF_8);  BufferedWriter bw = new BufferedWriter(writer)) {
            for (Product product : products) {
                bw.write(product.toString() + "\n");               

            }
        } catch (Exception e) {
        }

    }
}
