import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2306Tests {
    private final Solution2306 solution2306 = new Solution2306();

    @Test
    public void example1() {
        String[] ideas = {"coffee", "donuts", "time", "toffee"};
        long expected = 6;
        Assertions.assertEquals(expected, solution2306.distinctNames(ideas));
    }

    @Test
    public void example2() {
        String[] ideas = {"lack", "back"};
        long expected = 0;
        Assertions.assertEquals(expected, solution2306.distinctNames(ideas));
    }
}
