//package autoamtionframework.webdriver;
//
//import java.io.IOException;
//import java.util.Properties;
//
//public class PropertyReader {
//	public static String getProperties(String name) {
//		Properties properties = new Properties();
//		try {
//			properties.load(PropertyReader.class.getResourceAsStream("application.properties"));//___________какой файл?
//			String property = properties.getProperty(name);
//			if (property == null) {
//				throw new IllegalArgumentException("Could not read property with key: " + name);
//			}
//			return property;
//		} catch (IOException e) {
//			throw new IllegalStateException(e);
//		}
//	}
//}
