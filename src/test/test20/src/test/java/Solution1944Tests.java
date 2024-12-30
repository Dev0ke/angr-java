import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1944Tests {
    private final Solution1944 solution1944 = new Solution1944();

    @Test
    public void example1() {
        int[] heights = {10, 6, 8, 5, 11, 9};
        int[] expected = {3, 1, 2, 1, 1, 0};
        Assertions.assertArrayEquals(expected, solution1944.canSeePersonsCount(heights));
    }

    @Test
    public void example2() {
        int[] heights = {5, 1, 2, 3, 10};
        int[] expected = {4, 1, 1, 1, 0};
        Assertions.assertArrayEquals(expected, solution1944.canSeePersonsCount(heights));
    }
}
