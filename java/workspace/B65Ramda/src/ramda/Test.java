package ramda;

class Car implements MyInterface
{

	@Override
	public void method() {
		// TODO Auto-generated method stub
		
	}
	
}

interface MyInterface
{
	public void method();
}

interface YourInterface
{
	public void method(int param);
}

interface OurInterface
{
	public int method(int param1, int param2);
}


public class Test {

	public static void main(String[] args) {
		MyInterface mi = ()->{System.out.println("1st method()");};
		mi.method();
		
		mi =()->{
			System.out.println("2nd method()");
		};
		mi.method();
		
		mi = ()->System.out.println("3rd method()");
		mi.method();
		
		YourInterface yi = (a)->{
			int result = a * a;
			System.out.println("1st method(int) , result = " + result);
		};
		yi.method(3);
		
		yi = (b)->{
			int result = b * b * b;
			System.out.println("2nd method(int), result = " + result);
		};
		yi.method(3);
		
		yi = (b)->{System.out.println("3nd method(int), result = "+ b * b * b * b);};
		yi.method(3);
		
		yi = c-> System.out.println("4th method(int) = " + c*c*c*c*c);
		yi.method(3);
		
		OurInterface oi = (a, b)->{
			int result = a * b;
			System.out.println("1st method(int, int) = " + result);
			return result;
		};
		
		oi.method(3,  4);
		
		oi = (a, b)->{return a * b; };
		oi.method(3,  4);
		System.out.println(oi.method(5,  4));		
	}

}
