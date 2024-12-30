import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution292Tests {
    private final Solution292 solution292 = new Solution292();

    @Test
    public void example1() {
        int n = 4;
        Assertions.assertFalse(solution292.canWinNim(n));
    }

    @Test
    public void example2() {
        int n = 1;
        Assertions.assertTrue(solution292.canWinNim(n));
    }

    @Test
    public void example3() {
        int n = 2;
        Assertions.assertTrue(solution292.canWinNim(n));
    }
}
