package cn.yh.dbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DateBaseConnection {
	private static final String DBDRIVER= "oracle.jdbc.driver.OracleDriver";
	private static final String DBURL= "jdbc:oracle:thin:@localhost:1521:orcl";
	private static final String USER= "scott";
	private static final String PASSWORD= "tiger";
	private Connection conn;
	public DateBaseConnection(){
		try {
			Class.forName(DBDRIVER);
			this.conn = DriverManager.getConnection(DBURL,USER,PASSWORD);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public Connection getConn(){
		return this.conn;
	}
	public void close(){
		try {
			this.conn.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	

}
