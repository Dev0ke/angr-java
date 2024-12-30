import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution693Tests {
    private final Solution693 solution693 = new Solution693();

    @Test
    public void example1() {
        int n = 5;
        Assertions.assertTrue(solution693.hasAlternatingBits(n));
    }

    @Test
    public void example2() {
        int n = 7;
        Assertions.assertFalse(solution693.hasAlternatingBits(n));
    }

    @Test
    public void example3() {
        int n = 11;
        Assertions.assertFalse(solution693.hasAlternatingBits(n));
    }
}
