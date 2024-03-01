package LMS.db;
import java.sql.*;

public class DBConnection {
    static Connection con;

    public static Connection createConnection(){

        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "Sanju@14");
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Database connection created successfully.");

        }
        catch(Exception ex){
            ex.printStackTrace();
        }

        return con;
    }

}
