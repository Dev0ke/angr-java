import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2081Tests {
    private final Solution2081 solution2081 = new Solution2081();

    @Test
    public void example1() {
        int k = 2;
        int n = 5;
        long expected = 25;
        Assertions.assertEquals(expected, solution2081.kMirror(k, n));
    }

    @Test
    public void example2() {
        int k = 3;
        int n = 7;
        long expected = 499;
        Assertions.assertEquals(expected, solution2081.kMirror(k, n));
    }

    @Test
    public void example3() {
        int k = 7;
        int n = 17;
        long expected = 20379000;
        Assertions.assertEquals(expected, solution2081.kMirror(k, n));
    }
}
