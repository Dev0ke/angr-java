import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3228Tests {
    private final Solution3228 solution3228 = new Solution3228();

    @Test
    public void example1() {
        String s = "1001101";
        int expected = 4;
        Assertions.assertEquals(expected, solution3228.maxOperations(s));
    }

    @Test
    public void example2() {
        String s = "00111";
        int expected = 0;
        Assertions.assertEquals(expected, solution3228.maxOperations(s));
    }
}