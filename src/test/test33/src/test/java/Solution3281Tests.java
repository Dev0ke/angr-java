import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3281Tests {
    private final Solution3281 solution3281 = new Solution3281();

    @Test
    public void example1() {
        int[] start = {6, 0, 3};
        int d = 2;
        int expected = 4;
        Assertions.assertEquals(expected, solution3281.maxPossibleScore(start, d));
    }

    @Test
    public void example2() {
        int[] start = {2, 6, 13, 13};
        int d = 5;
        int expected = 5;
        Assertions.assertEquals(expected, solution3281.maxPossibleScore(start, d));
    }
}