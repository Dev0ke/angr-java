import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Solution2273Tests {
    private final Solution2273 solution2273 = new Solution2273();

    @Test
    public void example1() {
        String[] words = {"abba", "baba", "bbaa", "cd", "cd"};
        List<String> expected = List.of("abba", "cd");
        Assertions.assertEquals(expected, solution2273.removeAnagrams(words));
    }

    @Test
    public void example2() {
        String[] words = {"a", "b", "c", "d", "e"};
        List<String> expected = List.of("a", "b", "c", "d", "e");
        Assertions.assertEquals(expected, solution2273.removeAnagrams(words));
    }
}
