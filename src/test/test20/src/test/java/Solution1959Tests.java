import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1959Tests {
    private final Solution1959 solution1959 = new Solution1959();

    @Test
    public void example1() {
        int[] nums = {10, 20};
        int k = 0;
        int expected = 10;
        Assertions.assertEquals(expected, solution1959.minSpaceWastedKResizing(nums, k));
    }

    @Test
    public void example2() {
        int[] nums = {10, 20, 30};
        int k = 1;
        int expected = 10;
        Assertions.assertEquals(expected, solution1959.minSpaceWastedKResizing(nums, k));
    }

    @Test
    public void example3() {
        int[] nums = {10, 20, 15, 30, 20};
        int k = 2;
        int expected = 15;
        Assertions.assertEquals(expected, solution1959.minSpaceWastedKResizing(nums, k));
    }
}
