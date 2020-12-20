/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Алексей
 */
public class OrderClient implements Serializable {

    private Date dateCreate;
    private String name;
    private PhoneNumber phoneNumber;
    private String adress;
    private int sale;
    private String status;
    private Date dateShip;
    private List<OrderPosition> orderPosition;

    public OrderClient(Date dateCreate, String name, PhoneNumber PhoneNumber, String adress, int sale, String status, Date dateShip) {
        this.dateCreate = dateCreate;
        this.name = name;
        this.phoneNumber = PhoneNumber;
        this.adress = adress;
        this.sale = sale;
        this.status = status;
        this.dateShip = dateShip;

    }

    public OrderClient(Date dateCreate, String name, PhoneNumber PhoneNumber, String adress) {
        this.dateCreate = dateCreate;
        this.name = name;
        this.phoneNumber = PhoneNumber;
        this.adress = adress;

    }

    public List<OrderPosition> getOrderPosition() {
        return orderPosition;
    }

    public void setOrderPosition(List<OrderPosition> orderPosition) {
        this.orderPosition = orderPosition;
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
        return phoneNumber;
    }

    public void setPhoneNumber(PhoneNumber PhoneNumber) {
        this.phoneNumber = PhoneNumber;
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
