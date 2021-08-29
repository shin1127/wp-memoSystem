package Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DbConnection {

	public void dbConnect() {
		// .envの中身を読み出し、その内容を用いてログインを行う処理
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = DriverManager.getConnection(
					"jdbc:mysql://localhost/website",
					"root",
					"1234"
					);// "password"の部分は，各自の環境に合わせて変更してください。
			System.out.println("database connection ssuccessed ");
			pstmt = con.prepareStatement("select * from website");

			rs = pstmt.executeQuery();

//			while (rs.next()) {
//				System.out.println(rs.getString("name"));
//				System.out.println(rs.getInt("age"));
//			}

		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}   
		}
	}
}
