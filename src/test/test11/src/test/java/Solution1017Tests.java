import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1017Tests {
    private final Solution1017 solution1017 = new Solution1017();

    @Test
    public void example1() {
        int n = 2;
        String expected = "110";
        Assertions.assertEquals(expected, solution1017.baseNeg2(n));
    }

    @Test
    public void example2() {
        int n = 3;
        String expected = "111";
        Assertions.assertEquals(expected, solution1017.baseNeg2(n));
    }

    @Test
    public void example3() {
        int n = 4;
        String expected = "100";
        Assertions.assertEquals(expected, solution1017.baseNeg2(n));
    }
}