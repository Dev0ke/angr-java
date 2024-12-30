import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1734Tests {
    private final Solution1734 solution1734 = new Solution1734();

    @Test
    public void example1() {
        int[] encoded = {3, 1};
        int[] expected = {1, 2, 3};
        Assertions.assertArrayEquals(expected, solution1734.decode(encoded));
    }

    @Test
    public void example2() {
        int[] encoded = {6, 5, 4, 6};
        int[] expected = {2, 4, 1, 5, 3};
        Assertions.assertArrayEquals(expected, solution1734.decode(encoded));
    }
}