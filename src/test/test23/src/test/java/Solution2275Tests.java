import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2275Tests {
    private final Solution2275 solution2275 = new Solution2275();

    @Test
    public void example1() {
        int[] candidates = {16, 17, 71, 62, 12, 24, 14};
        int expected = 4;
        Assertions.assertEquals(expected, solution2275.largestCombination(candidates));
    }

    @Test
    public void example2() {
        int[] candidates = {8, 8};
        int expected = 2;
        Assertions.assertEquals(expected, solution2275.largestCombination(candidates));
    }
}
