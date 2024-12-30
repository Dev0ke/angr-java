import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1888Tests {
    private final Solution1888 solution1888 = new Solution1888();

    @Test
    public void example1() {
        String s = "111000";
        int expected = 2;
        Assertions.assertEquals(expected, solution1888.minFlips(s));
    }

    @Test
    public void example2() {
        String s = "010";
        int expected = 0;
        Assertions.assertEquals(expected, solution1888.minFlips(s));
    }

    @Test
    public void example3() {
        String s = "1110";
        int expected = 1;
        Assertions.assertEquals(expected, solution1888.minFlips(s));
    }
}