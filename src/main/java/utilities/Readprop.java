package utilities;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Readprop {

	String value;
	InputStream inputStream;

	public String getPropValues(String PropertyKeyName, String propertyFileName) throws IOException {

		try {
			Properties prop = new Properties();
			String propFileName = propertyFileName;

			inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);

			if (inputStream != null) {
				prop.load(inputStream);
			} else {
				throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
			}

			value = prop.getProperty(PropertyKeyName);

		} catch (Exception e) {
			System.out.println("Exception: " + e);
		} finally {
			inputStream.close();
		}
		return value;
	}
}
