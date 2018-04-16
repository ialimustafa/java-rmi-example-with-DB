import java.rmi.*;
import java.rmi.server.*;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class AdderRemote extends UnicastRemoteObject implements Adder
{
AdderRemote() throws RemoteException
{
super();
}
public int delexp(int x, int y)
{
    
 String z=Integer.toString(x+y);
{
try
{
Class.forName("com.mysql.jdbc.Driver");
Connection conn = null;
conn = DriverManager.getConnection("jdbc:derby://localhost:1527/details","root", "root");
//Statement stmt = null;
//stmt = conn.createStatement();  
      String sql = "UPDATE debit SET expense = ? where id = ?";
      //stmt.executeUpdate(sql);
     // String query = "update users set num_points = ? where first_name = ?";
      PreparedStatement preparedStmt = conn.prepareStatement(sql);
      preparedStmt.setString(1,z);
      preparedStmt.setInt(2, 1);
      // execute the java preparedstatement
      preparedStmt.executeUpdate();
conn.close();
return x+y;
}
catch(Exception e)
{
System.out.print("Do not connect to DB - Error:"+e);
}
}
    return x+y;
    
    
}
public int addinc(int x, int y)
{
    String z=Integer.toString(x+y);
{
try
{
Class.forName("com.mysql.jdbc.Driver");
Connection conn = null;
conn = DriverManager.getConnection("jdbc:derby://localhost:1527/details","root", "root");
//Statement stmt = null;
//stmt = conn.createStatement();  
      String sql = "UPDATE debit SET income = ? where id = ?";
      //stmt.executeUpdate(sql);
     // String query = "update users set num_points = ? where first_name = ?";
      PreparedStatement preparedStmt = conn.prepareStatement(sql);
      preparedStmt.setString(1,z);
      preparedStmt.setInt(2, 1);
      // execute the java preparedstatement
      preparedStmt.executeUpdate();
conn.close();
return x+y;
}
catch(Exception e)
{
System.out.print("Do not connect to DB - Error:"+e);
}
}
    return x+y;
    
}
public String[] dbconn(int id)
{
try
{
Class.forName("com.mysql.jdbc.Driver");
Connection conn = null;
conn = DriverManager.getConnection("jdbc:derby://localhost:1527/details","root", "root");
Statement stmt = null;
stmt = conn.createStatement();  
      String sql = "SELECT * FROM debit"; 
      ResultSet rs = stmt.executeQuery(sql);
      String ar[]=new String[5];
        while(rs.next()) { 
         // Retrieve by column name 
         ar[0]= Integer.toString(rs.getInt("id")); 
         ar[1]= rs.getString("name"); 
         ar[2] = rs.getString("income"); 
         ar[3] = Integer.toString(rs.getInt("expense")); 
        }
conn.close();
return ar;
}
catch(Exception e)
{
System.out.print("Do not connect to DB - Error:"+e);
}
    return null;
}
}