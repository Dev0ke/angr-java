import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution132Tests {
    private final Solution132 solution132 = new Solution132();

    @Test
    public void example1() {
        String s = "aab";
        int expected = 1;
        Assertions.assertEquals(expected, solution132.minCut(s));
    }

    @Test
    public void example2() {
        String s = "a";
        int expected = 0;
        Assertions.assertEquals(expected, solution132.minCut(s));
    }

    @Test
    public void example3() {
        String s = "ab";
        int expected = 1;
        Assertions.assertEquals(expected, solution132.minCut(s));
    }
}
