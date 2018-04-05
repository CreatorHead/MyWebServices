package com.webservices.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.caps.dto.Person;
import com.mysql.jdbc.Driver;

public class JDBCImpl {

	public Person getPerson(int regno) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			 //1. Load the Driver
			java.sql.Driver driverRef = new Driver();
			DriverManager.registerDriver(driverRef);
			
			//2. get the DB connection via Driver
			String dbUrl = "jdbc:mysql://localhost:3306/caps50_db?user=root&password=root";
			con = DriverManager.getConnection(dbUrl);
			
			//3. Issue the SQL query via connection
			String query1 = "select * from person_info pi, person_otherinfo po "
					+ " where pi.regno=po.regno and po.regno =? ";
			pstmt = con.prepareStatement(query1);
			pstmt.setInt(1, regno);
			
			rs = pstmt.executeQuery();
			
			
			
			//4. Process the results
			if(rs.next()) {
				Person p = new Person();
				p.setRegno(rs.getInt("regno")+"");
				p.setFirstname(rs.getString("firstname"));
				p.setLastname(rs.getString("lastname"));
				p.setPassword(rs.getString("password"));
				p.setIsAdmin(rs.getString("type"));
				
				return p;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			//5. Closing all the JDBC Objects
			try {
				if(pstmt != null) {
					pstmt.close();
				}
				if(con != null) {
					con.close();
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}
}
