import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2182Tests {
    private final Solution2182 solution2182 = new Solution2182();

    @Test
    public void example1() {
        String s = "cczazcc";
        int repeatLimit = 3;
        String expected = "zzcccac";
        Assertions.assertEquals(expected, solution2182.repeatLimitedString(s, repeatLimit));
        Assertions.assertEquals(expected, solution2182.repeatLimitedString2(s, repeatLimit));
    }

    @Test
    public void example2() {
        String s = "aababab";
        int repeatLimit = 2;
        String expected = "bbabaa";
        Assertions.assertEquals(expected, solution2182.repeatLimitedString(s, repeatLimit));
        Assertions.assertEquals(expected, solution2182.repeatLimitedString2(s, repeatLimit));
    }

    // 补充用例
    @Test
    public void example3() {
        String s = UtUtils.loadingString("solution2182-example3-input.txt", 0);
        int repeatLimit = UtUtils.loadingInt("solution2182-example3-input.txt", 1);
        String expected = UtUtils.loadingString("solution2182-example3-output.txt", 0);
        Assertions.assertEquals(expected, solution2182.repeatLimitedString(s, repeatLimit));
        Assertions.assertEquals(expected, solution2182.repeatLimitedString2(s, repeatLimit));
    }
}
