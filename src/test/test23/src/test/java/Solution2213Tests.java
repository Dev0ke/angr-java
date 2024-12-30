import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2213Tests {
    private final Solution2213 solution2213 = new Solution2213();

    @Test
    public void example1() {
        String s = "babacc";
        String queryCharacters = "bcb";
        int[] queryIndices = {1, 3, 3};
        int[] expected = {3, 3, 4};
        Assertions.assertArrayEquals(expected, solution2213.longestRepeating(s, queryCharacters, queryIndices));
    }

    @Test
    public void example2() {
        String s = "abyzz";
        String queryCharacters = "aa";
        int[] queryIndices = {2, 1};
        int[] expected = {2, 3};
        Assertions.assertArrayEquals(expected, solution2213.longestRepeating(s, queryCharacters, queryIndices));
    }
}
