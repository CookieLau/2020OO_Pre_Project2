import javafx.util.Pair;

import java.text.DecimalFormat;
import java.util.Iterator;
import java.util.Scanner;

public class Pre_Project2 {
    final static Scanner scanner = new Scanner(System.in);
    static String word;
    static String line;
    static int r,c,nextC,lastC;

    public static void main(String[] args) {
        System.out.println("Welcome to OO Course, 2020OO ers");
        WordContainer container = new WordContainer();
        Scanner lineScanner;
        r = c = nextC = 0;
        while (scanner.hasNextLine()) {
            line = scanner.nextLine();
            r++;
            //System.out.println("Line: " + r + line);
            lineScanner = new Scanner(line);
            c = 0;
            lastC = nextC;
            while ((word = getNextWord(lineScanner)) != null) {
                //System.out.println(word);
                container.addWord(word, r, c + 1 + lastC);
                c += word.length();
            }
        }
        //System.out.println(container.getCount());
        Iterator<String> wordIter = container.getIter();
        int sumCount = container.getSumCount();
        DecimalFormat df = new DecimalFormat("#.00%");
        while (wordIter.hasNext()) {
            word = wordIter.next();
            String rate = df.format((float)container.getCount(word)/sumCount);
            System.out.println(String.format("%s %d %s", word, container.getCount(word), rate));
            Iterator<Pair<Integer, Integer>> pairIterator = container.getPairs(word);
            while (pairIterator.hasNext()) {
                Pair<Integer, Integer> pair = pairIterator.next();
                System.out.println(String.format("\t(%d %d)", pair.getKey(), pair.getValue()));
            }
        }
    }

    private static String getNextWord(Scanner sc) {
        //next方法会以空格和换行符分割，符合题意
        //因为要去掉最后的,和. 所以使用 StringBuffer类记录 (String是不可变字符串，StringBuilder线程不安全)
        if (sc.hasNext()) {
            while (!utils.isAlpha(line.charAt(c))) {
                c++;
            }
            StringBuffer nextWord = new StringBuffer(sc.next().toLowerCase());
            //Task3: '-'
            if (nextWord.charAt(nextWord.length() - 1) != '-') {
                nextC = 0;
            }
            while (nextWord.charAt(nextWord.length() - 1) == '-') {
                nextWord.deleteCharAt(nextWord.length() - 1);
                if (!scanner.hasNext()) {
                    System.err.println("- is at an end, which is an invalid case!");
                    System.exit(0);
                } else { //connect another word in the next line
                    String postString = scanner.next();
                    nextC = postString.length();
                    nextWord.append(postString);
                }
            }
            int length = nextWord.length();
            int index = length - 1;
            while (utils.isPunctuation(nextWord.charAt(index))) {
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
