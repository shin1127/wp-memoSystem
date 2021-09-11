package Model;

import java.io.File;
import java.util.ArrayList;

public class FileInfoList {
	
	private ArrayList<String> filePathList = new ArrayList<String>();
	private ArrayList<String> fileNameList = new ArrayList<String>();
	
	
	public ArrayList<String> findInfo(String path) {
		File file = new File(path);
		File[] list = file.listFiles();

		for(File f : list) {
			if(f.isFile()) {
				filePathList.add(f.getAbsolutePath());
				System.out.println("filenameis");
				System.out.println(f.getName());
				fileNameList.add(f.getName().replaceAll("\\.[^.]*$", ""));
			}
			else if(f.isDirectory()) {
				String dirPath = f.getAbsolutePath();
				String dirName = f.getName();
//				if(dirName.matches("*.git")) {
				if(".git".equals(dirName)) {
					continue;
				}
				findInfo(dirPath);
			}
		}
		return filePathList;
	}
	
	
	
	public ArrayList<String> getFilePathList(){
		return filePathList;
	}
	public ArrayList<String> getFileNameList(){
		return fileNameList;
	}
}
