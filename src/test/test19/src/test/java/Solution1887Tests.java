import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1887Tests {
    private final Solution1887 solution1887 = new Solution1887();

    @Test
    public void example1() {
        int[] nums = {5, 1, 3};
        int expected = 3;
        Assertions.assertEquals(expected, solution1887.reductionOperations(nums));
    }

    @Test
    public void example2() {
        int[] nums = {1, 1, 1};
        int expected = 0;
        Assertions.assertEquals(expected, solution1887.reductionOperations(nums));
    }

    @Test
    public void example3() {
        int[] nums = {1, 1, 2, 2, 3};
        int expected = 4;
        Assertions.assertEquals(expected, solution1887.reductionOperations(nums));
    }
}