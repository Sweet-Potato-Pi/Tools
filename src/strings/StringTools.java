package strings;

public class StringTools {
    public static String getChar(String s, int index) {
        return s.substring(index, index + 1);
    }

    public static String reverse(String s) {
        String out = "";

        for (int i = s.length() - 1; i >= 0; i--) {
            out += getChar(s, i);
        }
        return out;
    }

    public static int countChars(String s, String character) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (getChar(s, i).equals(character)) {
                count++;
            }
        }
        return count;
    }
    /*
    --NON-WORKING--

    public static String setChar(String s, int index, String c) {
        String temp = "";
        if (index > 0) {
            temp += s.substring(0, index);
        }
        temp += c;
        if (index < s.length() - 1) {
            temp += s.substring(index + 1);
        }
        s = temp;
        return temp;
    }

    public static String swapChars(String s, int index, int target) {
        String t = getChar(s, target);
        setChar(s, target, getChar(s, index));
        setChar(s, index, t);
        return s;
    }
     */

    /**
     * !CURRENTLY NON-FUNCTIONAL!
     * @param s
     * @return
     */
    public static String anagramize(String s) {
        return "";
    }
}
