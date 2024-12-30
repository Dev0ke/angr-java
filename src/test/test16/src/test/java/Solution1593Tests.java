import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1593Tests {
    private final Solution1593 solution1593 = new Solution1593();

    @Test
    public void example1() {
        String s = "ababccc";
        int expected = 5;
        Assertions.assertEquals(expected, solution1593.maxUniqueSplit(s));
    }

    @Test
    public void example2() {
        String s = "aba";
        int expected = 2;
        Assertions.assertEquals(expected, solution1593.maxUniqueSplit(s));
    }

    @Test
    public void example3() {
        String s = "aa";
        int expected = 1;
        Assertions.assertEquals(expected, solution1593.maxUniqueSplit(s));
    }
}