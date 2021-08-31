package Converter;

/**
 * @param String fileName
 * @return String title
 * @exception
 * @desc #で始まる文字列のとき、#を抜いた文字列を返す。そうでないとき、無題を返す。
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
