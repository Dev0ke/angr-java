import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution287Tests {
    private final Solution287 solution287 = new Solution287();

    @Test
    public void example1() {
        int[] nums = {1, 3, 4, 2, 2};
        int expected = 2;
        Assertions.assertEquals(expected, solution287.findDuplicate(nums));
    }

    @Test
    public void example2() {
        int[] nums = {3, 1, 3, 4, 2};
        int expected = 3;
        Assertions.assertEquals(expected, solution287.findDuplicate(nums));
    }

    @Test
    public void example3() {
        int[] nums = {1, 1};
        int expected = 1;
        Assertions.assertEquals(expected, solution287.findDuplicate(nums));
    }

    @Test
    public void example4() {
        int[] nums = {1, 1, 2};
        int expected = 1;
        Assertions.assertEquals(expected, solution287.findDuplicate(nums));
    }
}
