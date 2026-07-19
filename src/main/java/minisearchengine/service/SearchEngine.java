package minisearchengine.service;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class SearchEngine {

    private HashMap<String, HashSet<String>> index;

    public SearchEngine(HashMap<String, HashSet<String>> index) {
        this.index = index;
    }

    // Single Keyword Search
    public Set<String> search(String keyword) {

        keyword = keyword.toLowerCase();

        return index.getOrDefault(keyword, new HashSet<>());

    }

    // AND Search (all keywords must be present)
    public Set<String> searchAND(String[] keywords) {

        Set<String> result = null;

        for (String keyword : keywords) {

            Set<String> files = index.getOrDefault(keyword.toLowerCase(), new HashSet<>());

            if (result == null) {
                result = new HashSet<>(files);
            } else {
                result.retainAll(files);
            }
        }

        if (result == null) {
            return new HashSet<>();
        }

        return result;
    }

    // OR Search (any keyword can be present)
    public Set<String> searchOR(String[] keywords) {

        Set<String> result = new HashSet<>();

        for (String keyword : keywords) {

            result.addAll(index.getOrDefault(keyword.toLowerCase(), new HashSet<>()));

        }

        return result;
    }
}