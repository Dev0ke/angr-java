import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution375Tests {
    private final Solution375 solution375 = new Solution375();

    @Test
    public void example1() {
        int n = 10;
        int expected = 16;
        Assertions.assertEquals(expected, solution375.getMoneyAmount(n));
    }

    @Test
    public void example2() {
        int n = 1;
        int expected = 0;
        Assertions.assertEquals(expected, solution375.getMoneyAmount(n));
    }

    @Test
    public void example3() {
        int n = 2;
        int expected = 1;
        Assertions.assertEquals(expected, solution375.getMoneyAmount(n));
    }
}