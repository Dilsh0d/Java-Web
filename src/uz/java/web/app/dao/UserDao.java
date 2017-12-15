package uz.java.web.app.dao;

import org.mindrot.BCrypt;
import uz.java.web.app.dto.UserData;
import uz.java.web.app.jdbc.DbConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDao {

    public boolean hasUsername(String username) {
        Connection connection = DbConnection.getConnection();
        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("SELECT id FROM users WHERE u_username='"+username+"'");

            boolean isHasUser = rs.next();

            rs.close();
            st.close();

            return isHasUser;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void createUser(String username,String password,String firstname,String lastname,boolean isAdmin){
        Connection connection = DbConnection.getConnection();
        try {
            String insertUser = "INSERT INTO users(u_username,p_password,firstname,lastname,is_admin) VALUES(?,?,?,?,?)";
            PreparedStatement st = connection.prepareStatement(insertUser);
            st.setString(1,username);
            st.setString(2, BCrypt.hashpw(password,BCrypt.gensalt(12)));
            st.setString(3,firstname);
            st.setString(4,lastname);
            st.setBoolean(5,isAdmin);
            st.executeUpdate();
            st.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void createUser(String username,String password,String firstname,String lastname){
        createUser(username,password,firstname,lastname,false);
    }

    public List<UserData> getUserList(){
        List<UserData> userDataList = new ArrayList<>();
        Connection connection = DbConnection.getConnection();
        String selectUser = "SELECT id,u_username,p_password,firstname,lastname,is_admin FROM users ";
        try {
            PreparedStatement st = connection.prepareStatement(selectUser);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                UserData userData = new UserData();
                userData.setId(rs.getLong(1));
                userData.setUsername(rs.getString(2));
                userData.setPassword(rs.getString(3));
                userData.setFirstname(rs.getString(4));
                userData.setAdmin(rs.getBoolean(5));
                userDataList.add(userData);
            }
            st.close();
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userDataList;
    }

    public UserData getUserByUsername(String username){
        UserData userData = new UserData();
        Connection connection = DbConnection.getConnection();
        String selectUser = "SELECT id,u_username,p_password,firstname,lastname,is_admin FROM users WHERE u_username=? ";
        try {
            PreparedStatement st = connection.prepareStatement(selectUser);
            st.setString(1,username);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                userData.setId(rs.getLong(1));
                userData.setUsername(rs.getString(2));
                userData.setPassword(rs.getString(3));
                userData.setFirstname(rs.getString(4));
                userData.setLastname(rs.getString(5));
                userData.setAdmin(rs.getBoolean(6));
            }
            st.close();
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userData;
    }

    public UserData getUserById(Long id){
        UserData userData = new UserData();
        Connection connection = DbConnection.getConnection();
        String selectUser = "SELECT id,u_username,p_password,firstname,lastname,is_admin FROM users WHERE id=? ";
        try {
            PreparedStatement st = connection.prepareStatement(selectUser);
            st.setLong(1,id);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                userData.setId(rs.getLong(1));
                userData.setUsername(rs.getString(2));
                userData.setPassword(rs.getString(3));
                userData.setFirstname(rs.getString(4));
                userData.setAdmin(rs.getBoolean(5));
            }
            st.close();
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userData;
    }
}
