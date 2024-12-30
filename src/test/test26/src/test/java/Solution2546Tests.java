import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2546Tests {
    private final Solution2546 solution2546 = new Solution2546();

    @Test
    public void example1() {
        String s = "1010";
        String target = "0110";
        Assertions.assertTrue(solution2546.makeStringsEqual(s, target));
        Assertions.assertTrue(solution2546.makeStringsEqual2(s, target));
    }

    @Test
    public void example2() {
        String s = "11";
        String target = "00";
        Assertions.assertFalse(solution2546.makeStringsEqual(s, target));
        Assertions.assertFalse(solution2546.makeStringsEqual2(s, target));
    }
}