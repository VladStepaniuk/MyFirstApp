package sample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;


public class DatabaseHandler extends Config {
    Connection dbConnection;

    public Connection getDbConnection() throws ClassNotFoundException, SQLException{
        String connectionString="jdbc:mysql://"+ dbHost + ":" + dbPort + "/" +dbName;
        Class.forName("com.mysql.jdbc.Driver");

        dbConnection=DriverManager.getConnection(connectionString, dbUser, dbPass);

        return dbConnection;
    }

    public void signUpUser(User user){
        String insert = "INSERT INTO "+Const.USER_TABLE+"("+Const.USERS_FIRSTNAME+", "+Const.USERS_LASTNAME+", "+
                Const.USERS_PASSWORD+", "+Const.USERS_LOCATION+","+Const.USERS_USERNAME+","+Const.USERS_GENDER+")"+
                "VALUES(?, ?, ?, ?, ?, ?)";

        try {
            PreparedStatement preSt = getDbConnection().prepareStatement(insert);
            preSt.setString(1, user.getFirstName());
            preSt.setString(2, user.getLastName());
            preSt.setString(3, user.getPassword());
            preSt.setString(4, user.getLocation());
            preSt.setString(5, user.getUsername());
            preSt.setString(6, user.getGender());
            preSt.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public ResultSet getUser(User user){
        ResultSet res = null;

        String select = "SELECT * FROM " + Const.USER_TABLE + " WHERE " + Const.USERS_USERNAME + "=? AND " + Const.USERS_PASSWORD + "=?";
        try {
            PreparedStatement prS = getDbConnection().prepareStatement(select);
            prS.setString(1, user.getUsername());
            prS.setString(2, user.getPassword());
            res=prS.executeQuery();
        }catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return res;
    }
}
