import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2404Tests {
    private final Solution2404 solution2404 = new Solution2404();

    @Test
    public void example1() {
        int[] nums = {0, 1, 2, 2, 4, 4, 1};
        int expected = 2;
        Assertions.assertEquals(expected, solution2404.mostFrequentEven(nums));
    }

    @Test
    public void example2() {
        int[] nums = {4, 4, 4, 9, 2, 4};
        int expected = 4;
        Assertions.assertEquals(expected, solution2404.mostFrequentEven(nums));
    }

    @Test
    public void example3() {
        int[] nums = {29, 47, 21, 41, 13, 37, 25, 7};
        int expected = -1;
        Assertions.assertEquals(expected, solution2404.mostFrequentEven(nums));
    }
}
