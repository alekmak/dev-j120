/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import models.OrderClient;
import models.PhoneNumber;
/**
 *
 * @author Алексей
 */
public class OrderClientsController {

    private List<OrderClient> clients = new ArrayList<>();
    private Set<PhoneNumber> numbers = new HashSet<>();

    public OrderClientsController(List<OrderClient> orders) {
        this.clients = orders;
    }

    public void add(PhoneNumber num, String name, String address) {
        if (numbers.contains(num)) {
            throw new IllegalArgumentException("Телефон уже зарегистрирован");
        }
        clients.add(new OrderClient(new Date(), name, num, address));
        numbers.add(num);
    }

    public void remove(int index) {
        OrderClient c = clients.remove(index);
        numbers.remove(c.getPhoneNumber());

    }

    public int getClientsCount() {
        return clients.size();
    }

    public OrderClient get(int index) {
        return clients.get(index);
    }
}
