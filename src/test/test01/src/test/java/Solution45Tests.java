import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution45Tests {
    private final Solution45 solution45 = new Solution45();

    @Test
    public void example1() {
        int[] nums = {2, 3, 1, 1, 4};
        int expected = 2;
        Assertions.assertEquals(expected, solution45.jump(nums));
    }

    @Test
    public void example2() {
        int[] nums = {2, 3, 0, 1, 4};
        int expected = 2;
        Assertions.assertEquals(expected, solution45.jump(nums));
    }
}
