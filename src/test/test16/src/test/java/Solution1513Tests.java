import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1513Tests {
    private final Solution1513 solution1513 = new Solution1513();

    @Test
    public void example1() {
        String s = "0110111";
        int expected = 9;
        Assertions.assertEquals(expected, solution1513.numSub(s));
    }

    @Test
    public void example2() {
        String s = "101";
        int expected = 2;
        Assertions.assertEquals(expected, solution1513.numSub(s));
    }

    @Test
    public void example3() {
        String s = "111111";
        int expected = 21;
        Assertions.assertEquals(expected, solution1513.numSub(s));
    }

    @Test
    public void example4() {
        String s = "000";
        int expected = 0;
        Assertions.assertEquals(expected, solution1513.numSub(s));
    }
}