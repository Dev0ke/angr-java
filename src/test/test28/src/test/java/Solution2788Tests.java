import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Solution2788Tests {
    private final Solution2788 solution2788 = new Solution2788();

    @Test
    public void example1() {
        List<String> words = List.of("one.two.three", "four.five", "six");
        char separator = '.';
        List<String> expected = List.of("one", "two", "three", "four", "five", "six");
        Assertions.assertEquals(expected, solution2788.splitWordsBySeparator(words, separator));
    }

    @Test
    public void example2() {
        List<String> words = List.of("$easy$", "$problem$");
        char separator = '$';
        List<String> expected = List.of("easy", "problem");
        Assertions.assertEquals(expected, solution2788.splitWordsBySeparator(words, separator));
    }

    @Test
    public void example3() {
        List<String> words = List.of("|||");
        char separator = '|';
        List<String> expected = List.of();
        Assertions.assertEquals(expected, solution2788.splitWordsBySeparator(words, separator));
    }
}