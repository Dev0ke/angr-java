import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2233Tests {
    private final Solution2233 solution2233 = new Solution2233();

    @Test
    public void example1() {
        int[] nums = {0, 4};
        int k = 5;
        int expected = 20;
        Assertions.assertEquals(expected, solution2233.maximumProduct(nums, k));
    }

    @Test
    public void example2() {
        int[] nums = {6, 3, 3, 2};
        int k = 2;
        int expected = 216;
        Assertions.assertEquals(expected, solution2233.maximumProduct(nums, k));
    }
}
