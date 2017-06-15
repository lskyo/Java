package DBUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;

public class DBUtil {

	private static final String URL = "jdbc:mysql://127.0.0.1:3306/jdbc_test";
	private static final String USER = "root";
	private static final String PASSWORD = "abc123";
	private static Connection conn = null;

	static {
		try {
			// 加载驱动程序
			Class.forName("com.mysql.jdbc.Driver");
			// 获得数据库的连接
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public static Connection getConnection() {
		return conn;
	}

//	public static void main(String[] args) throws ClassNotFoundException,
//			SQLException {
//		// 加载驱动程序
//		Class.forName("com.mysql.jdbc.Driver");
//		// 获得数据库的连接
//		Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
//		// 操作数据库
//		Statement stmt = (Statement) conn.createStatement();
//		ResultSet rs = stmt
//				.executeQuery("select user_name,age from jdbc_goddess");
//
//		while (rs.next()) {
//			System.out.println(rs.getString("user_name") + ","
//					+ rs.getInt("age"));
//		}
//
//	}
}
