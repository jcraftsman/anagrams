import org.junit.Before;
import org.junit.Test;

import java.util.Collection;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

public class DictionaryTest {

    private Dictionary dictionary;

    @Before
    public void setUp() throws Exception {
        Collection<String> words = asList(
                "argent", "gerant", "grenat", "garent", "aimer", "maire",
                "marie", "ramie", "ragent", "Tanger", "gréant", "régnât", "ganter");
        dictionary = new Dictionary(words);
    }

    @Test
    public void anagrams_should_be_empty_when_given_word_is_unknown() {
        //Given
        String givenWord = "marion";

        // When
        Collection<String> anagrams = dictionary.anagrams(givenWord);

        // Then
        assertThat(anagrams).isEmpty();
    }

    @Test
    public void anagrams_should_contain_the_given_word_when_it_is_known() {
        // Given
        String givenWord = "grenat";
        // When
        Collection<String> anagrams = dictionary.anagrams(givenWord);
        // Then
        assertThat(anagrams).contains(givenWord);
    }

    @Test
    public void anagrams_should_contains_all_word_anagrams() {
        // Given
        String givenWord = "aimer";
        // When
        Collection<String> anagrams = dictionary.anagrams(givenWord);
        // Then
        assertThat(anagrams).containsExactly("aimer", "maire", "marie", "ramie");
    }
}