import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class WordContainer {
    private Set<String> container;
    private Map<String, Integer> word2Count;
    private int sumCount;

    public WordContainer() {
        container = new TreeSet<>();
        word2Count = new HashMap<>();
        sumCount = 0;
    }

    public boolean addWord(String string) {
        if (null == string || string.length() == 0) {
            return false;
        }
        sumCount++;
        if (word2Count.containsKey(string)) {
            int counts = word2Count.remove(string) + 1;
            word2Count.put(string, counts);
            return true;
        }
        word2Count.put(string, 1);
        return container.add(string);
    }

    public int getDistinctCount() {
        return container.size();
    }

    public int getSumCount() {
        return sumCount;
    }

    public int getCount(String word) {
        if (!word2Count.containsKey(word)) {
            return -1;
        }
        return word2Count.get(word);
    }

    public Iterator<String> getIter() {
        return container.iterator();
    }
}
