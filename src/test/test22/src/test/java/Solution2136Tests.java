import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2136Tests {
    private final Solution2136 solution2136 = new Solution2136();

    @Test
    public void example1() {
        int[] plantTime = {1, 4, 3};
        int[] growTime = {2, 3, 1};
        int expected = 9;
        Assertions.assertEquals(expected, solution2136.earliestFullBloom(plantTime, growTime));
    }

    @Test
    public void example2() {
        int[] plantTime = {1, 2, 3, 2};
        int[] growTime = {2, 1, 2, 1};
        int expected = 9;
        Assertions.assertEquals(expected, solution2136.earliestFullBloom(plantTime, growTime));
    }

    @Test
    public void example3() {
        int[] plantTime = {1};
        int[] growTime = {1};
        int expected = 2;
        Assertions.assertEquals(expected, solution2136.earliestFullBloom(plantTime, growTime));
    }
}
