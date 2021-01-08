package cn.jsu.luochulin.dbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**数据库连接类*/
public class DatabaseConnectionMySql {
	/**定义MySQL数据库连接地址*/
		private static final String DBRIVER="com.mysql.cj.jdbc.Driver";
		private static final String DBURL="jdbc:mysql://127.0.0.1:3306/carrot?serverTimezone=GMT";
		/**MySQL数据库连接用户名*/
		private static final String DBUSER="root"; 
		/**MySQL数据库连接密码*/
		private static final String PASSWORD=""; 
		private Connection conn=null; //保存连接对象
		/**构造方法连接数据库*/
		public DatabaseConnectionMySql(){
			try {
				Class.forName(DBRIVER);
				this.conn=DriverManager.getConnection(DBURL,DBUSER,PASSWORD);
			} catch (Exception e) {e.printStackTrace();}
		}
		/**返回数据库连接对象*/
		public Connection getConnection() {
			return this.conn;
		}
		/**关闭数据连接*/
		public void close() {
			if(this.conn!=null) {
				try {
					this.conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		public static void main(String args[]) {
			DatabaseConnectionMySql dc=new DatabaseConnectionMySql();
			if(dc.getConnection()!=null) {
				System.out.println(1);
			}
		}
	}
