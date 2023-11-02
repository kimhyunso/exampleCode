package utils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public class Encoding {
	public static String number(String input) throws UnsupportedEncodingException {
		return URLDecoder.decode(input, "UTF-8");
	}
}
