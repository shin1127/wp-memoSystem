package Converter;

interface Converter {
	
	String convert(String value);
	
	// interfaceではなくabstract classにして、
	// fieldにString lineなどを記述するのはどうか？
}
