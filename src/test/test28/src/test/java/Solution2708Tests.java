import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2708Tests {
    private final Solution2708 solution2708 = new Solution2708();

    @Test
    public void example1() {
        int[] nums = {3, -1, -5, 2, 5, -9};
        long expected = 1350;
        Assertions.assertEquals(expected, solution2708.maxStrength(nums));
        Assertions.assertEquals(expected, solution2708.maxStrength2(nums));
    }

    @Test
    public void example2() {
        int[] nums = {-4, -5, -4};
        long expected = 20;
        Assertions.assertEquals(expected, solution2708.maxStrength(nums));
        Assertions.assertEquals(expected, solution2708.maxStrength2(nums));
    }
}