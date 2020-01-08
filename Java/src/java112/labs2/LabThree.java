package java112.labs2;

import java.util.*;
import java.io.*;

public class LabThree {

    Properties properties;

    public static void main(String[] args) {
        LabThree lab = new LabThree();
        lab.run(args[0]);
    }

    public void run(String input) {

        loadProperties(input);

    }

    public void loadProperties(String propertiesFilePath)  {
        properties = new Properties();
        try {
            properties.load(this.getClass().getResourceAsStream(propertiesFilePath));
            //System.out.println(properties.getProperty("enable.sessions"));

            Set<String> propertyNames = properties.stringPropertyNames();

            for (String key : propertyNames) {
                System.out.println("The key is: " + key + " the value is " + properties.getProperty(key));
            }
            //System.out.println("The set of property names: " + propertyNames);

        }
        catch(IOException ioe) {
            System.out.println("Can't load the properties file");
            ioe.printStackTrace();
        }
        catch(Exception e) {
            System.out.println("Problem: " + e);
            e.printStackTrace();
        }


    }
}
