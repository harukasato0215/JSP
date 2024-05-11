package ex13;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SelectEmployees {

	public static void main(String[] args) {
	//JDBCドライバ
		try {
			Class.forName("org.mariadb.jdbc.Driver");
		}catch(ClassNotFoundException e) {
			throw new IllegalStateException("JDBCドライバ");
		}
		//"ダウンロードしたやつ://ざんぷのポート番号/sqlの名前"
		String db ="jdbc:mariadb://localhost:3306/example";
		String user ="root";
		String password ="";
		try(Connection conn = DriverManager.getConnection(db,user,password)){
			String sql ="SELECT * FROM EMPLOYEE";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			
		//sqlをじっこう、結果取得
			ResultSet rs = pStmt.executeQuery();
			//結果からレコード内容を表示
			while(rs.next()) {
				String id = rs.getString("ID");
				String name = rs.getString("NAME");
				int age = rs.getInt("AGE");
			
			System.out.println("ID"+id);
			System.out.println("NAME"+name);
			System.out.println("AGE"+age +"\n");
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
	

}
