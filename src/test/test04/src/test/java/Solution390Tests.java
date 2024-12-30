import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution390Tests {
    private final Solution390 solution390 = new Solution390();

    @Test
    public void example1() {
        int n = 9;
        int expected = 6;
        Assertions.assertEquals(expected, solution390.lastRemaining(n));
    }

    @Test
    public void example2() {
        int n = 1;
        int expected = 1;
        Assertions.assertEquals(expected, solution390.lastRemaining(n));
    }
}