import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution927Tests {
    private final Solution927 solution927 = new Solution927();

    @Test
    public void example1() {
        int[] arr = {1, 0, 1, 0, 1};
        int[] expected = {0, 3};
        Assertions.assertArrayEquals(expected, solution927.threeEqualParts(arr));
    }

    @Test
    public void example2() {
        int[] arr = {1, 1, 0, 1, 1};
        int[] expected = {-1, -1};
        Assertions.assertArrayEquals(expected, solution927.threeEqualParts(arr));
    }

    @Test
    public void example3() {
        int[] arr = {1, 1, 0, 0, 1};
        int[] expected = {0, 2};
        Assertions.assertArrayEquals(expected, solution927.threeEqualParts(arr));
    }
}