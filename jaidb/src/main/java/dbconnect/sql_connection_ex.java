package dbconnect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class sql_connection_ex {

	public static void main(String []arg) throws SQLException {
		
        String url = "jdbc:mysql://localhost:3306/mydb";
        String username = "root";
        String password = "12345"; 
        
        try(Connection connect = DriverManager.getConnection(url,username,password)){
        	if(connect != null) {
        		System.out.println("connected");
        		
        		Statement stmt = connect.createStatement();
        		
        		String query = "Select * from person";
        		
        		ResultSet rs = stmt.executeQuery(query);
        		
        		while(rs.next()) {
        			int id = rs.getInt("ID");
        			String name = rs.getString("Name");
        			int age = rs.getInt("Age");
        			String department = rs.getString("department");
        			System.out.println("ID :" + id + ",Name :" + name + ", AGE :" + age + " ,department :" + department);
        		}
        	}
        }
		
	}
	
}
