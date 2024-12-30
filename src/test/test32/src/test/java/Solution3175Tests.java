import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3175Tests {
    private final Solution3175 solution3175 = new Solution3175();

    @Test
    public void example1() {
        int[] skills = {4, 2, 6, 3, 9};
        int k = 2;
        int expected = 2;
        Assertions.assertEquals(expected, solution3175.findWinningPlayer(skills, k));
    }

    @Test
    public void example2() {
        int[] skills = {2, 5, 4};
        int k = 3;
        int expected = 1;
        Assertions.assertEquals(expected, solution3175.findWinningPlayer(skills, k));
    }
}