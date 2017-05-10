/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fog.data;

import fog.domain.Material;
import fog.domain.Order;
import fog.domain.OrderItem;
import fog.domain.User;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author MartinLodahl
 */
public class FacadeMapper {

    private final Connector con;
    private final OrderMapper OM;
    private final MaterialMapper MM;
    private final OrderItemsMapper OIM;
    private final UserMapper UM;

    public FacadeMapper() {
        this.con = new Connector();
        this.OM = new OrderMapper(con);
        this.MM = new MaterialMapper(con);
        this.OIM = new OrderItemsMapper(con);
        this.UM = new UserMapper(con);
    }
//MaterialMapper

    public ArrayList<Material> createMaterialList(int length, int width, boolean skur, int heigth) throws CustomException {
        return MM.CreateMaterialList(length, width, skur, heigth);
    }

    public void createOrderItems(ArrayList<Material> list, int orderID) throws CustomException {
        MM.CreateOrderItems(list, orderID);
    }

    public void insertMatrial(Material material) throws CustomException {
        MM.insertMatrial(material);
    }
//OrderItemsMapper

    public ArrayList<OrderItem> getOrderItemsByOrderId(int orderId) throws CustomException {
        return OIM.getOrderItemsByOrderId(orderId);
    }
//Order Mapper

    public void updateOrder(Order order) throws CustomException {
        OM.updateOrder(order);
    }

    public Order getOrderById(int id) throws CustomException {
        return OM.getOrderById(id);
    }

    public List<Order> getAllActiveOrders(boolean check) throws CustomException {
        return OM.getAllActiveOrders(check);
    }

    public int createOrder(Order order) throws CustomException {
        return OM.createOrder(order);
    }

    public void deleteOrderById(int id) throws CustomException {
        OM.deleteOrderById(id);
    }

    public ArrayList<OrderItem> getOrderItems(int id) throws CustomException {
        return OM.getOrderItems(id);
    }
    
    public ArrayList<String> getBookedDates () throws CustomException {
        return OM.getBookedDates();
    }

    public double getOrderTotal(int id) throws CustomException {
        return OM.getOrderTotal(id);
    }

    //UserMapper
    public User getUserByUsername(String username) throws CustomException {
        return UM.getUserByUsername(username);
    }
}
