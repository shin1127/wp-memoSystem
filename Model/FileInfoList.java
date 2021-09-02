package Model;

import java.io.File;
import java.util.ArrayList;

public class FileInfoList {
	
	public ArrayList<String> fileNameList = new ArrayList<String>();
	
	
	
	public ArrayList<String> findFileName(String path) {
		File file = new File(path);
		File[] list = file.listFiles();

		for(File f : list) {
			if(f.isFile()) {
				fileNameList.add(f.getName());
//				System.out.println(f +"‚±‚ê‚Ífile‚¾");
			}
			else if(f.isDirectory()) {
				findFileName(f.getAbsolutePath());
			}
		}
		return fileNameList;
	}
	
	public ArrayList<String> getFileNameList(){
		return fileNameList;
	}
}
