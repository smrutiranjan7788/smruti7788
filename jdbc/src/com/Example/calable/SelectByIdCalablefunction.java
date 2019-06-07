package com.Example.calable;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SelectByIdCalablefunction {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/sanu", "root", "root");
			String UpdatesqlQuery ="call getAllEmployee1(?)";
			CallableStatement stmt= conn.prepareCall(UpdatesqlQuery);
			//stmt.setInt(1, 10);
			//stmt.setString(1, "pinku");
			stmt.setInt(1, 13);
			ResultSet rs =stmt.executeQuery();
			while(rs.next())
			{				
				String name=rs.getString(2);							
				System.out.println("Name="+name);
			}
			conn.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
	}

}
}
