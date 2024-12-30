import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2914Tests {
    private final Solution2914 solution2914 = new Solution2914();

    @Test
    public void example1() {
        String s = "1001";
        int expected = 2;
        Assertions.assertEquals(expected, solution2914.minChanges(s));
    }

    @Test
    public void example2() {
        String s = "10";
        int expected = 1;
        Assertions.assertEquals(expected, solution2914.minChanges(s));
    }

    @Test
    public void example3() {
        String s = "0000";
        int expected = 0;
        Assertions.assertEquals(expected, solution2914.minChanges(s));
    }
}