import java.sql.*;

public class databaseJDBC {
    public static void main(String[] args) {
    	Connection connection = null;
    
    	try {
    	  connection = DriverManager.getConnection("jdbc:mysql://localhost/demo?" + "user=root&password=swarev123");
    	  Statement statement = connection.createStatement();  
    	  ResultSet resultSet = statement.executeQuery("{call DemoProcedure()}");  
    	  while(resultSet.next())  
    	  System.out.println(resultSet.getInteger(1)+" "+resultSet.getString(2)+" "+rs.getInteger(3)+" "+rs.getInteger(4)+" "+rs.getString(5));  
    	  connection.close();  
    	} catch (Exception exception) {
    	    System.out.println("Operation can not be completed. Please try again.");
    	}
    }
}
