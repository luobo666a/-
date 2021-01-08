package cn.jsu.luochulin.dbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**���ݿ�������*/
public class DatabaseConnectionMySql {
	/**����MySQL���ݿ����ӵ�ַ*/
		private static final String DBRIVER="com.mysql.cj.jdbc.Driver";
		private static final String DBURL="jdbc:mysql://127.0.0.1:3306/carrot?serverTimezone=GMT";
		/**MySQL���ݿ������û���*/
		private static final String DBUSER="root"; 
		/**MySQL���ݿ���������*/
		private static final String PASSWORD=""; 
		private Connection conn=null; //�������Ӷ���
		/**���췽���������ݿ�*/
		public DatabaseConnectionMySql(){
			try {
				Class.forName(DBRIVER);
				this.conn=DriverManager.getConnection(DBURL,DBUSER,PASSWORD);
			} catch (Exception e) {e.printStackTrace();}
		}
		/**�������ݿ����Ӷ���*/
		public Connection getConnection() {
			return this.conn;
		}
		/**�ر���������*/
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
