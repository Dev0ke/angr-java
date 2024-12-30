import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1025Tests {
    private final Solution1025 solution1025 = new Solution1025();

    @Test
    public void example1() {
        int n = 2;
        Assertions.assertTrue(solution1025.divisorGame(n));
    }

    @Test
    public void example2() {
        int n = 3;
        Assertions.assertFalse(solution1025.divisorGame(n));
    }
}