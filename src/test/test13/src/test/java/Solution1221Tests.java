import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1221Tests {
    private final Solution1221 solution1221 = new Solution1221();

    @Test
    public void example1() {
        String s = "RLRRLLRLRL";
        int expected = 4;
        Assertions.assertEquals(expected, solution1221.balancedStringSplit(s));
    }

    @Test
    public void example2() {
        String s = "RLLLLRRRLR";
        int expected = 3;
        Assertions.assertEquals(expected, solution1221.balancedStringSplit(s));
    }

    @Test
    public void example3() {
        String s = "LLLLRRRR";
        int expected = 1;
        Assertions.assertEquals(expected, solution1221.balancedStringSplit(s));
    }

    @Test
    public void example4() {
        String s = "RLRRRLLRLL";
        int expected = 2;
        Assertions.assertEquals(expected, solution1221.balancedStringSplit(s));
    }
}
