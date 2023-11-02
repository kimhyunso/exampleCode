package utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieManager {
	public static void makeCooke(HttpServletResponse response, String cName, String cValue, int cTime) {
		Cookie cookie = new Cookie(cName,cValue);
		cookie.setPath("/");
		cookie.setMaxAge(cTime);
		response.addCookie(cookie);
	}
	
	public static String readCookie(HttpServletRequest request, String cName) {
		String cookieValue = "";
		
		Cookie cookies[] = request.getCookies();
		if(cookies != null) {
			for(Cookie c : cookies) {
				String cookieName = c.getName();
				if(cName.equals(cookieName)) {
					cookieValue = c.getValue();
				}
			}
			
		}
		
		return cookieValue;
	}
	
	public static void deleteCookie(HttpServletResponse respons, String cName) {
		makeCooke(respons, cName, "", 0);
	}
	


}
