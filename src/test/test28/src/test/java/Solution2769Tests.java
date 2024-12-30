import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2769Tests {
    private final Solution2769 solution2769 = new Solution2769();

    @Test
    public void example1() {
        int num = 4;
        int t = 1;
        int expected = 6;
        Assertions.assertEquals(expected, solution2769.theMaximumAchievableX(num, t));
    }

    @Test
    public void example2() {
        int num = 3;
        int t = 2;
        int expected = 7;
        Assertions.assertEquals(expected, solution2769.theMaximumAchievableX(num, t));
    }
}