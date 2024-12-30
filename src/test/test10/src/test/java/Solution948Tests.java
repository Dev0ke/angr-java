import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution948Tests {
    private final Solution948 solution948 = new Solution948();

    @Test
    public void example1() {
        int[] tokens = {100};
        int power = 50;
        int expected = 0;
        Assertions.assertEquals(expected, solution948.bagOfTokensScore(tokens, power));
    }

    @Test
    public void example2() {
        int[] tokens = {100, 200};
        int power = 150;
        int expected = 1;
        Assertions.assertEquals(expected, solution948.bagOfTokensScore(tokens, power));
    }

    @Test
    public void example3() {
        int[] tokens = {100, 200, 300, 400};
        int power = 200;
        int expected = 2;
        Assertions.assertEquals(expected, solution948.bagOfTokensScore(tokens, power));
    }
}