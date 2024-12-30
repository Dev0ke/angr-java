import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2243Tests {
    private final Solution2243 solution2243 = new Solution2243();

    @Test
    public void example1() {
        String s = "11111222223";
        int k = 3;
        String expected = "135";
        Assertions.assertEquals(expected, solution2243.digitSum(s, k));
    }

    @Test
    public void example2() {
        String s = "00000000";
        int k = 3;
        String expected = "000";
        Assertions.assertEquals(expected, solution2243.digitSum(s, k));
    }
}
