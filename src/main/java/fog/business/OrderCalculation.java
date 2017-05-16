package fog.business;

import fog.data.CustomException;
import fog.domain.Order;
import fog.domain.OrderItem;
import java.util.List;
import fog.data.FacadeMapper;
import fog.domain.Material;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class OrderCalculation
{
    private FacadeMapper fMapper;
    
    public OrderCalculation(){
        fMapper = new FacadeMapper();
    }
    
    public double getOrderTotal(int id) throws BusinessException {
        try {
            Order order = fMapper.getOrderById(id);
            List<OrderItem> orderItems = fMapper.getOrderItems(id);
            double total = 0;
            for (OrderItem orderItem : orderItems) {
                total += orderItem.getQuantity() * orderItem.getPrice();
            }
            if (order.isBuild()) {
                total += 1700;
            }
            return total;
        } catch (CustomException ex) {
            Logger.getLogger(BusinessFacadeMapper.class.getName()).log(Level.SEVERE, null, ex);
            throw new BusinessException(ex.getMessage());
        }
    }
    
    public ArrayList<Material> createMaterialList(int length, int width, boolean skur, int heigth) throws BusinessException {
        if (skur == false) {
            return CalculateCarport(length, width, heigth);
        } else {
            return CalculateSkur(length, width, heigth);
        }
    }

    private ArrayList<Material> CalculateCarport(int length, int width, int heigth) throws BusinessException {
        try {
            ArrayList<Material> list = new ArrayList<>();
            //get stolper med size heigth

            list.add(fMapper.getByType("stolpe", heigth, 4));
            //get braedde med size length
            list.add(fMapper.getByType("braedde", length, 2));
            //get braedde med size width
            list.add(fMapper.getByType("braedde", width, 2));
            //get tag
            list.add(fMapper.get2DimensionalItem("tag", width, length, 1));
            return list;
        } catch (CustomException ex) {
            Logger.getLogger(BusinessFacadeMapper.class.getName()).log(Level.SEVERE, null, ex);
            throw new BusinessException(ex.getMessage());
        }
    }

    private ArrayList<Material> CalculateSkur(int length, int width, int heigth) throws BusinessException {
        try {
            ArrayList<Material> list = new ArrayList<>();
            //Get tag
            list.add(fMapper.get2DimensionalItem("tag", width, length, 1));
            //Get plade by size width and heigth
            list.add(fMapper.get2DimensionalItem("plade", width, heigth, 2));
            //Get plade by size length and heigth
            list.add(fMapper.get2DimensionalItem("plade", length, heigth, 2));
            return list;
        } catch (CustomException ex) {
            Logger.getLogger(BusinessFacadeMapper.class.getName()).log(Level.SEVERE, null, ex);
            throw new BusinessException(ex.getMessage());
        }
    }
}
