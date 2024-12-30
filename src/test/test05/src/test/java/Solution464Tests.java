import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution464Tests {
    private final Solution464 solution464 = new Solution464();

    @Test
    public void example1() {
        int maxChoosableInteger = 10;
        int desiredTotal = 11;
        Assertions.assertFalse(solution464.canIWin(maxChoosableInteger, desiredTotal));
    }

    @Test
    public void example2() {
        int maxChoosableInteger = 10;
        int desiredTotal = 0;
        Assertions.assertTrue(solution464.canIWin(maxChoosableInteger, desiredTotal));
    }

    @Test
    public void example3() {
        int maxChoosableInteger = 10;
        int desiredTotal = 1;
        Assertions.assertTrue(solution464.canIWin(maxChoosableInteger, desiredTotal));
    }
}
