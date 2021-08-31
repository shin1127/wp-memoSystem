package Converter;

/**
 * @param String fileName
 * @return String title
 * @exception
 * @desc #�Ŏn�܂镶����̂Ƃ��A#�𔲂����������Ԃ��B�����łȂ��Ƃ��A�����Ԃ��B
 */
public class TitleConverter implements Converter {
	
		public String convert(String value) {
		String title;
		
		
		if(value.length() < 3) {
			return "No Title";
		}
		
		if(value.substring(0, 1).equals("# ")) {
			title = value.replaceAll("# ", "");
			return title;
		}
		return "No Title";
	}
}
