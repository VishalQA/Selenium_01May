package selenium_framework;

public class JAVAClassloader {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Class c = JAVAClassloader.class;
		System.out.println(c.getClassLoader());
		System.out.println(String.class.getClassLoader());
	}

}
