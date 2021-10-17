package advJava;

class A {
	static {
		System.out.println("class loading");
	}
	
	// .NoSuchMethodException
//	A(int i) {
//		System.out.println("object creation");
//	}
//	
	// IllegalAccessException
//	private A() {
//		System.out.println("object creation");
//	}
	
	A() {
		System.out.println("object creation");
	}
//	
	public void m1() {
		System.out.println("m1 method");
	}
}

public class StaticTest {

	public static void main(String[] args) throws Exception {
//		A a1 = new A();
//		System.out.println(a1);
		
		Class<?> c = Class.forName("advJava.A");
//		Object obj = c.newInstance(); // deprecated in java 9
		Object obj = c.getDeclaredConstructor().newInstance();
		
		A a1 = (A) obj;
		a1.m1();
		
	}

}
