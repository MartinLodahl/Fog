package fog.data;


import fog.data.CustomException;
import fog.data.MaterialMapper;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Pravien
 */
public interface IConnector
{
    public Connection getConnection() throws CustomException ;
        
    

    public void releaseConnection(Connection con) throws SQLException;
    
}
