import javafx.util.Pair;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class WordContainer {
    private Set<String> container;
    private Map<String, WordUnit> word2Unit;
    private int sumCount;

    public WordContainer() {
        container = new TreeSet<>();
        word2Unit = new HashMap<>();
        sumCount = 0;
    }

    public boolean addWord(String string, int r, int c) {
        if (null == string || string.length() == 0) {
            return false;
        }
        sumCount++;
        if (word2Unit.containsKey(string)) {
            word2Unit.get(string).addCount();
            word2Unit.get(string).addPair(r, c);
            return true;
        }
        WordUnit wordUnit = new WordUnit(string);
        wordUnit.addPair(r, c);
        word2Unit.put(string, wordUnit);
        return container.add(string);
    }

    public int getDistinctCount() {
        return container.size();
    }

    public int getSumCount() {
        return sumCount;
    }

    public int getCount(String word) {
        if (!word2Unit.containsKey(word)) {
            return -1;
        }
        return word2Unit.get(word).getCount();
    }

    public Iterator<Pair<Integer, Integer>> getPairs(String word) {
        return word2Unit.get(word).getIter();
    }

    public Iterator<String> getIter() {
        return container.iterator();
    }
}
