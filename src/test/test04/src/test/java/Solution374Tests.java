import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution374Tests {
    @Test
    public void example1() {
        int n = 10;
        int pick = 6;
        int expected = 6;

        Solution374.Solution solution = new Solution374.Solution(pick);
        Assertions.assertEquals(expected, solution.guessNumber(n));
    }

    @Test
    public void example2() {
        int n = 1;
        int pick = 1;
        int expected = 1;

        Solution374.Solution solution = new Solution374.Solution(pick);
        Assertions.assertEquals(expected, solution.guessNumber(n));
    }

    @Test
    public void example3() {
        int n = 2;
        int pick = 1;
        int expected = 1;

        Solution374.Solution solution = new Solution374.Solution(pick);
        Assertions.assertEquals(expected, solution.guessNumber(n));
    }

    @Test
    public void example4() {
        int n = 2;
        int pick = 2;
        int expected = 2;

        Solution374.Solution solution = new Solution374.Solution(pick);
        Assertions.assertEquals(expected, solution.guessNumber(n));
    }
}
