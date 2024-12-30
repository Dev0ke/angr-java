import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2894Tests {
    private final Solution2894 solution2894 = new Solution2894();

    @Test
    public void example1() {
        int n = 5;
        int m = 6;
        int expected = 15;
        Assertions.assertEquals(expected, solution2894.differenceOfSums(n, m));
    }

    @Test
    public void example2() {
        int n = 5;
        int m = 1;
        int expected = -15;
        Assertions.assertEquals(expected, solution2894.differenceOfSums(n, m));
    }
}