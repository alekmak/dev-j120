/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userInterface;

import controllers.ClientsController;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import models.OrderClient;
import models.PhoneNumber;

/**
 *
 * @author Алексей
 */
public class ClientsTableModel implements TableModel
{
    private static final String[] COLUMN_HEADERS = {
        "Дата",
        "ФИО",
        "Телефон",
        "Адрес",
        "Скидка",
        "Статус заказа",
        "Дата отгрузки",
        
     
    };
    private static final Class<?>[] COLUMN_TYPES = {
        Date.class,
        String.class,
        PhoneNumber.class,
        String.class,
        int.class,
        String.class,
        Date.class,
       
    };
    private ClientsController controller;
    private List<TableModelListener> listeners;

    public ClientsTableModel(ClientsController controller) {
        this.controller = controller;
        this.listeners = new ArrayList<>();
    }
    

    @Override
    public int getRowCount() { //возвращает количество строк 
       return controller.getClientsCount();
    }

    @Override
    public int getColumnCount() {//возвращает количество колонок 
        return COLUMN_HEADERS.length; //возвращает размер массива
    }

    @Override
    public String getColumnName(int columnIndex) {//возвращает текст заголовка колонки 
        return COLUMN_HEADERS[columnIndex]; 
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
       return COLUMN_TYPES[columnIndex];
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {//редактирование таблицы
       return false;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {//возвращает значение в ячейке
        OrderClient c = controller.get(rowIndex);
        switch(columnIndex){
            case 0: return c.getDateCreate();
            case 1: return c.getName();
            case 2: return c.getPhoneNumber();
            case 3: return c.getAdress();
            case 4: return c.getSale();
            case 5: return c.getStatus();
            case 6: return c.getDateShip();            
            default: return null;
        }
    }

    @Override
    public void setValueAt(Object arg0, int arg1, int arg2) {
        //isCellEditable false
    }

    @Override
    public void addTableModelListener(TableModelListener arg0) { 
       listeners.add(arg0);
    }

    @Override
    public void removeTableModelListener(TableModelListener arg0) {
        listeners.remove(arg0);
        
    }
    private void fireTableModelEvent(TableModelEvent e)
    {
        for(TableModelListener l: listeners)
            l.tableChanged(e);
    }
    public void addClient(String areaCode, String phoneNum, String name, String addr){
        controller.add(new PhoneNumber(areaCode, phoneNum), name, addr);
        int rowNum = controller.getClientsCount() - 1;
        fireTableModelEvent(new TableModelEvent(this, rowNum, rowNum, 
                TableModelEvent.ALL_COLUMNS, TableModelEvent.INSERT));
    }
    public void editClient(int index, String name, String addr)
    {
        OrderClient cl = controller.get(index);
        cl.setName(name);
        cl.setAdress(addr);
        fireTableModelEvent(new TableModelEvent(this, index, index,
                TableModelEvent.ALL_COLUMNS, TableModelEvent.UPDATE));
    }
}
