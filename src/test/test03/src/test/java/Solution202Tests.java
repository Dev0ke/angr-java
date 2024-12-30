import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution202Tests {
    private final Solution202 solution202 = new Solution202();

    @Test
    public void example1() {
        int n = 19;
        Assertions.assertTrue(solution202.isHappy(n));
    }

    @Test
    public void example2() {
        int n = 2;
        Assertions.assertFalse(solution202.isHappy(n));
    }
}
