import java.io.File;
import java.util.ArrayList;

import Model.FileInfoList;
import Util.DbConnection;
import Model.Post;

public class Main {
	public static void main(String[] args) {
		
//		WpPost post = new WpPost();
		
		
		
		// file open
//		File file = new File(./);
//		file.listFiles();
		
		// getTitle
		
		// getContent
		
		// getTags
		
		// insert data
		String path = "\\Users\\Owner\\Desktop\\JAVA\\fileopenTest";
		
		DbConnection dbcn = new DbConnection();
		dbcn.dbConnect();
		
		FileInfoList fl = new FileInfoList();
		fl.findFileName(path);
		System.out.println(fl.getFileNameList());
		
		
		
		
		ArrayList<Post> postList = new ArrayList<Post>();
		
		
		
		
		// �������p�̃C���X�^���X�����
		Post post = new Post();
		post.setTitle("title");
		post.setContent("content");
		post.setExcerpt("exce");
		post.setPinged("pin");
		post.setTo_ping("topin");
		post.setContent_filtered("a");;
		
		
		postList.add(post);
		
		for(File f : fl) {
			// hoge(f,postList)
			// f�̓��e�����H����post���쐬�A�����postList�ɂق��肱�ރ��\�b�h
		
		}
		
		
		for(Post p : postList) {
			// ������insert����������
			
			DbConnection dbcn2 = new DbConnection();
			dbcn2.insertPost(p.getTitle(), p.getContent(), p.getExcerpt(), p.getTo_ping(), p.getPinged(), p.getContent_filtered());
//			String excerpt, String to_ping, String pinged,
//			String content_filtered) {
		}
		
		
		
	}
}