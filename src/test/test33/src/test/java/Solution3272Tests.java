import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3272Tests {
    private final Solution3272 solution3272 = new Solution3272();

    @Test
    public void example1() {
        int n = 3;
        int k = 5;
        long expected = 27;
        Assertions.assertEquals(expected, solution3272.countGoodIntegers(n, k));
    }

    @Test
    public void example2() {
        int n = 1;
        int k = 4;
        long expected = 2;
        Assertions.assertEquals(expected, solution3272.countGoodIntegers(n, k));
    }

    @Test
    public void example3() {
        int n = 5;
        int k = 6;
        long expected = 2468;
        Assertions.assertEquals(expected, solution3272.countGoodIntegers(n, k));
    }
}