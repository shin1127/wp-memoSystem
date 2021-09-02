package SqlQuery;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

class InsertQuery extends Query{
	
	String title;
	String content;
	String sql;
	
	void execute(String title, String content, String excerpt, String to_ping, String pinged){
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		

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
			
			int num = pstmt.executeUpdate();

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
