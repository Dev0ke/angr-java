import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1510Tests {
    private final Solution1510 solution1510 = new Solution1510();

    @Test
    public void example1() {
        int n = 1;
        Assertions.assertTrue(solution1510.winnerSquareGame(n));
    }

    @Test
    public void example2() {
        int n = 2;
        Assertions.assertFalse(solution1510.winnerSquareGame(n));
    }

    @Test
    public void example3() {
        int n = 4;
        Assertions.assertTrue(solution1510.winnerSquareGame(n));
    }

    @Test
    public void example4() {
        int n = 7;
        Assertions.assertFalse(solution1510.winnerSquareGame(n));
    }

    @Test
    public void example5() {
        int n = 17;
        Assertions.assertFalse(solution1510.winnerSquareGame(n));
    }
}
