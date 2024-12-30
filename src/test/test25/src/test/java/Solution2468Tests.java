import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2468Tests {
    private final Solution2468 solution2468 = new Solution2468();

    @Test
    public void example1() {
        String message = "this is really a very awesome message";
        int limit = 9;
        String[] expected = {"thi<1/14>", "s i<2/14>", "s r<3/14>", "eal<4/14>", "ly <5/14>", "a v<6/14>", "ery<7/14>", " aw<8/14>", "eso<9/14>", "me<10/14>", " m<11/14>", "es<12/14>", "sa<13/14>", "ge<14/14>"};
        Assertions.assertArrayEquals(expected, solution2468.splitMessage(message, limit));
    }

    @Test
    public void example2() {
        String message = "short message";
        int limit = 15;
        String[] expected = {"short mess<1/2>", "age<2/2>"};
        Assertions.assertArrayEquals(expected, solution2468.splitMessage(message, limit));
    }

    // 补充用例
    @Test
    public void example3() {
        // https://leetcode.cn/submissions/detail/381544768/
        String message = "boxpn";
        int limit = 5;
        String[] expected = {};
        Assertions.assertArrayEquals(expected, solution2468.splitMessage(message, limit));
    }

    @Test
    public void example4() {
        // https://leetcode.cn/submissions/detail/381655228/
        String message = "noubnqgmc";
        int limit = 5;
        String[] expected = {};
        Assertions.assertArrayEquals(expected, solution2468.splitMessage(message, limit));
    }

    @Test
    public void example5() {
        // https://leetcode.cn/submissions/detail/381655938/
        String message = "p";
        int limit = 7;
        String[] expected = {"p<1/1>"};
        Assertions.assertArrayEquals(expected, solution2468.splitMessage(message, limit));
    }

    @Test
    public void example6() {
        // https://leetcode.cn/submissions/detail/381715447/
        String fileName = "solution2468-example6-input.txt";
        String message = UtUtils.loadingString(fileName, 0);
        int limit = UtUtils.loadingInt(fileName, 1);
        String[] expected = {};
        Assertions.assertArrayEquals(expected, solution2468.splitMessage(message, limit));
    }
}