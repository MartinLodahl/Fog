/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fog.data;

import fog.domain.Order;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Pravien
 */
public class OrderMapper {

    private final Connector connector;

    public OrderMapper(Connector connector) {
        this.connector = connector;

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
            Order newOrder = new Order(orderId, customerName, customerEmail, customerPhone);

            return newOrder;

        } else {
            return null;
        }

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

    public static void main(String[] args) throws SQLException {
        Connector conn = new Connector();
        OrderMapper om = new OrderMapper(conn);

        om.finishOrder(100);
    }
}
