import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2443Tests {
    private final Solution2443 solution2443 = new Solution2443();

    @Test
    public void example1() {
        int num = 443;
        Assertions.assertTrue(solution2443.sumOfNumberAndReverse(num));
    }

    @Test
    public void example2() {
        int num = 63;
        Assertions.assertFalse(solution2443.sumOfNumberAndReverse(num));
    }

    @Test
    public void example3() {
        int num = 181;
        Assertions.assertTrue(solution2443.sumOfNumberAndReverse(num));
    }
}
