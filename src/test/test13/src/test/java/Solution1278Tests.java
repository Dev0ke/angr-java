import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1278Tests {
    private final Solution1278 solution1278 = new Solution1278();

    @Test
    public void example1() {
        String s = "abc";
        int k = 2;
        int expected = 1;
        Assertions.assertEquals(expected, solution1278.palindromePartition(s, k));
    }

    @Test
    public void example2() {
        String s = "aabbc";
        int k = 3;
        int expected = 0;
        Assertions.assertEquals(expected, solution1278.palindromePartition(s, k));
    }

    @Test
    public void example3() {
        String s = "leetcode";
        int k = 8;
        int expected = 0;
        Assertions.assertEquals(expected, solution1278.palindromePartition(s, k));
    }
}
