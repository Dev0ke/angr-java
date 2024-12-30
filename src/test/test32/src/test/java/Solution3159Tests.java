import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3159Tests {
    private final Solution3159 solution3159 = new Solution3159();

    @Test
    public void example1() {
        int[] nums = {1, 3, 1, 7};
        int[] queries = {1, 3, 2, 4};
        int x = 1;
        int[] expected = {0, -1, 2, -1};
        Assertions.assertArrayEquals(expected, solution3159.occurrencesOfElement(nums, queries, x));
    }

    @Test
    public void example2() {
        int[] nums = {1, 2, 3};
        int[] queries = {10};
        int x = 5;
        int[] expected = {-1};
        Assertions.assertArrayEquals(expected, solution3159.occurrencesOfElement(nums, queries, x));
    }
}