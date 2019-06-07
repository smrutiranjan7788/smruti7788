package com.Example.PreparedStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SelectPrepared {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/sanu", "root", "root");
			String UpdatesqlQuery ="SELECT * FROM employee WHERE id=?";
			PreparedStatement stmt= conn.prepareStatement(UpdatesqlQuery);
			//stmt.setInt(1, 10);
			//stmt.setString(1, "pinku");
			stmt.setInt(1, 12);
			ResultSet rs =stmt.executeQuery();
			while(rs.next())
			{
				int id= rs.getInt(1);
				String name=rs.getString(2);
				int age=rs.getInt(3);
				System.out.println("id="+id);
				System.out.println("Name="+name);
				System.out.println("Age="+age);
			}
			conn.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
	}

}
}
