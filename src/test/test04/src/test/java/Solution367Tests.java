import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution367Tests {
    private final Solution367 solution367 = new Solution367();

    @Test
    public void example1() {
        int num = 16;
        Assertions.assertTrue(solution367.isPerfectSquare(num));
    }

    @Test
    public void example2() {
        int num = 14;
        Assertions.assertFalse(solution367.isPerfectSquare(num));
    }
}
