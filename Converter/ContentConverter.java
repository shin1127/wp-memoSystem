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
	
	// #�Ŏn�܂�Ƃ��A�w�b�_�[�^�O�֒u������
	private boolean headerConvert(String value) {
		
		
		return true;
	}
	
	
}