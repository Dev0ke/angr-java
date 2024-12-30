import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution42Tests {
    private final Solution42 solution42 = new Solution42();

    @Test
    public void example1() {
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int expected = 6;
        Assertions.assertEquals(expected, solution42.trap(height));
    }

    @Test
    public void example2() {
        int[] height = {4, 2, 0, 3, 2, 5};
        int expected = 9;
        Assertions.assertEquals(expected, solution42.trap(height));
    }
}
