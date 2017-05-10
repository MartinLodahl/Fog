/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fog.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author MartinLodahl
 */
public class Connector {
      
   
    
    
    private final String driver = "com.mysql.jdbc.Driver";
    private final String URL = "jdbc:mysql://localhost:3306/fog";
    private final String id = "root";
    private final String pw = "fuck";

    public Connection getConnection() throws CustomException {
        Connection con = null;
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(URL, id, pw);  // The connection will be released upon program 

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MaterialMapper.class.getName()).log(Level.SEVERE, null, ex);
            throw new CustomException(ex.getMessage());
        } catch (SQLException ex) {
            Logger.getLogger(MaterialMapper.class.getName()).log(Level.SEVERE, null, ex);
            throw new CustomException(ex.getMessage());
        }

        return con;
    }

    public void releaseConnection(Connection con) throws SQLException {
        try {
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(MaterialMapper.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }
    }
}
