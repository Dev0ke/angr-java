import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2896Tests {
    private final Solution2896 solution2896 = new Solution2896();

    @Test
    public void example1() {
        String s1 = "1100011000";
        String s2 = "0101001010";
        int x = 2;
        int expected = 4;
        Assertions.assertEquals(expected, solution2896.minOperations(s1, s2, x));
    }

    @Test
    public void example2() {
        String s1 = "10110";
        String s2 = "00011";
        int x = 4;
        int expected = -1;
        Assertions.assertEquals(expected, solution2896.minOperations(s1, s2, x));
    }
}