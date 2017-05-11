/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fog.business;

import fog.data.CustomException;
import fog.data.FacadeMapper;
import fog.domain.Material;
import fog.domain.Order;
import fog.domain.OrderItem;
import fog.domain.User;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Pravien
 */
public class BusinessFacadeMapper
{

    OrderCalculation orderCalculation;
    FacadeMapper facadeMapper;

    public BusinessFacadeMapper ()
    {
      orderCalculation = new OrderCalculation();  
    }

    public double getOrderTotal(int id) throws CustomException
    {

        return orderCalculation.getOrderTotal(id);
    }
    
    
    public ArrayList<Material> createMaterialList(int length, int width, boolean skur, int heigth) throws CustomException{
        return orderCalculation.createMaterialList(length, width, skur, heigth);
    }
            
    public void createOrderItems(ArrayList<Material> list, int orderID) throws CustomException {
        facadeMapper.createOrderItems(list, orderID);
    }

    public void insertMatrial(Material material) throws CustomException {
        facadeMapper.insertMatrial(material);
    }
    
    
//OrderItemsMapper

    public ArrayList<OrderItem> getOrderItemsByOrderId(int orderId) throws CustomException {
        return facadeMapper.getOrderItemsByOrderId(orderId);
    }
//Order Mapper

    public void updateOrder(Order order) throws CustomException {
        facadeMapper.updateOrder(order);
    }

    public Order getOrderById(int id) throws CustomException {
        return facadeMapper.getOrderById(id);
    }

    public List<Order> getAllActiveOrders(boolean check) throws CustomException {
        return facadeMapper.getAllActiveOrders(check);
    }

    public int createOrder(Order order) throws CustomException {
        return facadeMapper.createOrder(order);
    }

    public void deleteOrderById(int id) throws CustomException {
        facadeMapper.deleteOrderById(id);
    }

    public ArrayList<OrderItem> getOrderItems(int id) throws CustomException {
        return facadeMapper.getOrderItems(id);
    }
    
    public ArrayList<String> getBookedDates () throws CustomException {
        return facadeMapper.getBookedDates();
    }

    //UserMapper
    public User getUserByUsername(String username) throws CustomException {
        return facadeMapper.getUserByUsername(username);
    }
    
    

}
