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
}
