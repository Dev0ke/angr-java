import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution740Tests {
    private final Solution740 solution740 = new Solution740();

    @Test
    public void example1() {
        int[] nums = {3, 4, 2};
        int expected = 6;
        Assertions.assertEquals(expected, solution740.deleteAndEarn(nums));
        Assertions.assertEquals(expected, solution740.deleteAndEarn2(nums));
    }

    @Test
    public void example2() {
        int[] nums = {2, 2, 3, 3, 3, 4};
        int expected = 9;
        Assertions.assertEquals(expected, solution740.deleteAndEarn(nums));
        Assertions.assertEquals(expected, solution740.deleteAndEarn2(nums));
    }
}
