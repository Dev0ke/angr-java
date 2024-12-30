import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class Solution2942Tests {
    private final Solution2942 solution2942 = new Solution2942();

    @Test
    public void example1() {
        String[] words = {"leet", "code"};
        char x = 'e';
        List<Integer> expected = Arrays.asList(0, 1);
        Assertions.assertEquals(expected, solution2942.findWordsContaining(words, x));
    }

    @Test
    public void example2() {
        String[] words = {"abc", "bcd", "aaaa", "cbc"};
        char x = 'a';
        List<Integer> expected = Arrays.asList(0, 2);
        Assertions.assertEquals(expected, solution2942.findWordsContaining(words, x));
    }

    @Test
    public void example3() {
        String[] words = {"abc", "bcd", "aaaa", "cbc"};
        char x = 'z';
        List<Integer> expected = Arrays.asList();
        Assertions.assertEquals(expected, solution2942.findWordsContaining(words, x));
    }
}