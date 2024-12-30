import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2953Tests {
    private final Solution2953 solution2953 = new Solution2953();

    @Test
    public void example1() {
        String word = "igigee";
        int k = 2;
        int expected = 3;
        Assertions.assertEquals(expected, solution2953.countCompleteSubstrings(word, k));
    }

    @Test
    public void example2() {
        String word = "aaabbbccc";
        int k = 3;
        int expected = 6;
        Assertions.assertEquals(expected, solution2953.countCompleteSubstrings(word, k));
    }
}