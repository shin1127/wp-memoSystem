package Model;

import java.io.File;
import java.util.ArrayList;

public class FileList {
	
	ArrayList<String> fileNameList;
	
	
	
	
	
	
	public ArrayList<String> findFileName(String path, ArrayList<String> ary) {
		File file = new File(path);
		File[] list = file.listFiles();

		for(File f : list) {
			if(f.isFile()) {
				ary.add(f.getName());
//				System.out.println(f +"‚±‚ê‚Ífile‚¾");
			}
			else if(f.isDirectory()) {
				findFileName(f.getAbsolutePath(), ary);
			}
		}
		return ary;
	}
}
