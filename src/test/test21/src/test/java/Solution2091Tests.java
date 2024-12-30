import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2091Tests {
    private final Solution2091 solution2091 = new Solution2091();

    @Test
    public void example1() {
        int[] nums = {2, 10, 7, 5, 4, 1, 8, 6};
        int expected = 5;
        Assertions.assertEquals(expected, solution2091.minimumDeletions(nums));
    }

    @Test
    public void example2() {
        int[] nums = {0, -4, 19, 1, 8, -2, -3, 5};
        int expected = 3;
        Assertions.assertEquals(expected, solution2091.minimumDeletions(nums));
    }

    @Test
    public void example3() {
        int[] nums = {101};
        int expected = 1;
        Assertions.assertEquals(expected, solution2091.minimumDeletions(nums));
    }

    // 补充用例
    @Test
    public void example4() {
        int[] nums = {-1, -53, 93, -42, 37, 94, 97, 82, 46, 42, -99, 56, -76, -66, -67, -13, 10, 66, 85, -28};
        int expected = 11;
        Assertions.assertEquals(expected, solution2091.minimumDeletions(nums));
    }
}