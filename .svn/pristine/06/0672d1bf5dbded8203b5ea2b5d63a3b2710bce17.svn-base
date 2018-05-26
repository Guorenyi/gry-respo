package cn.mldn.util.dbc;

import java.sql.Connection;
import java.sql.SQLException;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class DatabaseConnection {
	
	public static final String DATABASE_DRIVER = "com.mysql.jdbc.Driver" ;
	public static final String DATABASE_URL = "jdbc:mysql://192.168.28.198:3306/mldn?characterEncoding=UTF-8" ;
	public static final String DATABASE_USER = "eop" ;
	public static final String DATABASE_PASSWORD = "eopadminmldn8889" ;
	public static final ThreadLocal<Connection> THREAD_LOCAL = new ThreadLocal<Connection>() ;
	private static HikariDataSource ds ;
	static {
		//	    HikariConfig config = new HikariConfig("src/cn/mldn/resource/hikari.properties");
//		HikariDataSource ds = new HikariDataSource(config);
	    HikariConfig config = new HikariConfig();
        config.setJdbcUrl(DATABASE_URL);
		config.setUsername(DATABASE_USER);
		config.setPassword(DATABASE_PASSWORD);
		config.setDriverClassName(DATABASE_DRIVER);
        config.addDataSourceProperty("cachePrepStmts", "true");
        config.setMaximumPoolSize(2);
        config.setAutoCommit(true);
        config.setMinimumIdle(5);
        config.setMaxLifetime(60); 
        config.setLeakDetectionThreshold(15000);
        config.setConnectionTestQuery("SELECT 1");
        config.setConnectionTimeout(10000);
		ds = new HikariDataSource(config);
	}
	private static Connection rebuildConnection() throws Exception {
		
		Connection conn = ds.getConnection();
		return conn ;
	}
	public static Connection getConnection() {
		Connection conn = THREAD_LOCAL.get() ;
		if (conn == null) {
			try {
				conn = rebuildConnection() ;
				THREAD_LOCAL.set(conn); // 进行连接的信息保存
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return conn ;
	}
	public static void close() {
		Connection conn = THREAD_LOCAL.get() ;
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} 
		}
		THREAD_LOCAL.remove(); 
	}
	public static boolean isClosed() {
		return THREAD_LOCAL.get()==null?true:false;
	}
}
