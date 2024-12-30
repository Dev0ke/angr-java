import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution525Tests {
    private final Solution525 solution525 = new Solution525();

    @Test
    public void example1() {
        int[] nums = {0, 1};
        int expected = 2;
        Assertions.assertEquals(expected, solution525.findMaxLength(nums));
    }

    @Test
    public void example2() {
        int[] nums = {0, 1, 0};
        int expected = 2;
        Assertions.assertEquals(expected, solution525.findMaxLength(nums));
    }
}
