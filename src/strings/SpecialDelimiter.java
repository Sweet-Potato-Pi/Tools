package strings;

/*
 * @todo
 * Implement tokenAmount()
 *
 */

/**
 * A class for more advanced delimiter use and creation. Special Delimiters encapsulate certain sections of a String
 * within the opening and closing delimiters. This can be used when you want only certain tokens in a String to be
 * extracted.
 *
 * @author Andrej Coleman
 * @since March 29, 2023
 */
public class SpecialDelimiter {
    private String openDelim;
    private String closeDelim;

    /**
     * No argument constructor for the SpecialDelimiter class.
     */
    public SpecialDelimiter() {
        openDelim = "";
        closeDelim = "";
    }

    /**
     * Creates a new Special Delimiter object. Special Delimiters encapsulate certain sections of a String within the
     * opening and closing delimiters.
     *
     * @param open  the opening delimiter String
     * @param close the closing delimiter String
     */
    public SpecialDelimiter(String open, String close) {
        openDelim = open;
        closeDelim = close;
    }

    /**
     * Creates a new Special Delimiter object based on a single String parameter that becomes both the opening and
     * closing delimiter.
     *
     * @param delimiter the delimiting String
     */
    public SpecialDelimiter(String delimiter) {
        openDelim = delimiter;
        closeDelim = delimiter;
    }

    /**
     * Creates a new Special Delimiter object based on a single char parameter that becomes both the opening and
     * closing delimiter.
     *
     * @param delimiter the delimiting character
     */
    public SpecialDelimiter(char delimiter) {
        openDelim = Character.toString(delimiter);
        closeDelim = Character.toString(delimiter);
    }

    public int openLength() {
        return open().length();
    }

    public int closeLength() {
        return close().length();
    }

    public String open() {
        return openDelim;
    }

    public int tokenAmount(String s) {
        //To be implemented
        return 0;
    }

    public String close() {
        return closeDelim;
    }

    public String toString() {
        return "{ " + openDelim + ", " + closeDelim + " }";
    }

}
