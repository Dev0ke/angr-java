import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution915Tests {
    private final Solution915 solution915 = new Solution915();

    @Test
    public void example1() {
        int[] nums = {5, 0, 3, 8, 6};
        int expected = 3;
        Assertions.assertEquals(expected, solution915.partitionDisjoint(nums));
    }

    @Test
    public void example2() {
        int[] nums = {1, 1, 1, 0, 6, 12};
        int expected = 4;
        Assertions.assertEquals(expected, solution915.partitionDisjoint(nums));
    }
}
