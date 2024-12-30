import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1299Tests {
    private final Solution1299 solution1299 = new Solution1299();

    @Test
    public void example1() {
        int[] arr = {17, 18, 5, 4, 6, 1};
        int[] expected = {18, 6, 6, 6, 1, -1};
        Assertions.assertArrayEquals(expected, solution1299.replaceElements(arr));
    }

    @Test
    public void example2() {
        int[] arr = {400};
        int[] expected = {-1};
        Assertions.assertArrayEquals(expected, solution1299.replaceElements(arr));
    }
}