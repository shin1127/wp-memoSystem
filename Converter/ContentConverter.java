package Converter;

/**
 * @param String fileName
 * @return String title
 * @exception
 * 
		 */
public class ContentConverter implements Converter {
			
	public String convert(String value) {
		String title = "";
		
		title = value.replaceAll("# ", "");
				
		// TODO
		// Validation check
		title = value.replaceAll("\\.*", "");
		if() {
			
		}
		return title;
	}
	
	// #で始まるとき、ヘッダータグへ置換する
	private boolean headerConvert(String value) {
		
		
		return true;
	}
	
	
}