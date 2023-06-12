package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager{
	private static final String LOCAL = "jdbc:oracle:thin:@127.0.0.1:1521/xe";
	private static final String USER = "hr";
	private static final String PASS = "hr";
	private Connection cn = null;
	private static ConnectionManager manager = null;


	public static ConnectionManager getInstance() {
		if(manager == null) {
			System.out.println("getInstance");
			manager = new ConnectionManager();
		}
		return manager;
	}


	public Connection getConnection() {
		System.out.println("Connection");

		if(cn == null) {
			System.out.println("Connection");
			try {
				Class.forName("oracle.jdbc.OracleDriver");
				cn = DriverManager.getConnection(LOCAL,USER,PASS);
				cn.setAutoCommit(false);
			}catch(ClassNotFoundException e) {
				e.printStackTrace();
				System.out.println("fail");
			}catch(SQLException e) {
				e.printStackTrace();
				System.out.println("fail");
			}
		}
		return cn;
	}

	public void beginTransaction() {
		System.out.println("beginTransaction");
		if(cn == null) {
			getConnection();
		}
	}


	public void commit() {
		System.out.println("commit");
		try {
			cn.commit();
		}
		catch(SQLException e) {
			System.out.println("commitFail");
			e.printStackTrace();
		}
	}


	public void rollback() {
		System.out.println("rollback");
		try {
			cn.rollback();
		}
		catch(SQLException e) {
			System.out.println("rollbackFail");
			e.printStackTrace();
		}
	}


	public void closeTransaction() {
		System.out.println("closeTransaction");
		try {
			if(cn != null) {
				cn.close();
				cn = null;
			}
		}
		catch(SQLException e) {
			System.out.println("closeTransactionFail");
			e.printStackTrace();
		}
	}

}