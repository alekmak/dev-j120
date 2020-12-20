/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userInterface;


import controllers.OrderClientsController;
import controllers.ProductClientsController;
import java.awt.BorderLayout;
import java.awt.Dialog;
import javax.swing.JButton;

import javax.swing.JDialog;

import javax.swing.JPanel;
import javax.swing.JTable;


/**
 *
 * @author Алексей
 */
public class ProductDialog extends JDialog {

    private boolean modalResult;

    public ProductDialog(Dialog owner, OrderClientsController orderController, ProductClientsController productController) {

        super(owner, "Products", true);

        JPanel p = new JPanel();
        JTable table = new JTable(new ProductTableModel(orderController, productController));
        p.add(table);
        add(p, BorderLayout.CENTER);
        JPanel btnPanel = new JPanel();
        JButton btn = new JButton("OK");
        btn.addActionListener(e -> {
            modalResult = true;
            dispose();
        });
        btnPanel.add(btn);

        btn = new JButton("Отмена");
        btn.addActionListener(e -> {
            dispose();
        });
        btnPanel.add(btn);
        add(btnPanel, BorderLayout.SOUTH);
        setResizable(false);

        pack();

    }

    public boolean isModalResult() {
        return modalResult;
    }
}
