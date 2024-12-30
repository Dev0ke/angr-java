import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1326Tests {
    private final Solution1326 solution1326 = new Solution1326();

    @Test
    public void example1() {
        int n = 5;
        int[] ranges = {3, 4, 1, 1, 0, 0};
        int expected = 1;
        Assertions.assertEquals(expected, solution1326.minTaps(n, ranges));
    }

    @Test
    public void example2() {
        int n = 3;
        int[] ranges = {0, 0, 0, 0};
        int expected = -1;
        Assertions.assertEquals(expected, solution1326.minTaps(n, ranges));
    }
}