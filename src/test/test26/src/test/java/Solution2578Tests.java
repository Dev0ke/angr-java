import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2578Tests {
    private final Solution2578 solution2578 = new Solution2578();

    @Test
    public void example1() {
        int num = 4325;
        int expected = 59;
        Assertions.assertEquals(expected, solution2578.splitNum(num));
    }

    @Test
    public void example2() {
        int num = 687;
        int expected = 75;
        Assertions.assertEquals(expected, solution2578.splitNum(num));
    }
}