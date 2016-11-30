import java.util.Collection;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class Dictionary {

    private Collection<String> words;

    public Dictionary(Collection<String> words) {
        this.words = words;
    }

    public Collection<String> anagrams(String givenWord) {
        return words.stream()
                .filter(aWord -> isAnagram(aWord, givenWord))
                .collect(toList());
    }

    private boolean isAnagram(String knownWord, String givenWord) {
        List<Character> givenWordChars = toSortedListOfCharcters(givenWord);
        List<Character> knownWordChars = toSortedListOfCharcters(knownWord);
        return givenWordChars.equals(knownWordChars);
    }

    private List<Character> toSortedListOfCharcters(String word) {
        return word.chars()
                .mapToObj(i -> (char) i)
                .sorted().collect(toList());
    }
}
