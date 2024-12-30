import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1898Tests {
    private final Solution1898 solution1898 = new Solution1898();

    @Test
    public void example1() {
        String s = "abcacb";
        String p = "ab";
        int[] removable = {3, 1, 0};
        int expected = 2;
        Assertions.assertEquals(expected, solution1898.maximumRemovals(s, p, removable));
    }

    @Test
    public void example2() {
        String s = "abcbddddd";
        String p = "abcd";
        int[] removable = {3, 2, 1, 4, 5, 6};
        int expected = 1;
        Assertions.assertEquals(expected, solution1898.maximumRemovals(s, p, removable));
    }

    @Test
    public void example3() {
        String s = "abcab";
        String p = "abc";
        int[] removable = {0, 1, 2, 3, 4};
        int expected = 0;
        Assertions.assertEquals(expected, solution1898.maximumRemovals(s, p, removable));
    }
}
