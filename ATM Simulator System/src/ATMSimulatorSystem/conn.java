//we need to create first "project1" database
//now we need register JDBC driver in our program and it register only once in our program.
//most common approach to establish connect is 
        // Class.forName() method
//To dynamically load the drivers class file into memory which automatically register it.

package ATMSimulatorSystem;

import java.sql.*;

public class conn {
    Connection c;
    Statement s;
    public conn()
    {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            //above is one driver class to attched with our database
            c=DriverManager.getConnection("jdbc:mysql:///project1","root",""); //connection URL
            //Above url with username:"root", password:"you can enter password here"
            s=c.createStatement();
            //statements s = its used to access to our database and its useful when we're using static SQL statements at runtime.
        }catch(Exception e)
        {
            System.out.println(e);
        }
        
    }

    ResultSet executeQuery(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
