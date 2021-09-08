import java.io.File;
import java.util.ArrayList;

import Converter.FileToPost;
import Model.FileInfoList;
import Util.DbConnection;
import Model.Post;

public class Main {
	public static void main(String[] args) {
		
//		WpPost post = new WpPost();
		
		// file open
//		File file = new File(./);
//		file.listFiles();

		String DirectoryPath = "\\Users\\Owner\\Desktop\\JAVA\\fileopenTest";
		
		FileInfoList fl = new FileInfoList();
		System.out.println(fl.getFilePathList());
		System.out.println(fl.getFileNameList());
		

		ArrayList<Post> postList = new ArrayList<Post>();
		
		// お試し用のインスタンスつくるよ
		Post post = new Post();
		post.setTitle("title");
		post.setContent("content");
		post.setExcerpt("exce");
		post.setPinged("pin");
		post.setTo_ping("topin2");
		post.setContent_filtered("a");
		
		postList.add(post);
		
		
		Post post2 = new Post();
		post2.setTitle("title2");
		post2.setContent("content");
		post2.setExcerpt("exce");
		post2.setPinged("pin");
		post2.setTo_ping("topin3");
		post2.setContent_filtered("a");
		
		postList.add(post2);
		
		FileToPost ftp = new FileToPost();
		
		
		//
		ArrayList<String> filePathList = new ArrayList<>();
		
		// ディレクトリパスからファイルパスを取得するメソッドをここで使う
		FileInfoList fil = new FileInfoList();
		fil.findInfo(DirectoryPath);
		
		for(String filePath : fil.getFilePathList()) {
			ftp.FileToPostMethod(filePath, postList);
		}
		
		
		DbConnection dbcn2 = new DbConnection("jdbc:mysql://localhost/wordpress", "root", "1234");
		dbcn2.insertPosts(postList);
		
	}
}