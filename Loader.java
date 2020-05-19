import letters.A;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

public class Loader {
	public static void main(final String[] args) throws MalformedURLException, InstantiationException, ClassNotFoundException, IllegalAccessException {
		new A();
		
		URL classUrl = new URL("file:///Users/glenn/workspace/classloader-playground/letters/");
		URL[] classUrls = { classUrl };
		URLClassLoader ucl = new URLClassLoader(classUrls);
		Class bClass = ucl.loadClass("letters.B");
		bClass.newInstance();	
	}
}
