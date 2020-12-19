/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userInterface;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.View;
import models.OrderClient;

/**
 *
 * @author Алексей
 */
public class ClientDialog extends JDialog{
    private JTextField areacode;
    private JTextField phoneNumber;
    private JTextField name;
    private JTextField address;
    private JTextField sale;
    private boolean modalResult;

    public ClientDialog(MainFrame owner) {
        super(owner, "Clients data", true);
    
    JPanel topPanel = new JPanel();
    topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.Y_AXIS));
    JPanel p;
    
    p = new JPanel(new FlowLayout(FlowLayout.LEFT)); //выравнивание
    p.add(new JLabel("Телефон ("));
    areacode = new JTextField(3);
    p.add(areacode);
    p.add(new JLabel(") "));
    phoneNumber = new JTextField(10);
    p.add(phoneNumber);
    topPanel.add(p);
    
    p = new JPanel(new FlowLayout(FlowLayout.LEFT)); 
    p.add(new JLabel("ФИО"));
    name = new JTextField(40);
    p.add(name);
    topPanel.add(p);
    
    p = new JPanel(new FlowLayout(FlowLayout.LEFT)); 
    p.add(new JLabel("Адрес"));
    address = new JTextField(50);
    p.add(address);
    topPanel.add(p);
    
    p = new JPanel(new FlowLayout(FlowLayout.LEFT)); 
    p.add(new JLabel("Скидка"));
    sale = new JTextField(3);
    p.add(sale);
    topPanel.add(p);
    
    p = new JPanel();
    JButton btn = new JButton("OK");
    btn.addActionListener(e -> {
        modalResult = true;
        dispose();
    });
    p.add(btn);
    
    btn = new JButton("Отмена");
    btn.addActionListener(e -> {
        dispose();
    });
    p.add(btn);
    
    topPanel.add(p);
    
    getContentPane().add(topPanel, BorderLayout.CENTER);
    
    setResizable(false);
    
    pack();
    }

    public ClientDialog(MainFrame owner, OrderClient client) {
        this(owner);
        
        areacode.setText(client.getPhoneNumber().getAreaCode());
        phoneNumber.setText(client.getPhoneNumber().getLocalNum());
        name.setText(client.getName());
        address.setText(client.getAdress());
        
        areacode.setEnabled(false);
        phoneNumber.setEditable(false);
    }
    

    public boolean isModalResult() {
        return modalResult;
    }
    public String getAreaCode() {
        return areacode.getText();
    }
    
    public String getPhoneNumber() {
        return phoneNumber.getText();
    }
    public String getName() {
        return name.getText();
    }
    
    public String getAddress() {
        return address.getText();
    }

    public String getSale() {
        return sale.getText();
    }
    
}
