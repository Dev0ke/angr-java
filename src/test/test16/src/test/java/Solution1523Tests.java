import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1523Tests {
    private final Solution1523 solution1523 = new Solution1523();

    @Test
    public void example1() {
        int low = 3;
        int high = 7;
        int expected = 3;
        Assertions.assertEquals(expected, solution1523.countOdds(low, high));
    }

    @Test
    public void example2() {
        int low = 8;
        int high = 10;
        int expected = 1;
        Assertions.assertEquals(expected, solution1523.countOdds(low, high));
    }
}
