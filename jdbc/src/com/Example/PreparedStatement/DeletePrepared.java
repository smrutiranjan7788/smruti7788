package com.Example.PreparedStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DeletePrepared {
	public static void main(String[]args)
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/sanu", "root", "root");
			String DeletesqlQuery ="delete from employee where id=?";
			PreparedStatement stmt= conn.prepareStatement(DeletesqlQuery);
			stmt.setInt(1, 13);
			int i=stmt.executeUpdate();
			System.out.println(i+"record deleted");
			conn.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
	}

}
}
