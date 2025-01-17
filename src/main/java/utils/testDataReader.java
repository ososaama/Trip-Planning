package utils;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class testDataReader {
	private static Properties properties;
	
	static {
		properties = new Properties();
		try {
			FileInputStream file = new FileInputStream("src/test/resources/testdata.properties");
			properties.load(file);
		}
		catch(IOException e)
		{
			e.printStackTrace();
			}
	}
	
	public static String getProperty(String Key)
	{
		return properties.getProperty(Key);
	}

}
