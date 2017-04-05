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
public class OrderItem
{
    
    private int id;
    private int orderId;
    private int materialId;
    private int quantity,length, width;
    private double price;

    public OrderItem(int id, int orderId, int materialId, int quantity, int length, int width, double price)
    {
        this.id = id;
        this.orderId = orderId;
        this.materialId = materialId;
        this.quantity = quantity;
        this.length = length;
        this.width = width;
        this.price = price;
    }

     public OrderItem(int orderId, int materialId, int quantity, int length, int width, double price)
    {
        this.orderId = orderId;
        this.materialId = materialId;
        this.quantity = quantity;
        this.length = length;
        this.width = width;
        this.price = price;
    }
    
    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public int getOrderId()
    {
        return orderId;
    }

    public void setOrderId(int orderId)
    {
        this.orderId = orderId;
    }

    public int getMaterialId()
    {
        return materialId;
    }

    public void setMaterialId(int materialId)
    {
        this.materialId = materialId;
    }

    public int getQuantity()
    {
        return quantity;
    }

    public void setQuantity(int quantity)
    {
        this.quantity = quantity;
    }
    
    
    
}
