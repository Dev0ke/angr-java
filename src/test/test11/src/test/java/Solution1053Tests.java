import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1053Tests {
    private final Solution1053 solution1053 = new Solution1053();

    @Test
    public void example1() {
        int[] arr = {3, 2, 1};
        int[] expected = {3, 1, 2};
        Assertions.assertArrayEquals(expected, solution1053.prevPermOpt1(arr));
    }

    @Test
    public void example2() {
        int[] arr = {1, 1, 5};
        int[] expected = {1, 1, 5};
        Assertions.assertArrayEquals(expected, solution1053.prevPermOpt1(arr));
    }

    @Test
    public void example3() {
        int[] arr = {1, 9, 4, 6, 7};
        int[] expected = {1, 7, 4, 6, 9};
        Assertions.assertArrayEquals(expected, solution1053.prevPermOpt1(arr));
    }
}