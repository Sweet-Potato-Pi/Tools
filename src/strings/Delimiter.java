package strings;

/**
 * A basic delimiter class with all the convenient tools related to String delimiting.
 *
 * @author Andrej Coleman
 * @since March 29, 2023
 */
public class Delimiter extends SpecialDelimiter{
    /**
     * Creates a new Delimiter object.
     * @param delim the delimiting String
     */
    public Delimiter(String delim) {
        super(delim);
    }

    public Delimiter(char delim) {
        super(delim);
    }

    /**
     * Returns the length of the delimiter
     * @return length
     */
    public int length() {
        return super.openLength();
    }

    @Override
    public int tokenAmount(String s) {
        int count = 0;
        String current = s.substring(0,length());
        if (!current.equals(open())) {
            count++;
        }
        for (int i = 0; i < s.length() - (length() - 1); i++) {
            current = s.substring(i, i + length());

            if (current.equals(open()) && (i < length() || !s.substring(i - length(), i).equals(open()))) {
                count++;
            }
        }
        if (current.equals(open())) {
            count--;
        }
        return count;
    }

    /**
     * Returns the tokens in a String as an array of Strings
     * @param s the String you want to extract tokens from.
     * @return an array of tokens
     */
    public String[] getTokens(String s) {
        String[] out = new String[tokenAmount(s)];

        int outIndex = 0;
        out[0] = "";
        String current;
        int i = 0;

        for (i = 0; i < s.length() - (length() - 1); i++) {
            //System.out.println(i + ":: Started loop");
            //System.out.println("outIndex = " + outIndex);
            current = s.substring(i, i + 1);
            if (s.substring(i, i + length()).equals(open())) {


                //Checks: (it isn't at the start && it isn't right after a delimiter && it isn't at the end)
                if (i != 0 && !s.substring(i - length(), i).equals(open())) {
                    if (i >= s.length() - length()) {
                        return out;
                    }
                    outIndex++;

                    out[outIndex] = "";
                }
                i += length() - 1; // - 1 because the i++ in the for statement takes care of the extra

            } else {
                //System.out.println(current);
                out[outIndex] += current;
            }


        }
        //getting the rest of s
        //System.out.println(s.substring(i-2));
        out[outIndex] += s.substring(i);
        return out;
    }

    /**
     * Returns the amount of delimiters found in a String
     * @param s
     * @return
     */
    public int delimAmount(String s) {
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.substring(i, i + length()).equals(open())) {
                count++;
            }
        }

        return count;
    }
}
