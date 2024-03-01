package LMS.dao;
import LMS.db.DBConnection;
import LMS.model.User;

import java.sql.*;

public class UserDao implements UserDaoInterface{
    //DBConnection connection=new DBConnection();

    @Override
    public boolean addUser(User user) {
        boolean flag = false;
        try {

            Connection con = DBConnection.createConnection();
            String query = "INSERT INTO users(username, password) VALUES (?, ?)";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, user.getUsername());
            pst.setString(2, user.getPassword());
            int rowsAffected = pst.executeUpdate();
            if (rowsAffected > 0)
                flag = true;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return flag;
    }

    @Override
    public boolean loginUser(String username, String password) {
        boolean flag = false;
        try {
            Connection con = DBConnection.createConnection();
            String query = "SELECT * FROM users WHERE username=? AND password=?";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, username);
            pst.setString(2, password);
            ResultSet rs = pst.executeQuery();
            if (rs.next())
                flag = true;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return flag;
    }
}