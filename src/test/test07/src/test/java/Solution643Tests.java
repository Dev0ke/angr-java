import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution643Tests {
    private final Solution643 solution643 = new Solution643();

    @Test
    public void example1() {
        int[] nums = {1, 12, -5, -6, 50, 3};
        int k = 4;
        double expected = 12.75;
        Assertions.assertEquals(expected, solution643.findMaxAverage(nums, k));
    }

    @Test
    public void example2() {
        int[] nums = {0, 4, 0, 3, 2};
        int k = 1;
        double expected = 4.0;
        Assertions.assertEquals(expected, solution643.findMaxAverage(nums, k));
    }
}