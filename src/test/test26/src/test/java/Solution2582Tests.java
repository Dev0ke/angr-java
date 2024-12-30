import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2582Tests {
    private final Solution2582 solution2582 = new Solution2582();

    @Test
    public void example1() {
        int n = 4;
        int time = 5;
        int expected = 2;
        Assertions.assertEquals(expected, solution2582.passThePillow(n, time));
    }

    @Test
    public void example2() {
        int n = 3;
        int time = 2;
        int expected = 3;
        Assertions.assertEquals(expected, solution2582.passThePillow(n, time));
    }
}