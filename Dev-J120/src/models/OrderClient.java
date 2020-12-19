/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.Date;

/**
 *
 * @author Алексей
 */
public class OrderClient {
    private Date dateCreate;
    private String name;
    private PhoneNumber PhoneNumber;
    private String adress;
    private int sale;
    private String status;
    private Date dateShip;
    private OrderPosition OrderPosition;

    public OrderClient(Date dateCreate, String name, PhoneNumber PhoneNumber, String adress, int sale, String status, Date dateShip) {
        this.dateCreate = dateCreate;
        this.name = name;
        this.PhoneNumber = PhoneNumber;
        this.adress = adress;
        this.sale = sale;
        this.status = status;
        this.dateShip = dateShip;
        
    }

    public OrderClient(Date dateCreate, String name, PhoneNumber PhoneNumber, String adress) {
        this.dateCreate = dateCreate;
        this.name = name;
        this.PhoneNumber = PhoneNumber;
        this.adress = adress;
       
    }
  
    public OrderPosition getOrderPosition() {
        return OrderPosition;
    }

    public void setOrderPosition(OrderPosition OrderPosition) {
        this.OrderPosition = OrderPosition;
    }

   

    public Date getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(Date dateCreate) {
        this.dateCreate = dateCreate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PhoneNumber getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(PhoneNumber PhoneNumber) {
        this.PhoneNumber = PhoneNumber;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public int getSale() {
        return sale;
    }

    public void setSale(int sale) {
        this.sale = sale;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getDateShip() {
        return dateShip;
    }

    public void setDateShip(Date dateShip) {
        this.dateShip = dateShip;
    }
    
}

