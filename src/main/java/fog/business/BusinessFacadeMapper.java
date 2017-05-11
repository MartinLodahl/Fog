package fog.business;

import fog.data.CustomException;
import fog.data.FacadeMapper;
import fog.domain.Material;
import fog.domain.Order;
import fog.domain.OrderItem;
import fog.domain.User;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BusinessFacadeMapper {

    private final OrderCalculation orderCalculation;
    private final FacadeMapper facadeMapper;

    public BusinessFacadeMapper() {
        orderCalculation = new OrderCalculation();
        facadeMapper = new FacadeMapper();
    }

    public double getOrderTotal(int id) throws BusinessException {
        return orderCalculation.getOrderTotal(id);
    }

    public ArrayList<Material> createMaterialList(int length, int width, boolean skur, int heigth) throws BusinessException {
        return orderCalculation.createMaterialList(length, width, skur, heigth);
    }

    public void createOrderItems(ArrayList<Material> list, int orderID) throws BusinessException {
        try {
            facadeMapper.createOrderItems(list, orderID);
        } catch (CustomException ex) {
            Logger.getLogger(BusinessFacadeMapper.class.getName()).log(Level.SEVERE, null, ex);
            throw new BusinessException(ex.getMessage());
        }
    }

    public void insertMatrial(Material material) throws BusinessException {
        try {
            facadeMapper.insertMatrial(material);
        } catch (CustomException ex) {
            Logger.getLogger(BusinessFacadeMapper.class.getName()).log(Level.SEVERE, null, ex);
            throw new BusinessException(ex.getMessage());
        }
    }

//OrderItemsMapper
    public ArrayList<OrderItem> getOrderItemsByOrderId(int orderId) throws BusinessException {
        try {
            return facadeMapper.getOrderItemsByOrderId(orderId);
        } catch (CustomException ex) {
            Logger.getLogger(BusinessFacadeMapper.class.getName()).log(Level.SEVERE, null, ex);
            throw new BusinessException(ex.getMessage());
        }
    }
//Order Mapper

    public void updateOrder(Order order) throws BusinessException {
        try {
            facadeMapper.updateOrder(order);
        } catch (CustomException ex) {
            Logger.getLogger(BusinessFacadeMapper.class.getName()).log(Level.SEVERE, null, ex);
            throw new BusinessException(ex.getMessage());
        }
    }

    public Order getOrderById(int id) throws BusinessException {
        try {
            return facadeMapper.getOrderById(id);
        } catch (CustomException ex) {
            Logger.getLogger(BusinessFacadeMapper.class.getName()).log(Level.SEVERE, null, ex);
            throw new BusinessException(ex.getMessage());
        }
    }

    public List<Order> getAllActiveOrders(boolean check) throws BusinessException {
        try {
            return facadeMapper.getAllActiveOrders(check);
        } catch (CustomException ex) {
            Logger.getLogger(BusinessFacadeMapper.class.getName()).log(Level.SEVERE, null, ex);
            throw new BusinessException(ex.getMessage());
        }
    }

    public int createOrder(Order order) throws BusinessException {
        try {
            return facadeMapper.createOrder(order);
        } catch (CustomException ex) {
            Logger.getLogger(BusinessFacadeMapper.class.getName()).log(Level.SEVERE, null, ex);
            throw new BusinessException(ex.getMessage());
        }
    }

    public void deleteOrderById(int id) throws BusinessException {
        try {
            facadeMapper.deleteOrderById(id);
        } catch (CustomException ex) {
            Logger.getLogger(BusinessFacadeMapper.class.getName()).log(Level.SEVERE, null, ex);
            throw new BusinessException(ex.getMessage());
        }
    }

    public ArrayList<OrderItem> getOrderItems(int id) throws BusinessException {
        try {
            return facadeMapper.getOrderItems(id);
        } catch (CustomException ex) {
            Logger.getLogger(BusinessFacadeMapper.class.getName()).log(Level.SEVERE, null, ex);
            throw new BusinessException(ex.getMessage());
        }
    }

    public ArrayList<String> getBookedDates() throws BusinessException {
        try {
            return facadeMapper.getBookedDates();
        } catch (CustomException ex) {
            Logger.getLogger(BusinessFacadeMapper.class.getName()).log(Level.SEVERE, null, ex);
            throw new BusinessException(ex.getMessage());
        }
    }

    //UserMapper
    public User getUserByUsername(String username) throws BusinessException {
        try {
            return facadeMapper.getUserByUsername(username);
        } catch (CustomException ex) {
            Logger.getLogger(BusinessFacadeMapper.class.getName()).log(Level.SEVERE, null, ex);
            throw new BusinessException(ex.getMessage());
        }
    }

}
