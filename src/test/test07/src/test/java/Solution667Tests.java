import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution667Tests {
    private final Solution667 solution667 = new Solution667();

    @Test
    public void example1() {
        int n = 3;
        int k = 1;
        int[] expected = {1, 2, 3};
        Assertions.assertArrayEquals(expected, solution667.constructArray(n, k));
    }

    @Test
    public void example2() {
        int n = 3;
        int k = 2;
        int[] expected = {1, 3, 2};
        Assertions.assertArrayEquals(expected, solution667.constructArray(n, k));
    }
}
