import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1461Tests {
    private final Solution1461 solution1461 = new Solution1461();

    @Test
    public void example1() {
        String s = "00110110";
        int k = 2;
        Assertions.assertTrue(solution1461.hasAllCodes(s, k));
    }

    @Test
    public void example2() {
        String s = "0110";
        int k = 1;
        Assertions.assertTrue(solution1461.hasAllCodes(s, k));
    }

    @Test
    public void example3() {
        String s = "0110";
        int k = 2;
        Assertions.assertFalse(solution1461.hasAllCodes(s, k));
    }
}