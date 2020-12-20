/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io;

import java.io.BufferedReader;
import java.io.FileReader;
import models.Config;

/**
 *
 * @author Алексей
 */
public class ConfigReader {

    public Config read() {
        Config c = new Config();
        try ( FileReader reader = new FileReader("config.txt");  BufferedReader br = new BufferedReader(reader)) {
            String directoryName = br.readLine();
            String discount = br.readLine();
            c.setDirectoryName(directoryName);
            int pr = Integer.parseInt(discount);
            c.setDiscount(pr);
        } catch (Exception e) {
        }
        return c;

    }

}
