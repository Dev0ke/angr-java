import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution26Tests {
    private final Solution26 solution26 = new Solution26();

    @Test
    public void example1() {
        int[] nums = {1, 1, 2};
        int expected = 2;
        Assertions.assertEquals(expected, solution26.removeDuplicates(nums));
    }

    @Test
    public void example2() {
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int expected = 5;
        Assertions.assertEquals(expected, solution26.removeDuplicates(nums));
    }
}
