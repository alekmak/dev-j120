/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import controllers.OrderClientsController;
import userInterface.MainFrame;

/**
 *
 * @author Алексей
 */
public class Main {
    public static void main(String[] args) {
        OrderClientsController controller = new OrderClientsController();
        MainFrame f = new MainFrame(controller);
        f.setVisible(true);
    }
}
