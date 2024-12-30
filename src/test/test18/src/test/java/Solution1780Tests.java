import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1780Tests {
    private final Solution1780 solution1780 = new Solution1780();

    @Test
    public void example1() {
        int n = 12;
        Assertions.assertTrue(solution1780.checkPowersOfThree(n));
    }

    @Test
    public void example2() {
        int n = 91;
        Assertions.assertTrue(solution1780.checkPowersOfThree(n));
    }

    @Test
    public void example3() {
        int n = 21;
        Assertions.assertFalse(solution1780.checkPowersOfThree(n));
    }
}
