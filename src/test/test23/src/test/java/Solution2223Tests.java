import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2223Tests {
    private final Solution2223 solution2223 = new Solution2223();

    @Test
    public void example1() {
        String s = "babab";
        int expected = 9;
        Assertions.assertEquals(expected, solution2223.sumScores(s));
    }

    @Test
    public void example2() {
        String s = "azbazbzaz";
        int expected = 14;
        Assertions.assertEquals(expected, solution2223.sumScores(s));
    }

    // 补充用例
    @Test
    public void example3() {
        // 132 / 143 个通过测试用例
        String s = UtUtils.loadingString("solution2223-example3-input.txt", 0);
        int expected = 80001;
        Assertions.assertEquals(expected, solution2223.sumScores(s));
    }
}
