import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2660Tests {
    private final Solution2660 solution2660 = new Solution2660();

    @Test
    public void example1() {
        int[] player1 = {4, 10, 7, 9};
        int[] player2 = {6, 5, 2, 3};
        int expected = 1;
        Assertions.assertEquals(expected, solution2660.isWinner(player1, player2));
    }

    @Test
    public void example2() {
        int[] player1 = {3, 5, 7, 6};
        int[] player2 = {8, 10, 10, 2};
        int expected = 2;
        Assertions.assertEquals(expected, solution2660.isWinner(player1, player2));
    }

    @Test
    public void example3() {
        int[] player1 = {2, 3};
        int[] player2 = {4, 1};
        int expected = 0;
        Assertions.assertEquals(expected, solution2660.isWinner(player1, player2));
    }
}