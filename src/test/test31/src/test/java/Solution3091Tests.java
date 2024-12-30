import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3091Tests {
    private final Solution3091 solution3091 = new Solution3091();

    @Test
    public void example1() {
        int k = 11;
        int expected = 5;
        Assertions.assertEquals(expected, solution3091.minOperations(k));
    }

    @Test
    public void example2() {
        int k = 1;
        int expected = 0;
        Assertions.assertEquals(expected, solution3091.minOperations(k));
    }
}