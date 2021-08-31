package Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DbConnection {

	public void dbConnect() {
		// .envの中身を読み出し、その内容を用いてログインを行う処理?
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

//		try {
//
//			con = DriverManager.getConnection(
//					"jdbc:mysql://localhost/wordpress",
//					"root",
//					"1234"
//					);
//			System.out.println("database connection ssuccessed ");
//			pstmt = con.prepareStatement("select * from wp_posts");
//
//			rs = pstmt.executeQuery();
//
//			while (rs.next()) {
//				System.out.println(rs.getString("id"));
//				System.out.println(rs.getString("post_title"));
//			}
//
//		} 
//		catch (SQLException e) {
//			e.printStackTrace();
//		}
//		finally {
//			if (rs != null) {
//				try {
//					rs.close();
//				} catch (SQLException e) {
//					e.printStackTrace();
//				}
//			}
//			if (pstmt != null) {
//				try {
//					pstmt.close();
//				} catch (SQLException e) {
//					e.printStackTrace();
//				}
//			}
//			if (con != null) {
//				try {
//					con.close();
//				} catch (SQLException e) {
//					e.printStackTrace();
//				}
//			}   
//		}
		
		// insert処理
		
		// 検証用に宣言するフィールド
		String title = "no title";
		String content = "no content";
		String excerpt = "no excerpt";
		String to_ping = "to_ping";
		String pinged = "pinged";
		String content_filtered = "filtered";

		try {

			con = DriverManager.getConnection(
					"jdbc:mysql://localhost/wordpress",
					"root",
					"1234"
					);
			System.out.println("database connection ssuccessed ");
			
			String sql = "insert into wp_posts"
					+ "  (post_content, post_title, post_excerpt, to_ping, pinged, post_content_filtered)"
					+ "  values"
					+ "  (?, ?, ?, ?, ?, ?)";
			
			pstmt = con.prepareStatement(sql);
			
			// プレースホルダは1始まりらしい
			pstmt.setString(1, content);
			pstmt.setString(2, title);
			pstmt.setString(3, excerpt);
			pstmt.setString(4, to_ping);
			pstmt.setString(5, pinged);
			pstmt.setString(6, content_filtered);
			
			

			int num = pstmt.executeUpdate();
//			while (rs.next()) {
//				System.out.println(rs.getString("id"));
//				System.out.println(rs.getString("post_title"));
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
