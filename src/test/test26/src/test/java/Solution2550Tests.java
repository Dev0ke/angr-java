import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2550Tests {
    private final Solution2550 solution2550 = new Solution2550();

    @Test
    public void example1() {
        int n = 3;
        int expected = 6;
        Assertions.assertEquals(expected, solution2550.monkeyMove(n));
    }

    @Test
    public void example2() {
        int n = 4;
        int expected = 14;
        Assertions.assertEquals(expected, solution2550.monkeyMove(n));
    }
}