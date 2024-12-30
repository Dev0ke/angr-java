import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2787Tests {
    private final Solution2787 solution2787 = new Solution2787();

    @Test
    public void example1() {
        int n = 10;
        int x = 2;
        int expected = 1;
        Assertions.assertEquals(expected, solution2787.numberOfWays(n, x));
    }

    @Test
    public void example2() {
        int n = 4;
        int x = 1;
        int expected = 2;
        Assertions.assertEquals(expected, solution2787.numberOfWays(n, x));
    }
}