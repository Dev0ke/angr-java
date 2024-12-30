import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2038Tests {
    private final Solution2038 solution2038 = new Solution2038();

    @Test
    public void example1() {
        String colors = "AAABABB";
        Assertions.assertTrue(solution2038.winnerOfGame(colors));
    }

    @Test
    public void example2() {
        String colors = "AA";
        Assertions.assertFalse(solution2038.winnerOfGame(colors));
    }

    @Test
    public void example3() {
        String colors = "ABBBBBBBAAA";
        Assertions.assertFalse(solution2038.winnerOfGame(colors));
    }
}
