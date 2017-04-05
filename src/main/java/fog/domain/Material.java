/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fog.domain;

/**
 *
 * @author Pravien
 */
public class Material {

    private int id, quantity,  size, size2;
    private String name, type;
    private double price;

    public Material(int id, String name, String type, int size, int size2, double price, int quantity) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.size = size;
        this.size2 = size2;
        this.price = price;
        this.quantity = quantity;
    }

    public Material(int id, String name, String type, int size, double price, int quantity) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.size = size;
        this.size2 = 0;
        this.price = price;
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getSize() {
        return size;
    }

    public int getSize2() {
        return size2;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
