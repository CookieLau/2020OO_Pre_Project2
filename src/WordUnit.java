import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class WordUnit {
    private final String word;
    private int count;
    private List<Pair<Integer, Integer>> rc;

    private WordUnit() {
        word = null;
        System.err.println("Misuse the formation of WordUnit!");
    }

    public WordUnit(String string) {
        word = string;
        count = 1;
        rc = new ArrayList<>();
    }

    public int getCount() {
        return count;
    }

    public void addPair(Pair<Integer, Integer> pair) {
        rc.add(pair);
    }

    public Iterator<Pair<Integer, Integer>> getIter() {
        return rc.iterator();
    }

    public void addCount() {
        count++;
    }

    public void addPair(int r, int c) {
        rc.add(new Pair<>(r,c));
    }
}
