package Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Model.Post;

public class DbConnection {
	
	Connection con = null;
	String dsn;
	String user;
	String password;
	
	
//	public DbConnection(String dsn, String user, String password){
//		this.dsn = dsn;
//		this.user = user;
//		this.password = password;
//		connect();
//	}

	
	public DbConnection(String dsn, String user, String password){
		this.dsn = dsn;
		this.user = user;
		this.password = password;
	connect();
	}



//	public DbConnection(String dsn2, String user2, String password2) {
//		// TODO Auto-generated constructor stub
//	}




	//	public void connect(String dsn, String user, String password) {
	public void connect() {
		try {
			// このあたりの宣言はクラス変数として記述したほうがよい
			con = DriverManager.getConnection(dsn, user, password);
//			con = DriverManager.getConnection("jdbc:mysql://localhost/wordpress", "root", "1234");
			System.out.println("database connection ssuccessed ");
		}
		catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
	
	

	public void insertPost(String title, String content, String excerpt, String to_ping, String pinged,
		String content_filtered) throws SQLException {
		PreparedStatement pstmt = null;

			// このあたりの宣言はクラス変数として記述したほうがよい
//			con = DriverManager.getConnection("jdbc:mysql://localhost/wordpress", "root", "1234");
//			System.out.println("database connection ssuccessed ");

			try {
			String sql1 = "insert into wp_posts"
					+ "  (post_content, post_title, post_excerpt, to_ping, pinged, post_content_filtered)" + "  values"
					+ "  (?, ?, ?, ?, ?, ?)";

			pstmt = con.prepareStatement(sql1);

			pstmt = con.prepareStatement(sql1);
			pstmt.setString(1, content);
			pstmt.setString(2, title);
			pstmt.setString(3, excerpt);
			pstmt.setString(4, to_ping);
			pstmt.setString(5, pinged);
			pstmt.setString(6, content_filtered);
			int num = pstmt.executeUpdate();
			pstmt.close();
			}
			catch(Exception e) {
				throw e;
			}
		}
	
	
	
	public void insertPosts(ArrayList<Post> posts) {
		
		try {
			if(con == null) {
				connect();
			}
			
			for(Post p :posts) {
				insertPost(p.getTitle(), p.getContent(), p.getExcerpt(), p.getTo_ping(), p.getPinged(), p.getContent_filtered());
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
}
