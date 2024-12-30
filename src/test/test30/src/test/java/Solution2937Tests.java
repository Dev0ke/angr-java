import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2937Tests {
    private final Solution2937 solution2937 = new Solution2937();

    @Test
    public void example1() {
        String s1 = "abc";
        String s2 = "abb";
        String s3 = "ab";
        int expected = 2;
        Assertions.assertEquals(expected, solution2937.findMinimumOperations(s1, s2, s3));
    }

    @Test
    public void example2() {
        String s1 = "dac";
        String s2 = "bac";
        String s3 = "cac";
        int expected = -1;
        Assertions.assertEquals(expected, solution2937.findMinimumOperations(s1, s2, s3));
    }
}