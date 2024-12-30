import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution932Tests {
    private final Solution932 solution932 = new Solution932();

    @Test
    public void example1() {
        int n = 4;
//        int[] expected = {2, 1, 4, 3};
        int[] expected = {1, 3, 2, 4};
        Assertions.assertArrayEquals(expected, solution932.beautifulArray(n));
    }

    @Test
    public void example2() {
        int n = 5;
//        int[] expected = {3, 1, 2, 5, 4};
        int[] expected = {1, 5, 3, 2, 4};
        Assertions.assertArrayEquals(expected, solution932.beautifulArray(n));
    }
}