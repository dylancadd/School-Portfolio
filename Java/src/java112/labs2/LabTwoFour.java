package java112.labs2;

import java.util.*;
import java.io.*;

public class LabTwoFour {

    public static void main(String[] args) {
        LabTwoFour lab = new LabTwoFour();
        lab.run();
    }

    public void run() {
        Map<Integer, String> map = new HashMap<Integer, String>();

        map.put(1, "One");
        map.put(2, "Two");
        map.put(3, "Three");
        map.put(4, "Four");
        map.put(5, "Five");

        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            System.out.println("Key: " + entry.getKey() + " Value: " + entry.getValue());
        }

        System.out.println(map);


        if (map.containsKey(3)) {
            Object value = map.get(3);
            System.out.println("Key: " + 3 + " Value: " + value);
        } else {
            System.out.println("Does not contain key of 'Three'.");
        }

        Map newMap = new TreeMap(map);

        System.out.println(newMap);


    }

}
