import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution996Tests {
    private final Solution996 solution996 = new Solution996();

    @Test
    public void example1() {
        int[] nums = {1, 17, 8};
        int expected = 2;
        Assertions.assertEquals(expected, solution996.numSquarefulPerms(nums));
    }

    @Test
    public void example2() {
        int[] nums = {2, 2, 2};
        int expected = 1;
        Assertions.assertEquals(expected, solution996.numSquarefulPerms(nums));
    }
}