package chapter15;

import java.io.FileReader;
import java.util.Properties;

public class PropertiesEx {
    public static void main(String[] args) throws Exception{
        Properties properties = new Properties();
        String path = PropertiesEx.class.getResource("database.properties").getPath();
        properties.load(new FileReader(path));

        String driver = properties.getProperty("driver");
        String url = properties.getProperty("url");
        String username = properties.getProperty("username");
        String password = properties.getProperty("password");

        System.out.println("driver: "+driver);
        System.out.println("url: "+url);
        System.out.println("username: "+username);
        System.out.println("password: "+password);
    }
}
