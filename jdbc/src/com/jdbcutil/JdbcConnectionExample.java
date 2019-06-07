package com.jdbcutil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcConnectionExample {
	static Statement smt=null;
	public static void main(String [] args)throws SQLException
	{
		Connection conn=DatabaseConnection.getMySqlConnection();
		smt = conn.createStatement();
		ResultSet rs=smt.executeQuery("SELECT * FROM pinku.new_table");
		while(rs.next())
		{
			System.out.println("id=" +rs.getInt(1) + "Name=" +rs.getString(2) + "age=" + rs.getInt(3));
		}
		
	}

}
