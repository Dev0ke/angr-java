import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1189Tests {
    private final Solution1189 solution1189 = new Solution1189();

    @Test
    public void example1() {
        String text = "nlaebolko";
        int expected = 1;
        Assertions.assertEquals(expected, solution1189.maxNumberOfBalloons(text));
    }

    @Test
    public void example2() {
        String text = "loonbalxballpoon";
        int expected = 2;
        Assertions.assertEquals(expected, solution1189.maxNumberOfBalloons(text));
    }

    @Test
    public void example3() {
        String text = "leetcode";
        int expected = 0;
        Assertions.assertEquals(expected, solution1189.maxNumberOfBalloons(text));
    }
}
