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

/**
 *
 * @author MartinLodahl
 */
public class MaterialMapper {

    private final Connector connector;

    public MaterialMapper(Connector connector) {
        this.connector = connector;
    }

    public ArrayList<Material> CreateMaterialList(int length, int width, boolean skur, int heigth) {
        ArrayList<Material> list = new ArrayList<>();
        try {
            String query = "SELECT * FROM materials where type='stolpe' and size=?;";
            PreparedStatement stmt = connector.getConnection().prepareStatement(query);
            stmt.setInt(1, heigth);
            ResultSet res = stmt.executeQuery();
            if (res.next()) {
                int id = res.getInt("id");
                String name = res.getString("name");
                String type = res.getString("type");
                Double size = res.getDouble("size");
                Double price = res.getDouble("price");
                for (int i = 0; i < 4; i++) {
                    list.add(new Material(id, name, type, size, price));
                }
            }

            if (length == 500) {
                query = "SELECT * FROM materials where type='brædde' and size=?;";
                stmt = connector.getConnection().prepareStatement(query);
                stmt.setInt(1, length);
                res = stmt.executeQuery();
                if (res.next()) {
                    int id = res.getInt("id");
                    String name = res.getString("name");
                    String type = res.getString("type");
                    Double size = res.getDouble("size");
                    Double price = res.getDouble("price");
                    for (int i = 0; i < 2; i++) {
                        list.add(new Material(id, name, type, size, price));
                    }
                }
            } else {
                query = "SELECT * FROM materials where type='brædde' and size=?;";
                stmt = connector.getConnection().prepareStatement(query);
                stmt.setInt(1, 0);
                res = stmt.executeQuery();
                if (res.next()) {
                    int id = res.getInt("id");
                    String name = res.getString("name");
                    String type = res.getString("type");
                    Double price = res.getDouble("price");
                    for (int i = 0; i < 2; i++) {
                        list.add(new Material(id, name, type, length, price * length / 100));
                    }
                }
            }

            if (width == 500) {
                query = "SELECT * FROM materials where type='brædde' and size=?;";
                stmt = connector.getConnection().prepareStatement(query);
                stmt.setInt(1, width);
                res = stmt.executeQuery();
                if (res.next()) {
                    int id = res.getInt("id");
                    String name = res.getString("name");
                    String type = res.getString("type");
                    Double size = res.getDouble("size");
                    Double price = res.getDouble("price");
                    for (int i = 0; i < 2; i++) {
                        list.add(new Material(id, name, type, size, price));
                    }
                }
            } else {
                query = "SELECT * FROM materials where type='brædde' and size=?;";
                stmt = connector.getConnection().prepareStatement(query);
                stmt.setInt(1, 0);
                res = stmt.executeQuery();
                if (res.next()) {
                    int id = res.getInt("id");
                    String name = res.getString("name");
                    String type = res.getString("type");
                    Double price = res.getDouble("price");
                    for (int i = 0; i < 2; i++) {
                        list.add(new Material(id, name, type, width, price * width / 100));
                    }
                }
            }

            return list;
        } catch (SQLException ex) {
            Logger.getLogger(MaterialMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public static void main(String[] args) {
        Connector con = new Connector();
        MaterialMapper MM = new MaterialMapper(con);
        ArrayList<Material> list = MM.CreateMaterialList(500, 40, true, 500);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).getId());
            System.out.println(list.get(i).getName());
            System.out.println(list.get(i).getSize());
            System.out.println(list.get(i).getType());
            System.out.println(list.get(i).getPrice());
        }
    }
}
