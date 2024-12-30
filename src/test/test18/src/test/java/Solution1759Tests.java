import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1759Tests {
    private final Solution1759 solution1759 = new Solution1759();

    @Test
    public void example1() {
        String s = "abbcccaa";
        int expected = 13;
        Assertions.assertEquals(expected, solution1759.countHomogenous(s));
    }

    @Test
    public void example2() {
        String s = "xy";
        int expected = 2;
        Assertions.assertEquals(expected, solution1759.countHomogenous(s));
    }

    @Test
    public void example3() {
        String s = "zzzzz";
        int expected = 15;
        Assertions.assertEquals(expected, solution1759.countHomogenous(s));
    }
}
