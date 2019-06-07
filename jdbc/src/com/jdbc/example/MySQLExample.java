package com.jdbc.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQLExample {
	public static void main(String[] args) {
		Connection conn = null;
		Statement smt = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sanuS", "root", "root");
			smt = conn.createStatement();
			ResultSet rs = smt.executeQuery("SELECT * FROM pinku.new_table");
			while (rs.next()) {
				System.out.println("id=" + rs.getInt(1) + "name=" + rs.getString(2) + "age=" + rs.getInt(3));
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.getStackTrace();
		} finally {
			try {
				smt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}
}
