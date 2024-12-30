import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3352Tests {
    private final Solution3352 solution3352 = new Solution3352();

    @Test
    public void example1() {
        String s = "111";
        int k = 1;
        int expected = 3;
        Assertions.assertEquals(expected, solution3352.countKReducibleNumbers(s, k));
    }

    @Test
    public void example2() {
        String s = "1000";
        int k = 2;
        int expected = 6;
        Assertions.assertEquals(expected, solution3352.countKReducibleNumbers(s, k));
    }

    @Test
    public void example3() {
        String s = "1";
        int k = 3;
        int expected = 0;
        Assertions.assertEquals(expected, solution3352.countKReducibleNumbers(s, k));
    }
}