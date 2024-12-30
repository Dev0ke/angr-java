import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution777Tests {
    private final Solution777 solution777 = new Solution777();

    @Test
    public void example1() {
        String start = "RXXLRXRXL";
        String end = "XRLXXRRLX";
        Assertions.assertTrue(solution777.canTransform(start, end));
    }

    @Test
    public void example2() {
        String start = "X";
        String end = "L";
        Assertions.assertFalse(solution777.canTransform(start, end));
    }

    // 补充用例
    @Test
    public void example3() {
        // https://leetcode.cn/submissions/detail/370691597/
        String start = "LXXLXRLXXL";
        String end = "XLLXRXLXLX";
        Assertions.assertFalse(solution777.canTransform(start, end));
    }
}
