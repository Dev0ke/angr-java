import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1170Tests {
    private final Solution1170 solution1170 = new Solution1170();

    @Test
    public void example1() {
        String[] queries = {"cbd"};
        String[] words = {"zaaaz"};
        int[] expected = {1};
        Assertions.assertArrayEquals(expected, solution1170.numSmallerByFrequency(queries, words));
    }

    @Test
    public void example2() {
        String[] queries = {"bbb", "cc"};
        String[] words = {"a", "aa", "aaa", "aaaa"};
        int[] expected = {1, 2};
        Assertions.assertArrayEquals(expected, solution1170.numSmallerByFrequency(queries, words));
    }
}