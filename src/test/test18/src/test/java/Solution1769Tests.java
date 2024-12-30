import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1769Tests {
    private final Solution1769 solution1769 = new Solution1769();

    @Test
    public void example1() {
        String boxes = "110";
        int[] expected = {1, 1, 3};
        Assertions.assertArrayEquals(expected, solution1769.minOperations(boxes));
    }

    @Test
    public void example2() {
        String boxes = "001011";
        int[] expected = {11, 8, 5, 4, 3, 4};
        Assertions.assertArrayEquals(expected, solution1769.minOperations(boxes));
    }
}