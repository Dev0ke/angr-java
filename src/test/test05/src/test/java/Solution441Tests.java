import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution441Tests {
    private final Solution441 solution441 = new Solution441();

    @Test
    public void example1() {
        int n = 5;
        int expected = 2;
        Assertions.assertEquals(expected, solution441.arrangeCoins(n));
    }

    @Test
    public void example2() {
        int n = 8;
        int expected = 3;
        Assertions.assertEquals(expected, solution441.arrangeCoins(n));
    }
}
