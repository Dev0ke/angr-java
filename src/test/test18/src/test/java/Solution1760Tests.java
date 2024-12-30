import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1760Tests {
    private final Solution1760 solution1760 = new Solution1760();

    @Test
    public void example1() {
        int[] nums = {9};
        int maxOperations = 2;
        int expected = 3;
        Assertions.assertEquals(expected, solution1760.minimumSize(nums, maxOperations));
    }

    @Test
    public void example2() {
        int[] nums = {2, 4, 8, 2};
        int maxOperations = 4;
        int expected = 2;
        Assertions.assertEquals(expected, solution1760.minimumSize(nums, maxOperations));
    }

    @Test
    public void example3() {
        int[] nums = {7, 17};
        int maxOperations = 2;
        int expected = 7;
        Assertions.assertEquals(expected, solution1760.minimumSize(nums, maxOperations));
    }
}
