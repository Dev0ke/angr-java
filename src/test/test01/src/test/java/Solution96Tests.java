import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution96Tests {
    private final Solution96 solution96 = new Solution96();

    @Test
    public void example1() {
        int n = 3;
        int expected = 5;
        Assertions.assertEquals(expected, solution96.numTrees(n));
        Assertions.assertEquals(expected, solution96.numTrees2(n));
    }

    @Test
    public void example2() {
        int n = 1;
        int expected = 1;
        Assertions.assertEquals(expected, solution96.numTrees(n));
        Assertions.assertEquals(expected, solution96.numTrees2(n));
    }
}
