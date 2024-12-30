import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3316Tests {
    private final Solution3316 solution3316 = new Solution3316();

    @Test
    public void example1() {
        String source = "abbaa";
        String pattern = "aba";
        int[] targetIndices = {0, 1, 2};
        int expected = 1;
        Assertions.assertEquals(expected, solution3316.maxRemovals(source, pattern, targetIndices));
    }

    @Test
    public void example2() {
        String source = "bcda";
        String pattern = "d";
        int[] targetIndices = {0, 3};
        int expected = 2;
        Assertions.assertEquals(expected, solution3316.maxRemovals(source, pattern, targetIndices));
    }

    @Test
    public void example3() {
        String source = "dda";
        String pattern = "dda";
        int[] targetIndices = {0, 1, 2};
        int expected = 0;
        Assertions.assertEquals(expected, solution3316.maxRemovals(source, pattern, targetIndices));
    }

    @Test
    public void example4() {
        String source = "yeyeykyded";
        String pattern = "yeyyd";
        int[] targetIndices = {0, 2, 3, 4};
        int expected = 2;
        Assertions.assertEquals(expected, solution3316.maxRemovals(source, pattern, targetIndices));
    }
}