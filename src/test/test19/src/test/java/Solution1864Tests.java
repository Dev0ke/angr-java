import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1864Tests {
    private final Solution1864 solution1864 = new Solution1864();

    @Test
    public void example1() {
        String s = "111000";
        int expected = 1;
        Assertions.assertEquals(expected, solution1864.minSwaps(s));
    }

    @Test
    public void example2() {
        String s = "010";
        int expected = 0;
        Assertions.assertEquals(expected, solution1864.minSwaps(s));
    }

    @Test
    public void example3() {
        String s = "1110";
        int expected = -1;
        Assertions.assertEquals(expected, solution1864.minSwaps(s));
    }
}