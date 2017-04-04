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

    public ArrayList<Material> CreateMaterialList(int length, int width, boolean skur, int heigth) throws SQLException {

        if (skur == false) {
            return CalculateCarport(length, width, heigth);
        } else {
            return CalculateSkur(length, width, heigth);
        }

    }

    public ArrayList<Material> CalculateCarport(int length, int width, int heigth) throws SQLException {
        ArrayList<Material> list = new ArrayList<>();
        if (heigth == 500 || heigth == 200) {
            String query = "SELECT * FROM materials where type='stolpe' and size=?;";
            PreparedStatement stmt = connector.getConnection().prepareStatement(query);
            stmt.setInt(1, heigth);
            ResultSet res = stmt.executeQuery();
            if (res.next()) {
                int id = res.getInt("id");
                String name = res.getString("name");
                String type = res.getString("type");
                int size = res.getInt("size");
                Double price = res.getDouble("price");

                list.add(new Material(id, name, type, size, price, 4));

            }
        } else {
            String query = "SELECT * FROM materials where type='stolpe' and size=?;";
            PreparedStatement stmt = connector.getConnection().prepareStatement(query);
            stmt.setInt(1, 0);
            ResultSet res = stmt.executeQuery();
            if (res.next()) {
                int id = res.getInt("id");
                String name = res.getString("name");
                String type = res.getString("type");
                int size = res.getInt("size");
                Double price = res.getDouble("price");
                list.add(new Material(id, name, type, size, price * heigth / 100, 4));

            }
        }

        if (length == 500) {
            String query = "SELECT * FROM materials where type='brædde' and size=?;";
            PreparedStatement stmt = connector.getConnection().prepareStatement(query);
            stmt.setInt(1, length);
            ResultSet res = stmt.executeQuery();
            if (res.next()) {
                int id = res.getInt("id");
                String name = res.getString("name");
                String type = res.getString("type");
                int size = res.getInt("size");
                Double price = res.getDouble("price");
                list.add(new Material(id, name, type, size, price, 2));
            }
        } else {
            String query = "SELECT * FROM materials where type='brædde' and size=?;";
            PreparedStatement stmt = connector.getConnection().prepareStatement(query);
            stmt.setInt(1, 0);
            ResultSet res = stmt.executeQuery();
            if (res.next()) {
                int id = res.getInt("id");
                String name = res.getString("name");
                String type = res.getString("type");
                Double price = res.getDouble("price");
                list.add(new Material(id, name, type, length, price * length / 100, 2));
            }
        }

        if (width == 500) {
            String query = "SELECT * FROM materials where type='brædde' and size=?;";
            PreparedStatement stmt = connector.getConnection().prepareStatement(query);
            stmt.setInt(1, width);
            ResultSet res = stmt.executeQuery();
            if (res.next()) {
                int id = res.getInt("id");
                String name = res.getString("name");
                String type = res.getString("type");
                int size = res.getInt("size");
                Double price = res.getDouble("price");

                list.add(new Material(id, name, type, size, price, 2));

            }
        } else {
            String query = "SELECT * FROM materials where type='brædde' and size=?;";
            PreparedStatement stmt = connector.getConnection().prepareStatement(query);
            stmt.setInt(1, 0);
            ResultSet res = stmt.executeQuery();
            if (res.next()) {
                int id = res.getInt("id");
                String name = res.getString("name");
                String type = res.getString("type");
                Double price = res.getDouble("price");

                list.add(new Material(id, name, type, width, price * width / 100, 2));

            }
        }
        String query = "SELECT * FROM materials where type='tag';";
        PreparedStatement stmt = connector.getConnection().prepareStatement(query);
        ResultSet res = stmt.executeQuery();
        if (res.next()) {
            int id = res.getInt("id");
            String name = res.getString("name");
            String type = res.getString("type");
            Double price = res.getDouble("price");
            list.add(new Material(id, name, type, width, length, price * (width * heigth) / 10000, 1));
        }
        return list;
    }

    private ArrayList<Material> CalculateSkur(int length, int width, int heigth) throws SQLException {
        ArrayList<Material> list = new ArrayList<>();
        String query = "SELECT * FROM materials where type='tag';";
        PreparedStatement stmt = connector.getConnection().prepareStatement(query);
        ResultSet res = stmt.executeQuery();
        if (res.next()) {
            int id = res.getInt("id");
            String name = res.getString("name");
            String type = res.getString("type");
            Double price = res.getDouble("price");
            list.add(new Material(id, name, type, width, length, price * (width * heigth) / 10000, 1));
        }
        query = "SELECT * FROM materials where type='plade';";
        stmt = connector.getConnection().prepareStatement(query);
        res = stmt.executeQuery();
        if (res.next()) {
            int id = res.getInt("id");
            String name = res.getString("name");
            String type = res.getString("type");
            Double price = res.getDouble("price");

            list.add(new Material(id, name, type, width, heigth, price * (width * heigth) / 10000, 2));

        }
        query = "SELECT * FROM materials where type='plade';";
        stmt = connector.getConnection().prepareStatement(query);
        res = stmt.executeQuery();
        if (res.next()) {
            int id = res.getInt("id");
            String name = res.getString("name");
            String type = res.getString("type");
            Double price = res.getDouble("price");

            list.add(new Material(id, name, type, length, heigth, price * (length * heigth) / 10000, 2));

        }
        return list;
    }

    public void CreateOrderItems(ArrayList<Material> list, int orderID) throws SQLException {
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

    }
}


/*
CREATE TABLE orderitems (
	id INTEGER PRIMARY KEY AUTO_INCREMENT NOT NULL,
	order_id INTEGER NOT NULL REFERENCES orders(id),
	material_id INTEGER NOT NULL REFERENCES materials(id),
	quantity INTEGER NOT NULL
);*/
