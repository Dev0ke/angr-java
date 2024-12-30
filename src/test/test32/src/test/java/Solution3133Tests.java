import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3133Tests {
    private final Solution3133 solution3133 = new Solution3133();

    @Test
    public void example1() {
        int n = 3;
        int x = 4;
        long expected = 6;
        Assertions.assertEquals(expected, solution3133.minEnd(n, x));
    }

    @Test
    public void example2() {
        int n = 2;
        int x = 7;
        long expected = 15;
        Assertions.assertEquals(expected, solution3133.minEnd(n, x));
    }
}