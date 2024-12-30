import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1331Tests {
    private final Solution1331 solution1331 = new Solution1331();

    @Test
    public void example1() {
        int[] arr = {40, 10, 20, 30};
        int[] expected = {4, 1, 2, 3};
        Assertions.assertArrayEquals(expected, solution1331.arrayRankTransform(arr));
    }

    @Test
    public void example2() {
        int[] arr = {100, 100, 100};
        int[] expected = {1, 1, 1};
        Assertions.assertArrayEquals(expected, solution1331.arrayRankTransform(arr));
    }

    @Test
    public void example3() {
        int[] arr = {37, 12, 28, 9, 100, 56, 80, 5, 12};
        int[] expected = {5, 3, 4, 2, 8, 6, 7, 1, 3};
        Assertions.assertArrayEquals(expected, solution1331.arrayRankTransform(arr));
    }
}
