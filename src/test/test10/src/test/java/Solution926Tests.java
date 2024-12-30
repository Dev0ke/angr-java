import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution926Tests {
    private final Solution926 solution926 = new Solution926();

    @Test
    public void example1() {
        String s = "00110";
        int expected = 1;
        Assertions.assertEquals(expected, solution926.minFlipsMonoIncr(s));
    }

    @Test
    public void example2() {
        String s = "010110";
        int expected = 2;
        Assertions.assertEquals(expected, solution926.minFlipsMonoIncr(s));
    }

    @Test
    public void example3() {
        String s = "00011000";
        int expected = 2;
        Assertions.assertEquals(expected, solution926.minFlipsMonoIncr(s));
    }
}
