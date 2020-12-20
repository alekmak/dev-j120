/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userInterface;

import controllers.OrderClientsController;
import controllers.ProductClientsController;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JCheckBox;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import models.Product;

/**
 *
 * @author Алексей
 */
public class ProductTableModel implements TableModel{
    private static final String[] COLUMN_HEADERS = {
        "Артикул",
        "Наименование",
        "Цвет",
        "Цена",
        "Количество",
        "Добавить в заказ"
    };
    private static final Class<?>[] COLUMN_TYPES = {
        String.class,
        String.class,
        String.class,
        int.class,
        int.class,
        JCheckBox.class
    };
    private OrderClientsController orderController;
    private ProductClientsController productController;
    private List<TableModelListener> listeners;

    public ProductTableModel(OrderClientsController orderController, ProductClientsController productController) {
        this.orderController = orderController;
        this.productController = productController;
        this.listeners = new ArrayList<>();
    }
    

    @Override
    public int getRowCount() {
        return productController.getProductsCount();
    }

    @Override
    public int getColumnCount() {
        return COLUMN_HEADERS.length;
    }

    @Override
    public String getColumnName(int arg0) {
        return COLUMN_HEADERS[arg0];
    }

    @Override
    public Class<?> getColumnClass(int arg0) {
        return COLUMN_TYPES[arg0];
    }

    @Override
    public boolean isCellEditable(int arg0, int arg1) {
        return false;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
       Product product = productController.get(rowIndex);
        switch(columnIndex){
            case 0: return product.getArticul();
            case 1: return product.getTitle();
            case 2: return product.getColor();
            case 3: return product.getPrice();
            case 4: return product.getBalance();
                  
            default: return null;
        }
    }

    @Override
    public void setValueAt(Object arg0, int arg1, int arg2) {
        
    }

    @Override
    public void addTableModelListener(TableModelListener arg0) {
        listeners.add(arg0);
    }

    @Override
    public void removeTableModelListener(TableModelListener arg0) {
        listeners.remove(arg0);
    }
    
}
