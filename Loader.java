import letters.A;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

public class Loader {
	public static void main(final String[] args) throws MalformedURLException, InstantiationException, ClassNotFoundException, IllegalAccessException {
		new A();
		
		URL[] classUrls = { new URL("file:///Users/glenn/workspace/classloader-playground/letters/"),
				    new URL("file:///Users/glenn/workspace/classloader-playground/letters/nested/") };
		URLClassLoader ucl = new URLClassLoader(classUrls);

		Class bClass = ucl.loadClass("letters.B");
		bClass.newInstance();	

		try {
			Class cClass = ucl.loadClass("letters.nested.C");
		} catch(ClassNotFoundException cnfe) {
			System.out.println(cnfe);
		}
		cClass.newInstance();	
	}
}
