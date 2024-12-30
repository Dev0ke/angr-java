import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1247Tests {
    private final Solution1247 solution1247 = new Solution1247();

    @Test
    public void example1() {
        String s1 = "xx";
        String s2 = "yy";
        int expected = 1;
        Assertions.assertEquals(expected, solution1247.minimumSwap(s1, s2));
    }

    @Test
    public void example2() {
        String s1 = "xy";
        String s2 = "yx";
        int expected = 2;
        Assertions.assertEquals(expected, solution1247.minimumSwap(s1, s2));
    }

    @Test
    public void example3() {
        String s1 = "xx";
        String s2 = "xy";
        int expected = -1;
        Assertions.assertEquals(expected, solution1247.minimumSwap(s1, s2));
    }

    @Test
    public void example4() {
        String s1 = "xxyyxyxyxx";
        String s2 = "xyyxyxxxyx";
        int expected = 4;
        Assertions.assertEquals(expected, solution1247.minimumSwap(s1, s2));
    }
}
