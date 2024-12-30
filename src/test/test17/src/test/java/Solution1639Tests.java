import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1639Tests {
    private final Solution1639 solution1639 = new Solution1639();

    @Test
    public void example1() {
        String[] words = {"acca", "bbbb", "caca"};
        String target = "aba";
        int expected = 6;
        Assertions.assertEquals(expected, solution1639.numWays(words, target));
    }

    @Test
    public void example2() {
        String[] words = {"abba", "baab"};
        String target = "bab";
        int expected = 4;
        Assertions.assertEquals(expected, solution1639.numWays(words, target));
    }

    @Test
    public void example3() {
        String[] words = {"abcd"};
        String target = "abcd";
        int expected = 1;
        Assertions.assertEquals(expected, solution1639.numWays(words, target));
    }

    @Test
    public void example4() {
        String[] words = {"abab", "baba", "abba", "baab"};
        String target = "abba";
        int expected = 16;
        Assertions.assertEquals(expected, solution1639.numWays(words, target));
    }
}
