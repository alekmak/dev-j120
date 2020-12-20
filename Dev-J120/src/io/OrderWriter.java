/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io;


import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import models.OrderClient;

/**
 *
 * @author Алексей
 */
public class OrderWriter {

    public void write(String filename, List<OrderClient> orders) {
        try ( FileOutputStream file = new FileOutputStream(filename);  ObjectOutputStream oos = new ObjectOutputStream(file)) {
            oos.writeObject(orders);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
