import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1124Tests {
    private final Solution1124 solution1124 = new Solution1124();

    @Test
    public void example1() {
        int[] hours = {9, 9, 6, 0, 6, 6, 9};
        int expected = 3;
        Assertions.assertEquals(expected, solution1124.longestWPI(hours));
    }

    @Test
    public void example2() {
        int[] hours = {6, 6, 6};
        int expected = 0;
        Assertions.assertEquals(expected, solution1124.longestWPI(hours));
    }
}