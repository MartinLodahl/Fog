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
                Double size = res.getDouble("size");
                Double price = res.getDouble("price");
                for (int i = 0; i < 4; i++) {
                    list.add(new Material(id, name, type, size, price));
                }
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
                Double size = res.getDouble("size");
                Double price = res.getDouble("price");
                for (int i = 0; i < 4; i++) {
                    list.add(new Material(id, name, type, size, price * heigth / 100));
                }
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
                Double size = res.getDouble("size");
                Double price = res.getDouble("price");
                for (int i = 0; i < 2; i++) {
                    list.add(new Material(id, name, type, size, price));
                }
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
                for (int i = 0; i < 2; i++) {
                    list.add(new Material(id, name, type, length, price * length / 100));
                }
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
                Double size = res.getDouble("size");
                Double price = res.getDouble("price");
                for (int i = 0; i < 2; i++) {
                    list.add(new Material(id, name, type, size, price));
                }
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
                for (int i = 0; i < 2; i++) {
                    list.add(new Material(id, name, type, width, price * width / 100));
                }
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
            list.add(new Material(id, name, type, width, length, price * (width * heigth) / 10000));
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
            list.add(new Material(id, name, type, width, length, price * (width * heigth) / 10000));
        }
        query = "SELECT * FROM materials where type='plade';";
        stmt = connector.getConnection().prepareStatement(query);
        res = stmt.executeQuery();
        if (res.next()) {
            int id = res.getInt("id");
            String name = res.getString("name");
            String type = res.getString("type");
            Double price = res.getDouble("price");

            for (int i = 0; i < 2; i++) {
                list.add(new Material(id, name, type, width, heigth, price * (width * heigth) / 10000));
            }
        }
        query = "SELECT * FROM materials where type='plade';";
        stmt = connector.getConnection().prepareStatement(query);
        res = stmt.executeQuery();
        if (res.next()) {
            int id = res.getInt("id");
            String name = res.getString("name");
            String type = res.getString("type");
            Double price = res.getDouble("price");

            for (int i = 0; i < 2; i++) {
                list.add(new Material(id, name, type, length, heigth, price * (length * heigth) / 10000));
            }
        }
        return list;
    }
}
