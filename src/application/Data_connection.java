package application;
import java.sql.*;

public class Data_connection {

	public static void main(String[] args) {
		Connection connection = null;
		Statement statement;
		ResultSet resultSet;
		String query; 
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/javadatabaseproject", "root", "");
			//System.out.println("Successful connection");
			 
			statement = connection.createStatement();
			query = "SELECT G.NumPeople From guest AS G WHERE Zip = \"71809\";";
			resultSet = statement.executeQuery(query);
			
			while(resultSet.next())
			{
				System.out.println(resultSet.getString("NumPeople"));
			}
			
			
			
		}
		catch(Exception exception)
		{
			System.out.println("Exception: " + exception.getMessage());
		}
		
		finally
		{
			try
            {
               if(connection != null)
                  connection.close();
            }
            catch(SQLException e) {}
		}

	}

}
