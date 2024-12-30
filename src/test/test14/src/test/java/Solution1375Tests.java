import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1375Tests {
    private final Solution1375 solution1375 = new Solution1375();

    @Test
    public void example1() {
        int[] flips = {3, 2, 4, 1, 5};
        int expected = 2;
        Assertions.assertEquals(expected, solution1375.numTimesAllBlue(flips));
    }

    @Test
    public void example2() {
        int[] flips = {4, 1, 2, 3};
        int expected = 1;
        Assertions.assertEquals(expected, solution1375.numTimesAllBlue(flips));
    }
}