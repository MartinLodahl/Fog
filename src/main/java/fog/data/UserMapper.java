package fog.data;

import fog.domain.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserMapper
{
    private final Connector connector;

    public UserMapper(Connector connector) {
        this.connector = connector;
    }

    public User getUserByUsername(String username) throws CustomException {
        try {
            String query = "SELECT * FROM users  WHERE username = ?;";
            Connection connection = connector.getConnection();
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, username);
            ResultSet res = stmt.executeQuery();

            if (res.next()) {
                String password = res.getString("password");
                User user = new User(username, password);
                return user;
            } else {
                return null;
            }
        } catch (SQLException ex) {
            Logger.getLogger(MaterialMapper.class.getName()).log(Level.SEVERE, null, ex);
            throw new CustomException(ex.getMessage());
        }
    }
    
    public void createUser(User user) throws CustomException {
        try
        {
            String query = "insert into materials (name, type, size, price) "
                    + "values (?,?,?,?);";
            PreparedStatement stmt = connector.getConnection().prepareStatement(query);
            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getPassword());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(MaterialMapper.class.getName()).log(Level.SEVERE, null, ex);
            throw new CustomException(ex.getMessage());
        }
    }
}
