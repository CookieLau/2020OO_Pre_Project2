import java.util.ArrayList;
import java.util.List;

public class WordContainer {
    private List<String> container;

    public WordContainer() {
        container = new ArrayList<>();
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
}
