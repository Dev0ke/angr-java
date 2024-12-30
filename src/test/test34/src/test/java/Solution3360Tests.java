import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3360Tests {
    private final Solution3360 solution3360 = new Solution3360();

    @Test
    public void example1() {
        int n = 12;
        Assertions.assertTrue(solution3360.canAliceWin(n));
    }

    @Test
    public void example2() {
        int n = 1;
        Assertions.assertFalse(solution3360.canAliceWin(n));
    }
}