import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2696Tests {
    private final Solution2696 solution2696 = new Solution2696();

    @Test
    public void example1() {
        String s = "ABFCACDB";
        int expected = 2;
        Assertions.assertEquals(expected, solution2696.minLength(s));
    }

    @Test
    public void example2() {
        String s = "ACBBD";
        int expected = 5;
        Assertions.assertEquals(expected, solution2696.minLength(s));
    }
}