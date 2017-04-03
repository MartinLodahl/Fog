/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fog.data;

import fog.domain.OrderItem;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Pravien
 */
public class OrderItemsMapper
{
    
    private final Connector connector;

    public OrderItemsMapper(Connector connector) {
        this.connector = connector;
       
    }
    
    public ArrayList<OrderItem> getOrderItemsByOrderId(int orderId) throws SQLException{
        ArrayList<OrderItem> list = new ArrayList();
        OrderItem orderItem;
        String query = "SELECT * FROM orderitems  WHERE order_id = ?;";
        PreparedStatement stmt = connector.getConnection().prepareStatement(query);
        stmt.setInt(1, orderId);
        ResultSet res = stmt.executeQuery();
        
        while(res.next()){
            int orderItemId = res.getInt("id");
            int material = res.getInt("material_id");
            int quantity = res.getInt("quantity");
           
            orderItem = new OrderItem(orderItemId,orderId,material,quantity);
            list.add(orderItem);
        }
        
        return list;
    }
    
}
