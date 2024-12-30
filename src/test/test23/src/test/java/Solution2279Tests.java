import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2279Tests {
    private final Solution2279 solution2279 = new Solution2279();

    @Test
    public void example1() {
        int[] capacity = {2, 3, 4, 5};
        int[] rocks = {1, 2, 4, 4};
        int additionalRocks = 2;
        int expected = 3;
        Assertions.assertEquals(expected, solution2279.maximumBags(capacity, rocks, additionalRocks));
    }

    @Test
    public void example2() {
        int[] capacity = {10, 2, 2};
        int[] rocks = {2, 2, 0};
        int additionalRocks = 100;
        int expected = 3;
        Assertions.assertEquals(expected, solution2279.maximumBags(capacity, rocks, additionalRocks));
    }
}
