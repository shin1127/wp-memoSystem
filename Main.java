import java.io.File;
import java.util.ArrayList;

import Converter.FileToPost;
import Model.FileInfoList;
import Util.DbConnection;
import Model.Post;

public class Main {
	/** WordPress記事変換システムのメインメソッド
	 * @param args 実行時引数 TILのディレクトリパス、DBホスト名、ユーザー名、パスワード
	 */
	public static void main(String[] args) {
		
//		WpPost post = new WpPost();
		
		// file open
//		File file = new File(./);
//		file.listFiles();

		// TILのディレクトリパス
		String DirectoryPath = args[0];
		
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
		
		// param1 url
		// param2 user-name
		// param3 password
		DbConnection dbcn2 = new DbConnection(args[1], args[2], args[3]);
		dbcn2.insertPosts(postList);
		
	}
}