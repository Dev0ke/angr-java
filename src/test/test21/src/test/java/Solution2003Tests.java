import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2003Tests {
    private final Solution2003 solution2003 = new Solution2003();

    @Test
    public void example1() {
        int[] parents = {-1, 0, 0, 2};
        int[] nums = {1, 2, 3, 4};
        int[] expected = {5, 1, 1, 1};
        Assertions.assertArrayEquals(expected, solution2003.smallestMissingValueSubtree(parents, nums));
    }

    @Test
    public void example2() {
        int[] parents = {-1, 0, 1, 0, 3, 3};
        int[] nums = {5, 4, 6, 2, 1, 3};
        int[] expected = {7, 1, 1, 4, 2, 1};
        Assertions.assertArrayEquals(expected, solution2003.smallestMissingValueSubtree(parents, nums));
    }

    @Test
    public void example3() {
        int[] parents = {-1, 2, 3, 0, 2, 4, 1};
        int[] nums = {2, 3, 4, 5, 6, 7, 8};
        int[] expected = {1, 1, 1, 1, 1, 1, 1};
        Assertions.assertArrayEquals(expected, solution2003.smallestMissingValueSubtree(parents, nums));
    }
}
