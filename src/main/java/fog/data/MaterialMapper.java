/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fog.data;

import fog.domain.Material;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MaterialMapper {

    private final Connector connector;

    public MaterialMapper(Connector connector) {
        this.connector = connector;
    }



    public void createOrderItems(ArrayList<Material> list, int orderID) throws CustomException {
        try {
            for (int i = 0; i < list.size(); i++) {
                String query = "INSERT INTO orderitems "
                        + "(order_id, material_id, quantity, length, width, price) "
                        + "VALUES ( ?, ?, ?, ?, ?, ?);";
                PreparedStatement stmt = connector.getConnection().prepareStatement(query);
                stmt.setInt(1, orderID);
                stmt.setInt(2, list.get(i).getId());
                stmt.setInt(3, list.get(i).getQuantity());
                stmt.setInt(4, list.get(i).getSize());
                stmt.setInt(5, list.get(i).getSize2());
                stmt.setDouble(6, list.get(i).getPrice());
                stmt.executeUpdate();
            }
        } catch (SQLException ex) {
            Logger.getLogger(MaterialMapper.class.getName()).log(Level.SEVERE, null, ex);
            throw new CustomException(ex.getMessage());
        }
    }

    public void insertMatrial(Material material) throws CustomException {
        String query = "insert into materials (name, type, size, price) "
                + "values (?,?,?,?);";
        PreparedStatement stmt;
        try {
            stmt = connector.getConnection().prepareStatement(query);
            stmt.setString(1, material.getName());
            stmt.setString(2, material.getType());
            stmt.setInt(3, material.getSize());
            stmt.setDouble(4, material.getPrice());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(MaterialMapper.class.getName()).log(Level.SEVERE, null, ex);
            throw new CustomException(ex.getMessage());
        }
    }

    public Material getByType(String type, int size, int quantity) throws CustomException {
        try {
            String query = "SELECT * FROM materials where type=?;";
            PreparedStatement stmt = connector.getConnection().prepareStatement(query);
            stmt.setString(1, type);
            ResultSet res = stmt.executeQuery();
            while (res.next()) {
                if (res.getInt("size") == size) {
                        int id = res.getInt("id");
                        String name = res.getString("name");
                        Double price = res.getDouble("price");
                        return (new Material(id, name, type, size, price, quantity));
                    
                }
            }

            query = "SELECT * FROM materials where type=? and size=?;";
            stmt = connector.getConnection().prepareStatement(query);
            stmt.setString(1, type);
            stmt.setInt(2, 0);
            res = stmt.executeQuery();
            if (res.next()) {
                int id = res.getInt("id");
                String name = res.getString("name");
                Double price = res.getDouble("price");
                return (new Material(id, name, type, size, price * size / 100, quantity));

            }
        } catch (SQLException ex) {
            Logger.getLogger(MaterialMapper.class.getName()).log(Level.SEVERE, null, ex);
            throw new CustomException(ex.getMessage());
        }
        return null;
    }

    public Material get2DimensionalItem(String type, int size1, int size2, int quantity) throws CustomException {
        try {
            String query = "SELECT * FROM materials where type=?;";
            PreparedStatement stmt = connector.getConnection().prepareStatement(query);
            stmt.setString(1, type);
            ResultSet res = stmt.executeQuery();
            if (res.next()) {
                int id = res.getInt("id");
                String name = res.getString("name");
                Double price = res.getDouble("price");
                return (new Material(id, name, type, size1, size2, price * (size2 * size1) / 10000, quantity));
            }

        } catch (SQLException ex) {
            Logger.getLogger(MaterialMapper.class.getName()).log(Level.SEVERE, null, ex);
            throw new CustomException(ex.getMessage());
        }
        return null;
    }

}
