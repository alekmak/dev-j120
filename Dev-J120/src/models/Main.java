/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import controllers.ClientsController;
import userInterface.MainFrame;

/**
 *
 * @author Алексей
 */
public class Main {
    public static void main(String[] args) {
        ClientsController controller = new ClientsController();
        MainFrame f = new MainFrame(controller);
        f.setVisible(true);
    }
}
