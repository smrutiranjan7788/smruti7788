package com.Example.PreparedStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class UpdatePrepared {
	public static void main(String[] args)
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/sanu", "root", "root");
			String UpdatesqlQuery ="UPDATE employee SET name=?,age=? where id=?";
			PreparedStatement stmt= conn.prepareStatement(UpdatesqlQuery );
			stmt.setString(1, "pinku");
			stmt.setInt(2,22);
			stmt.setInt(3, 12);
			
			int i=stmt.executeUpdate();
			System.out.println(i+"record updated");
			conn.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
	}

}
}
