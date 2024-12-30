import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1996Tests {
    private final Solution1996 solution1996 = new Solution1996();

    @Test
    public void example1() {
        int[][] properties = UtUtils.stringToInts2("[[5,5],[6,3],[3,6]]");
        int expected = 0;
        Assertions.assertEquals(expected, solution1996.numberOfWeakCharacters(properties));
    }

    @Test
    public void example2() {
        int[][] properties = UtUtils.stringToInts2("[[2,2],[3,3]]");
        int expected = 1;
        Assertions.assertEquals(expected, solution1996.numberOfWeakCharacters(properties));
    }

    @Test
    public void example3() {
        int[][] properties = UtUtils.stringToInts2("[[1,5],[10,4],[4,3]]");
        int expected = 1;
        Assertions.assertEquals(expected, solution1996.numberOfWeakCharacters(properties));
    }

    // 补充用例
    @Test
    public void example4() {
        // https://leetcode.cn/submissions/detail/215354106/
        // 40 / 44 个通过测试用例
        int[][] properties = UtUtils.loadingInts2("solution1996-example4-input.txt", 0);
        int expected = 0;
        Assertions.assertEquals(expected, solution1996.numberOfWeakCharacters(properties));
    }
}
