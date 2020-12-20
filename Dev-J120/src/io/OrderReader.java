/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;
import models.OrderClient;

/**
 *
 * @author Алексей
 */
public class OrderReader {

    public List<OrderClient> read(String filename) {
        List<OrderClient> list = null;
        try ( FileInputStream file = new FileInputStream(filename);  ObjectInputStream oos = new ObjectInputStream(file)) {

            list = (List<OrderClient>) oos.readObject();

        } catch (Exception e) {
            e.printStackTrace();
        }
        if (list == null) {
            return new ArrayList<>();
        }

        return list;
    }
}
