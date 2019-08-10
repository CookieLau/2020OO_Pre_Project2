import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class WordContainer {
    private Set<String> container;

    public WordContainer() {
        container = new TreeSet<>();
    }

    public boolean addWord(String string) {
        if (null == string || string.length() == 0) {
            return false;
        }
        return container.add(string);
    }

    public int getCount() {
        return container.size();
    }

    public Iterator<String> getIter() {
        return container.iterator();
    }
}
