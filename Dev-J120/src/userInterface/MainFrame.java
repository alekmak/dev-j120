/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userInterface;

import controllers.OrderClientsController;
import java.awt.BorderLayout;
import java.awt.Container;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import models.OrderClient;

/**
 *
 * @author Алексей
 */
public class MainFrame extends JFrame{
    private OrderClientsController controller;
    private ClientsTableModel clientsTableModel;
    private JTable mainTable;

    public MainFrame(OrderClientsController controller) {
        super("Система учёта заказов"); //заголовок
        setBounds(300, 200, 900, 600); //размер окна
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        this.controller = controller;
        clientsTableModel = new ClientsTableModel(controller);
        mainTable = new JTable(clientsTableModel);
        //JTable tbl = new JTable(new ClientsTableModel(controller)); //реализация цепочки от 
        //пользовательского интерфейса через ClientsTableModel до ClientsController
        Container c = getContentPane(); 
        c.add(mainTable.getTableHeader(), BorderLayout.NORTH);  //добавление заголовка таблицы
        c.add(new JScrollPane(mainTable), BorderLayout.CENTER);
        
        JMenuBar mb = new JMenuBar();
        JMenu m = new JMenu("Заказы");
        JMenuItem mi;
        
        mi = new JMenuItem("Добавить");
        mi.addActionListener (e -> addClient());
        m.add(mi);
        mi = new JMenuItem("Редактировать");
        mi.addActionListener(e -> editClient());
        m.add(mi);
        mi = new JMenuItem("Удалить");
        mi.addActionListener(e -> deleteClient());
        m.add(mi);
        
        mb.add(m);
        setJMenuBar(mb);
    }
    private void addClient() {
       ClientDialog dlg = new ClientDialog(this);
       dlg.setLocationRelativeTo(this);
       dlg.setVisible(true);
       if(dlg.isModalResult())
          {
             String areaCode = dlg.getAreaCode(),
                     phoneNum = dlg.getPhoneNumber(),
                     name = dlg.getName(),
                     addr = dlg.getAddress();
                   
             
             
          try {   
             clientsTableModel.addClient(areaCode, phoneNum, name, addr);
          } catch(Exception e) {
              JOptionPane.showMessageDialog(this, e.getMessage(), "Ошибка", JOptionPane.ERROR_MESSAGE);
          }
       }  
    }
    private void editClient() {
       int row = mainTable.getSelectedRow();
       if(row == -1)
           return;
       //OrderClient cl = controller.get(row);
       ClientDialog dlg = new ClientDialog(this, controller.get(row));
       dlg.setLocationRelativeTo(this);
       dlg.setVisible(true);
       if(dlg.isModalResult())
          {
             clientsTableModel.editClient(row, dlg.getName(), dlg.getAddress());
          }
              
        
        
    }
    private void deleteClient(){
       int row = mainTable.getSelectedRow();
       if(row == -1)
           return;
       String phNum = controller.get(row).getPhoneNumber().toString();
       if(JOptionPane.showConfirmDialog(this, "Хотите удалить" + phNum + "?" ,"Удаление строки заказа", 
               JOptionPane.YES_NO_OPTION,
               JOptionPane.WARNING_MESSAGE)
               == JOptionPane.YES_OPTION){
        clientsTableModel.deleteClient(row);
    }
    }
    
}
