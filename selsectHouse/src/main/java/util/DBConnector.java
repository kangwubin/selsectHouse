package util;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * 数据库连接
 * @author lenovo
 *
 */
public class DBConnector {

	public Connection connect() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/houselottery?characterEncoding=utf8&zeroDateTimeBehavior=convertToNull";
			String user = "root";
			String Sqlpassword = "issCollege";
			connection = DriverManager.getConnection(url, user, Sqlpassword);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return connection;
	}
}
