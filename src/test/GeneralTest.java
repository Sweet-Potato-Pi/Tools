package test;

import general.Tools;

/**
 * For testing any of the tools in this project.
 */
public class GeneralTest {
    public static void main(String[] args) {
        String[] s = new String[]{"a","b","c","d","e"};
        Tools.shuffle(s);
        for (String a : s) {
            System.out.println(a);
        }
    }
    
}
