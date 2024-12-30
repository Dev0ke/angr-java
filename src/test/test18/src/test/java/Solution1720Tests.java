import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1720Tests {
    private final Solution1720 solution1720 = new Solution1720();

    @Test
    public void example1() {
        int[] encoded = {1, 2, 3};
        int first = 1;
        int[] expected = {1, 0, 2, 1};
        Assertions.assertArrayEquals(expected, solution1720.decode(encoded, first));
    }

    @Test
    public void example2() {
        int[] encoded = {6, 2, 7, 3};
        int first = 4;
        int[] expected = {4, 2, 0, 7, 4};
        Assertions.assertArrayEquals(expected, solution1720.decode(encoded, first));
    }
}