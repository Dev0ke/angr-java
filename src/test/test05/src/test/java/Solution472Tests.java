import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class Solution472Tests {
    private final Solution472 solution472 = new Solution472();

    @Test
    public void example1() {
        String[] words = {"cat", "cats", "catsdogcats", "dog", "dogcatsdog", "hippopotamuses", "rat", "ratcatdogcat"};
        List<String> expected = Arrays.asList("catsdogcats", "dogcatsdog", "ratcatdogcat");
        List<String> actual = solution472.findAllConcatenatedWordsInADict(words);
        expected.sort(null);
        actual.sort(null);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void example2() {
        String[] words = {"cat", "dog", "catdog"};
        List<String> expected = Arrays.asList("catdog");
        List<String> actual = solution472.findAllConcatenatedWordsInADict(words);
        expected.sort(null);
        actual.sort(null);
        Assertions.assertEquals(expected, actual);
    }
}