package Converter;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import Model.Post;

/**
 * @author Owner
 *
 */
public class FileToPost {
	
	/** パスで指定したファイルから、記事生成に必要な情報を取得する
	 * @param path ファイルパス
	 * @param ary 記事情報を格納するリスト
	 */
	public void FileToPostMethod(String path, ArrayList<Post> ary){
		Post post = new Post();
		convertTitle(path, post);
		convertContent(path, post);
		convertExcerpt(path, post);
		convertTo_ping(path, post);
		convertPinged(path, post);
		convertContentFiltered(path, post);
		ary.add(post);
		
	}
	
	/**
	 * @param path
	 * @param post
	 */
	public void convertTitle(String path, Post post) {
		String title = new File(path).getName().replaceAll("\\.[^.]*$", "");
		post.setTitle(title);
	}
	
	/** 
	 * @param path ファイルパス
	 * @param post 
	 */
	public void convertContent(String path, Post post) {
		Path p = Paths.get(path);
		String content = "";
		try {
			content = Files.readString(p);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		post.setContent(content);
	}
	
	public void convertExcerpt(String path, Post post) {
		post.setExcerpt("");
	}
	
	public void convertTo_ping(String path, Post post) {
		post.setTo_ping("");
	}
	
	public void convertPinged(String path, Post post) {
		post.setPinged("");
	}
	
	public void convertContentFiltered(String path, Post post) {
		post.setContent_filtered("");
	}
}
