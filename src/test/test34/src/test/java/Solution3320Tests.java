import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3320Tests {
    private final Solution3320 solution3320 = new Solution3320();

    @Test
    public void example1() {
        String s = "FFF";
        int expected = 3;
        Assertions.assertEquals(expected, solution3320.countWinningSequences(s));
    }

    @Test
    public void example2() {
        String s = "FWEFW";
        int expected = 18;
        Assertions.assertEquals(expected, solution3320.countWinningSequences(s));
    }
}