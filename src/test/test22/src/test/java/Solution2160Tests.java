import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2160Tests {
    private final Solution2160 solution2160 = new Solution2160();

    @Test
    public void example1() {
        int num = 2932;
        int expected = 52;
        Assertions.assertEquals(expected, solution2160.minimumSum(num));
    }

    @Test
    public void example2() {
        int num = 4009;
        int expected = 13;
        Assertions.assertEquals(expected, solution2160.minimumSum(num));
    }
}
