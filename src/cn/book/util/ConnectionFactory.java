package cn.book.util;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


/*
* c3p0数据库连接工具类
* */
public class ConnectionFactory {
	//获取数据源 自动读取c3p0-config.xml文件，使用ComboPooledDataSource来生成DataSource的实例
	private static DataSource dataSource = new ComboPooledDataSource();
	
	//从连接池中获取连接
	public static Connection getConnection() {
		try {
			return dataSource.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	//资源关闭工具方法
	public static void close(Connection connection,PreparedStatement preparedStatement,ResultSet resultSet) {
		try {
			//释放资源，根据先开后放
			if(resultSet != null)  resultSet.close();
			if(preparedStatement != null)  preparedStatement.close();
			if(connection != null)  connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
