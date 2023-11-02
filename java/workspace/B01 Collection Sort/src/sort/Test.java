package sort;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

// Sorting, Shuffle

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String[] lang = {"C", "JAVA", "PHP", "ASP", "JSP", "PYTHON"};
		List<String> list = Arrays.asList(lang);
		Collections.sort(list);
		System.out.println(list);
		
		Collections.sort(list, Collections.reverseOrder());
		System.out.println(list);
		
		// µ•¿Ã≈Õ ºØ±‚
		Collections.shuffle(list);
		System.out.println(list);
	}

}

