import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1732Tests {
    private final Solution1732 solution1732 = new Solution1732();

    @Test
    public void example1() {
        int[] gain = {-5, 1, 5, 0, -7};
        int expected = 1;
        Assertions.assertEquals(expected, solution1732.largestAltitude(gain));
    }

    @Test
    public void example2() {
        int[] gain = {-4, -3, -2, -1, 4, 3, 2};
        int expected = 0;
        Assertions.assertEquals(expected, solution1732.largestAltitude(gain));
    }
}
