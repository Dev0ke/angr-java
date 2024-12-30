import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution556Tests {
    private final Solution556 solution556 = new Solution556();

    @Test
    public void example1() {
        int n = 12;
        int expected = 21;
        Assertions.assertEquals(expected, solution556.nextGreaterElement(n));
    }

    @Test
    public void example2() {
        int n = 21;
        int expected = -1;
        Assertions.assertEquals(expected, solution556.nextGreaterElement(n));
    }
}
