import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1027Tests {
    private final Solution1027 solution1027 = new Solution1027();

    @Test
    public void example1() {
        int[] nums = {3, 6, 9, 12};
        int expected = 4;
        Assertions.assertEquals(expected, solution1027.longestArithSeqLength(nums));
    }

    @Test
    public void example2() {
        int[] nums = {9, 4, 7, 2, 10};
        int expected = 3;
        Assertions.assertEquals(expected, solution1027.longestArithSeqLength(nums));
    }

    @Test
    public void example3() {
        int[] nums = {20, 1, 15, 3, 10, 5, 8};
        int expected = 4;
        Assertions.assertEquals(expected, solution1027.longestArithSeqLength(nums));
    }
}
