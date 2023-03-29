
package employeemanagement;

import java.sql.*;

public class Conn {
    Connection c;
    Statement s;
    
    public Conn(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            c= DriverManager.getConnection("jdbc:mysql:///employeemanagement","root","admin");
            s=c.createStatement();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
}
