import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1823Tests {
    private final Solution1823 solution1823 = new Solution1823();

    @Test
    public void example1() {
        int n = 5;
        int k = 2;
        int expected = 3;
        Assertions.assertEquals(expected, solution1823.findTheWinner(n, k));
    }

    @Test
    public void example2() {
        int n = 6;
        int k = 5;
        int expected = 1;
        Assertions.assertEquals(expected, solution1823.findTheWinner(n, k));
    }
}
