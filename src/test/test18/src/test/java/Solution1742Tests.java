import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1742Tests {
    private final Solution1742 solution1742 = new Solution1742();

    @Test
    public void example1() {
        int lowLimit = 1;
        int highLimit = 10;
        int expected = 2;
        Assertions.assertEquals(expected, solution1742.countBalls(lowLimit, highLimit));
    }

    @Test
    public void example2() {
        int lowLimit = 5;
        int highLimit = 15;
        int expected = 2;
        Assertions.assertEquals(expected, solution1742.countBalls(lowLimit, highLimit));
    }

    @Test
    public void example3() {
        int lowLimit = 19;
        int highLimit = 28;
        int expected = 2;
        Assertions.assertEquals(expected, solution1742.countBalls(lowLimit, highLimit));
    }
}
