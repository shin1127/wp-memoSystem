import java.io.File;
import Model.FileList;
import Util.DbConnection;

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
		
		FileList fl = new FileList();
		fl.findFileName(path);
		System.out.println(fl.getFileNameList());
		
		
		
	}
}