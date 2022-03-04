package com;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;

public class Test2 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		
		String driver="oracle.jdbc.OracleDriver";
		String jdbc_url="jdbc:oracle:thin:@localhost:1521:XE";
		String user="system";
		 String pwd="password";
		Class.forName(driver);
		Connection con = DriverManager.getConnection(jdbc_url,user,pwd);
		
		CallableStatement call = con.prepareCall("{call getdetails(?,?)}");
		
		call.setInt(1, 101);
		
		call.registerOutParameter(2, Types.INTEGER);
		call.execute();
		System.out.println("The value of salary : "+call.getInt(2));
		con.close();
		
		
		
		

	}

}
