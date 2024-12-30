import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution473Tests {
    private final Solution473 solution473 = new Solution473();

    @Test
    public void example1() {
        int[] matchsticks = {1, 1, 2, 2, 2};
        Assertions.assertTrue(solution473.makesquare(matchsticks));
    }

    @Test
    public void example2() {
        int[] matchsticks = {3, 3, 3, 3, 4};
        Assertions.assertFalse(solution473.makesquare(matchsticks));
    }
}
