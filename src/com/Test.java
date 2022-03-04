package com;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;

public class Test {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		
		String driver="oracle.jdbc.OracleDriver";
		String jdbc_url="jdbc:oracle:thin:@localhost:1521:XE";
		String user="system";
		 String pwd="password";
		Class.forName(driver);
		Connection con = DriverManager.getConnection(jdbc_url,user,pwd);
		
		CallableStatement call = con.prepareCall("{call addProc(?,?,?)}");
		
		call.setInt(1, 100);
		call.setInt(2, 200);
		
		call.registerOutParameter(3, Types.INTEGER);
		call.execute();
		System.out.println("The value of two num : "+call.getInt(3));
		con.close();
		
		
		
		

	}

}
