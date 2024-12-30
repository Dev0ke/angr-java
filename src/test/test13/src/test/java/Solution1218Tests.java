import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1218Tests {
    private final Solution1218 solution1218 = new Solution1218();

    @Test
    public void example1() {
        int[] arr = {1, 2, 3, 4};
        int difference = 1;
        int expected = 4;
        Assertions.assertEquals(expected, solution1218.longestSubsequence(arr, difference));
    }

    @Test
    public void example2() {
        int[] arr = {1, 3, 5, 7};
        int difference = 1;
        int expected = 1;
        Assertions.assertEquals(expected, solution1218.longestSubsequence(arr, difference));
    }

    @Test
    public void example3() {
        int[] arr = {1, 5, 7, 8, 5, 3, 4, 2, 1};
        int difference = -2;
        int expected = 4;
        Assertions.assertEquals(expected, solution1218.longestSubsequence(arr, difference));
    }
}
