import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2335Tests {
    private final Solution2335 solution2335 = new Solution2335();

    @Test
    public void example1() {
        int[] amount = {1, 4, 2};
        int expected = 4;
        Assertions.assertEquals(expected, solution2335.fillCups(amount));
    }

    @Test
    public void example2() {
        int[] amount = {5, 4, 4};
        int expected = 7;
        Assertions.assertEquals(expected, solution2335.fillCups(amount));
    }

    @Test
    public void example3() {
        int[] amount = {5, 0, 0};
        int expected = 5;
        Assertions.assertEquals(expected, solution2335.fillCups(amount));
    }
}
