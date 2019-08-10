public class utils {
    public static boolean isAlpha(char c) {
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z');
    }

    public static boolean isEnd(char c) {
        return (c == '\n');
    }

    public static boolean isPunctuation(char c) {
        return (c == '!') || (c == '?') || (c == ',') || (c == '.');
    }

    public static String postRev(String s) {
        String revs = new StringBuffer(s).reverse().toString();
        if (revs.compareTo(s) > 0) {
            return s;
        }
        return revs;
    }
}
