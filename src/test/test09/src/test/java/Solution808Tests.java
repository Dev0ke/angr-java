import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution808Tests {
    private final Solution808 solution808 = new Solution808();

    @Test
    public void example1() {
        int n = 50;
        double expected = 0.62500;
        Assertions.assertEquals(expected, solution808.soupServings(n));
    }

    @Test
    public void example2() {
        int n = 100;
        double expected = 0.71875;
        Assertions.assertEquals(expected, solution808.soupServings(n));
    }
}