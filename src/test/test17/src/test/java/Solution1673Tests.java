import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1673Tests {
    private final Solution1673 solution1673 = new Solution1673();

    @Test
    public void example1() {
        int[] nums = {3, 5, 2, 6};
        int k = 2;
        int[] expected = {2, 6};
        Assertions.assertArrayEquals(expected, solution1673.mostCompetitive(nums, k));
    }

    @Test
    public void example2() {
        int[] nums = {2, 4, 3, 3, 5, 4, 9, 6};
        int k = 4;
        int[] expected = {2, 3, 3, 4};
        Assertions.assertArrayEquals(expected, solution1673.mostCompetitive(nums, k));
    }
}
