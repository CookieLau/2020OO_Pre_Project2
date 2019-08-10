import java.util.Iterator;
import java.util.Scanner;

public class Pre_Project2 {
    final static Scanner scanner = new Scanner(System.in);
    static String word;

    public static void main(String[] args) {
        System.out.println("Welcome to OO Course, 2018OO ers");
        WordContainer container = new WordContainer();
        while ((word = getNextWord(scanner)) != null) {
            //System.out.println(word);
            container.addWord(word);
        }
        //System.out.println(container.getCount());
        Iterator<String> wordIter = container.getIter();
        while (wordIter.hasNext()) {
            System.out.println(wordIter.next());
        }
    }

    private static String getNextWord(Scanner scanner) {
        //next方法会以空格和换行符分割，符合题意
        //因为要去掉最后的,和. 所以使用 StringBuffer类记录 (String是不可变字符串，StringBuilder线程不安全)
        if (scanner.hasNext()) {
            StringBuffer nextWord = new StringBuffer(scanner.next().toLowerCase());
            int length = nextWord.length();
            int index = length - 1;
            while (nextWord.charAt(index) == ',' || nextWord.charAt(index) == '.') {
                index--;
                if (index < 0) {
                    return null;
                }
            }
            if (index + 1 < length) {
                nextWord.delete(index + 1, length);
            }
            return nextWord.toString();
        }
        return null;
    }
}
