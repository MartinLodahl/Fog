package fog.data;

import fog.domain.OrderItem;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class OrderItemsMapper
{
    
    private final IConnector connector;

    public OrderItemsMapper(IConnector connector) {
        this.connector = connector;
       
    }
    
    public ArrayList<OrderItem> getOrderItemsByOrderId(int orderId) throws CustomException {
        try {
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
                int length = res.getInt("length");
                int width = res.getInt("width");
                double price = res.getDouble("price");
               //int length, int width, int price
                orderItem = new OrderItem(orderItemId,orderId,material,quantity, length, width, price);
                list.add(orderItem);
            }

            return list;
        } catch (SQLException ex) {
            Logger.getLogger(MaterialMapper.class.getName()).log(Level.SEVERE, null, ex);
            throw new CustomException(ex.getMessage());
        }
    }
    
}
