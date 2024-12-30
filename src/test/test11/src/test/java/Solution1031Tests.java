import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1031Tests {
    private final Solution1031 solution1031 = new Solution1031();

    @Test
    public void example1() {
        int[] nums = {0, 6, 5, 2, 2, 5, 1, 9, 4};
        int firstLen = 1;
        int secondLen = 2;
        int expected = 20;
        Assertions.assertEquals(expected, solution1031.maxSumTwoNoOverlap(nums, firstLen, secondLen));
    }

    @Test
    public void example2() {
        int[] nums = {3, 8, 1, 3, 2, 1, 8, 9, 0};
        int firstLen = 3;
        int secondLen = 2;
        int expected = 29;
        Assertions.assertEquals(expected, solution1031.maxSumTwoNoOverlap(nums, firstLen, secondLen));
    }

    @Test
    public void example3() {
        int[] nums = {2, 1, 5, 6, 0, 9, 5, 0, 3, 8};
        int firstLen = 4;
        int secondLen = 3;
        int expected = 31;
        Assertions.assertEquals(expected, solution1031.maxSumTwoNoOverlap(nums, firstLen, secondLen));
    }
}