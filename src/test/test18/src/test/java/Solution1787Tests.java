import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1787Tests {
    private final Solution1787 solution1787 = new Solution1787();

    @Test
    public void example1() {
        int[] nums = {1, 2, 0, 3, 0};
        int k = 1;
        int expected = 3;
        Assertions.assertEquals(expected, solution1787.minChanges(nums, k));
    }

    @Test
    public void example2() {
        int[] nums = {3, 4, 5, 2, 1, 7, 3, 4, 7};
        int k = 3;
        int expected = 3;
        Assertions.assertEquals(expected, solution1787.minChanges(nums, k));
    }

    @Test
    public void example3() {
        int[] nums = {1, 2, 4, 1, 2, 5, 1, 2, 6};
        int k = 3;
        int expected = 3;
        Assertions.assertEquals(expected, solution1787.minChanges(nums, k));
    }
}