import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution154Tests {
    private final Solution154 solution154 = new Solution154();

    @Test
    public void example1() {
        int[] nums = {1, 3, 5};
        int expected = 1;
        Assertions.assertEquals(expected, solution154.findMin(nums));
    }

    @Test
    public void example2() {
        int[] nums = {2, 2, 2, 0, 1};
        int expected = 0;
        Assertions.assertEquals(expected, solution154.findMin(nums));
    }
}
