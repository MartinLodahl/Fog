/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fog.data;

import fog.domain.Order;
import fog.domain.OrderItem;
import fog.domain.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Pravien
 */
public class OrderMapper {

    private final Connector connector;

    public OrderMapper(Connector connector) {
        this.connector = connector;

    }
    
    public void updateOrder (Order order) throws SQLException{
        String query = "UPDATE orders SET customer_name = ? , customer_email = ?, customer_phone = ?, isFinished = ?"
                + ", width = ? , height = ?, length = ?, skur = ? "
                + " WHERE id = ?;";
        
        PreparedStatement stmt = connector.getConnection().prepareStatement(query);
        stmt.setString(1, order.getCustomerName());
        stmt.setString(2, order.getCustomerMail());
        stmt.setString(3, order.getCustomerPhone());
        stmt.setBoolean(4, order.isIsFinished());
        stmt.setInt(5, order.getWidth());
        stmt.setInt(6, order.getHeight());
        stmt.setInt(7, order.getLength());
        stmt.setBoolean(8, order.isSkur());
        stmt.setInt(9, order.getId());
        
        stmt.executeUpdate();
    }

    public Order getOrderById(int id) throws SQLException {

        String query = "SELECT * FROM orders  WHERE id = ?;";
        PreparedStatement stmt = connector.getConnection().prepareStatement(query);
        stmt.setInt(1, id);
        ResultSet res = stmt.executeQuery();

        if (res.next()) {
            int orderId = res.getInt("id");
            String customerName = res.getString("customer_name");
            String customerEmail = res.getString("customer_email");
            String customerPhone = res.getString("customer_phone");
            boolean isFinished = res.getBoolean("isFinished");
            int width = res.getInt("width");
            int length = res.getInt("length");
            int height = res.getInt("height");
            boolean isSkur = res.getBoolean("skur");
            Order newOrder = new Order(orderId, customerName, customerEmail, customerPhone,
                    isFinished, width, length, height, isSkur);

            return newOrder;

        } else {
            return null;
        }

    }

    public int createOrder(Order order) throws SQLException {
        String query = "INSERT INTO orders "
                + "(customer_name, customer_email, customer_phone, "
                + "isFinished, width, length, height, skur) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
        Connection connection = connector.getConnection();
        PreparedStatement stmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        stmt.setString(1, order.getCustomerName());
        stmt.setString(2, order.getCustomerMail());
        stmt.setString(3, order.getCustomerPhone());
        stmt.setBoolean(4, order.isIsFinished());
        stmt.setInt(5, order.getWidth());
        stmt.setInt(6, order.getLength());
        stmt.setInt(7, order.getHeight());
        stmt.setBoolean(8, order.isSkur());
        stmt.executeUpdate();
        ResultSet generatedKeys = stmt.getGeneratedKeys();
        if (generatedKeys.next()) {
            return generatedKeys.getInt(1);
        }
        return 0;
    }

    public void deleteOrderById(int id) throws SQLException {

        String query = "DELETE FROM orders where id = ?";
        PreparedStatement stmt = connector.getConnection().prepareStatement(query);
        stmt.setInt(1, id);
        stmt.executeUpdate();
    }

    public void finishOrder(int id) throws SQLException {
        String query = "UPDATE orders SET isFinished=true where id = ?";
        PreparedStatement stmt = connector.getConnection().prepareStatement(query);
        stmt.setInt(1, id);
        stmt.executeUpdate();
    }

    public void unFinishOrder(int id) throws SQLException {
        String query = "UPDATE orders SET isFinished=false where id = ?";
        PreparedStatement stmt = connector.getConnection().prepareStatement(query);
        stmt.setInt(1, id);
        stmt.executeUpdate();
    }

    public ArrayList<OrderItem> getOrderItems(int id) throws SQLException {
        ArrayList<OrderItem> list = new ArrayList<>();
        String query = "SELECT * FROM orderitems  WHERE id = ?;";
        PreparedStatement stmt = connector.getConnection().prepareStatement(query);
        stmt.setInt(1, id);
        ResultSet res = stmt.executeQuery();
        while (res.next()) {
            int order_id = res.getInt("order_id");
            int material_id = res.getInt("material_id");
            int quantity = res.getInt("quantity");
            int length = res.getInt("length");
            int width = res.getInt("width");
            double price = res.getDouble("price");
            list.add(new OrderItem(order_id, material_id, quantity, length, width, price));
        }
        return list;
    }
}
