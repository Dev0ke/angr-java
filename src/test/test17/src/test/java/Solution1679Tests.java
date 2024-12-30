import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1679Tests {
    private final Solution1679 solution1679 = new Solution1679();

    @Test
    public void example1() {
        int[] nums = {1, 2, 3, 4};
        int k = 5;
        int expected = 2;
        Assertions.assertEquals(expected, solution1679.maxOperations(nums, k));
    }

    @Test
    public void example2() {
        int[] nums = {3, 1, 3, 4, 3};
        int k = 6;
        int expected = 1;
        Assertions.assertEquals(expected, solution1679.maxOperations(nums, k));
    }
}