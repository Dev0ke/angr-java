import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution724Tests {
    private final Solution724 solution724 = new Solution724();

    @Test
    public void example1() {
        int[] nums = {1, 7, 3, 6, 5, 6};
        int expected = 3;
        Assertions.assertEquals(expected, solution724.pivotIndex(nums));
    }

    @Test
    public void example2() {
        int[] nums = {1, 2, 3};
        int expected = -1;
        Assertions.assertEquals(expected, solution724.pivotIndex(nums));
    }

    @Test
    public void example3() {
        int[] nums = {2, 1, -1};
        int expected = 0;
        Assertions.assertEquals(expected, solution724.pivotIndex(nums));
    }
}
