package fog.data;

import fog.domain.Material;
import fog.domain.Order;
import fog.domain.OrderItem;
import fog.domain.User;
import java.util.ArrayList;
import java.util.List;

public class FacadeMapper {

    private final Connector connector;
    private final OrderMapper orderMapper;
    private final MaterialMapper materialMapper;
    private final OrderItemsMapper orderItemsMapper;
    private final UserMapper userMapper;

    public FacadeMapper() {
        this.connector = new Connector();
        this.orderMapper = new OrderMapper(connector);
        this.materialMapper = new MaterialMapper(connector);
        this.orderItemsMapper = new OrderItemsMapper(connector);
        this.userMapper = new UserMapper(connector);
    }
//MaterialMapper

    public Material getByType(String type, int size, int quantity) throws CustomException{
       return materialMapper.getByType(type, size, quantity);
    }
    
    public Material get2DimensionalItem(String type, int size1, int size2, int quantity) throws CustomException{
        return materialMapper.get2DimensionalItem(type, size1, size2, quantity);
    }

    public void createOrderItems(ArrayList<Material> list, int orderID) throws CustomException {
        materialMapper.createOrderItems(list, orderID);
    }

    public void insertMatrial(Material material) throws CustomException {
        materialMapper.insertMatrial(material);
    }
//OrderItemsMapper

    public ArrayList<OrderItem> getOrderItemsByOrderId(int orderId) throws CustomException {
        return orderItemsMapper.getOrderItemsByOrderId(orderId);
    }
//Order Mapper

    public void updateOrder(Order order) throws CustomException {
        orderMapper.updateOrder(order);
    }

    public Order getOrderById(int id) throws CustomException {
        return orderMapper.getOrderById(id);
    }

    public List<Order> getAllActiveOrders(boolean check) throws CustomException {
        return orderMapper.getAllActiveOrders(check);
    }

    public int createOrder(Order order) throws CustomException {
        return orderMapper.createOrder(order);
    }

    public void deleteOrderById(int id) throws CustomException {
        orderMapper.deleteOrderById(id);
    }

    public ArrayList<OrderItem> getOrderItems(int id) throws CustomException {
        return orderMapper.getOrderItems(id);
    }
    
    public ArrayList<String> getBookedDates () throws CustomException {
        return orderMapper.getBookedDates();
    }

    //UserMapper
    public User getUserByUsername(String username) throws CustomException {
        return userMapper.getUserByUsername(username);
    }
}
