import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2427Tests {
    private final Solution2427 solution2427 = new Solution2427();

    @Test
    public void example1() {
        int a = 12;
        int b = 6;
        int expected = 4;
        Assertions.assertEquals(expected, solution2427.commonFactors(a, b));
    }

    @Test
    public void example2() {
        int a = 25;
        int b = 30;
        int expected = 2;
        Assertions.assertEquals(expected, solution2427.commonFactors(a, b));
    }
}
