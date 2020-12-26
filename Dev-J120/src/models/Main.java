/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import controllers.OrderClientsController;
import controllers.ProductClientsController;
import io.CSVReader;
import io.CSVWriter;
import io.ConfigReader;
import io.OrderReader;
import io.OrderWriter;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;
import userInterface.MainFrame;

/**
 *
 * @author Алексей
 */
public class Main {

    public static void main(String[] args) {
        ConfigReader configReader = new ConfigReader();
        Config config = configReader.read();

        CSVReader csvReader = new CSVReader();
        String csvFilename = config.getDirectoryName() + "products.csv";
        List<Product> products = csvReader.readProducts(csvFilename);

        OrderReader orderReader = new OrderReader();
        String ordersFileName = config.getDirectoryName() + "orders";
        List<OrderClient> orders = orderReader.read(ordersFileName);

        OrderClientsController controller = new OrderClientsController(orders);
        ProductClientsController productController = new ProductClientsController(products);
        MainFrame f = new MainFrame(controller, productController);
        f.setVisible(true);
        f.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                OrderWriter orderWriter = new OrderWriter();
                orderWriter.write(ordersFileName, orders);
                CSVWriter csvWriter = new CSVWriter();
                csvWriter.writeProducts(csvFilename, products);
                
            }

        });
    }
}
