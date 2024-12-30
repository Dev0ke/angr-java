import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1663Tests {
    private final Solution1663 solution1663 = new Solution1663();

    @Test
    public void example1() {
        int n = 3;
        int k = 27;
        String expected = "aay";
        Assertions.assertEquals(expected, solution1663.getSmallestString(n, k));
    }

    @Test
    public void example2() {
        int n = 5;
        int k = 73;
        String expected = "aaszz";
        Assertions.assertEquals(expected, solution1663.getSmallestString(n, k));
    }
}