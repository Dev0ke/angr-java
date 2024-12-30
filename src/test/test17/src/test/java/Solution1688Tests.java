import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1688Tests {
    private final Solution1688 solution1688 = new Solution1688();

    @Test
    public void example1() {
        int n = 7;
        int expected = 6;
        Assertions.assertEquals(expected, solution1688.numberOfMatches(n));
    }

    @Test
    public void example2() {
        int n = 14;
        int expected = 13;
        Assertions.assertEquals(expected, solution1688.numberOfMatches(n));
    }
}
