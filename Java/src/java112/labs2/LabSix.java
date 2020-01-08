package java112.labs2;

import java.util.*;
import java.io.*;
import java112.utilities.*;

public class LabSix implements PropertiesLoader {

    Properties properties;

    public static void main(String[] args) {
        LabSix lab = new LabSix();
        lab.run(args[0]);
    }

    public void run(String input) {
        loadProperties(input);
    }
}
