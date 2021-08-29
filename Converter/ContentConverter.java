package Converter;

/**
 * @param String fileName
 * @return String title
 * @exception
 * 
 */
public class ContentConverter implements Converter {

	// 入力された1行のmarkdown形式の文字列をHTMLに変換する
	public String convert(String line) {
		
		line = headerConvert(line);
		line = listConvert(line);
				
		return line;
	}

	// #で始まるとき、ヘッダータグへ置換する
	private String headerConvert(String line) {

		if(line.length() < 2){
			return line;
		}
		else {
			line = line.substring(0, 1);
		}
		
		if(("# ").equals(line)) {
			line += "<h1>" + line.substring(0, 1) + "</h1>";
			return line;
		}
		
		
		if(("## ").equals(line)) {
			line += "<h2>" + line.substring(0, 1) + "</h2>";
			return line;

		}
		return line;
	}
	
	private String listConvert(String value) {
		String line = "";
		if(value.length() < 2){
			return "";
		}
		else {
			line = value.substring(0, 1);
		}
		
		if("- ".equals(line)) {
			return "・" + line;
		}
		
		// TODO ネストされたリストタグのとき
		return line;
	}
	
	
}