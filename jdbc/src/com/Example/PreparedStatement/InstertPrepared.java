package com.Example.PreparedStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class InstertPrepared {
	public static void main(String[] args)
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/sanu", "root", "root");
			String sql ="insert into employee(name,age) value(?,?)";
			PreparedStatement stmt= conn.prepareStatement(sql);
			//stmt.setInt(1, 10);
			stmt.setString(1, "pinku");
			stmt.setInt(2, 24);
			int i=stmt.executeUpdate();
			System.out.println(i+"record inserted");
			conn.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		}
	

}
