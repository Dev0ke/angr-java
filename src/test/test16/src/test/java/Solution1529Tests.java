import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1529Tests {
    private final Solution1529 solution1529 = new Solution1529();

    @Test
    public void example1() {
        String target = "10111";
        int expected = 3;
        Assertions.assertEquals(expected, solution1529.minFlips(target));
    }

    @Test
    public void example2() {
        String target = "101";
        int expected = 3;
        Assertions.assertEquals(expected, solution1529.minFlips(target));
    }

    @Test
    public void example3() {
        String target = "00000";
        int expected = 0;
        Assertions.assertEquals(expected, solution1529.minFlips(target));
    }
}