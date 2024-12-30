import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1947Tests {
    private final Solution1947 solution1947 = new Solution1947();

    @Test
    public void example1() {
        int[][] students = UtUtils.stringToInts2("[[1,1,0],[1,0,1],[0,0,1]]");
        int[][] mentors = UtUtils.stringToInts2("[[1,0,0],[0,0,1],[1,1,0]]");
        int expected = 8;
        Assertions.assertEquals(expected, solution1947.maxCompatibilitySum(students, mentors));
        Assertions.assertEquals(expected, solution1947.maxCompatibilitySum2(students, mentors));
    }

    @Test
    public void example2() {
        int[][] students = UtUtils.stringToInts2("[[0,0],[0,0],[0,0]]");
        int[][] mentors = UtUtils.stringToInts2("[[1,1],[1,1],[1,1]]");
        int expected = 0;
        Assertions.assertEquals(expected, solution1947.maxCompatibilitySum(students, mentors));
        Assertions.assertEquals(expected, solution1947.maxCompatibilitySum2(students, mentors));
    }

    // 补充用例
    @Test
    public void example3() {
        // https://leetcode.cn/submissions/detail/199541329/
        // 49 / 86 个通过测试用例
        int[][] students = UtUtils.stringToInts2("[[0,0,1,1,1,0,1],[0,1,1,0,0,0,0],[0,0,1,1,1,1,1],[0,1,0,0,1,0,1],[1,0,1,1,1,1,1]]");
        int[][] mentors = UtUtils.stringToInts2("[[0,1,1,0,0,0,0],[0,1,0,0,0,0,1],[0,1,0,1,0,0,1],[1,0,0,0,1,0,1],[1,1,1,1,1,0,0]]");
        int expected = 24;
        Assertions.assertEquals(expected, solution1947.maxCompatibilitySum(students, mentors));
        Assertions.assertEquals(expected, solution1947.maxCompatibilitySum2(students, mentors));
    }

    @Test
    public void example4() {
        // https://leetcode.cn/submissions/detail/199559900/
        // 73 / 86 个通过测试用例
        int[][] students = UtUtils.stringToInts2("[[0,0,1,0,1],[1,0,1,1,1]]");
        int[][] mentors = UtUtils.stringToInts2("[[1,0,1,0,1],[1,0,1,1,0]]");
        int expected = 8;
        Assertions.assertEquals(expected, solution1947.maxCompatibilitySum(students, mentors));
        Assertions.assertEquals(expected, solution1947.maxCompatibilitySum2(students, mentors));
    }

    @Test
    public void example5() {
        // https://leetcode.cn/submissions/detail/199562244/
        // 76 / 86 个通过测试用例
        int[][] students = UtUtils.stringToInts2("[[1,1,1],[0,0,1],[0,0,1],[0,1,0]]");
        int[][] mentors = UtUtils.stringToInts2("[[1,0,1],[0,1,1],[0,1,0],[1,1,0]]");
        int expected = 9;
        Assertions.assertEquals(expected, solution1947.maxCompatibilitySum(students, mentors));
        Assertions.assertEquals(expected, solution1947.maxCompatibilitySum2(students, mentors));
    }

    @Test
    public void example6() {
        // https://leetcode.cn/submissions/detail/199576573/
        // 43 / 86 个通过测试用例
        // dfs
        int[][] students = UtUtils.stringToInts2("[[0,1,0,1,1,1],[1,0,0,1,0,1],[1,0,1,1,0,0]]");
        int[][] mentors = UtUtils.stringToInts2("[[1,0,0,0,0,1],[0,1,0,0,1,1],[0,1,0,0,1,1]]");
        int expected = 10;
        Assertions.assertEquals(expected, solution1947.maxCompatibilitySum(students, mentors));
        Assertions.assertEquals(expected, solution1947.maxCompatibilitySum2(students, mentors));
    }

    @Test
    public void example7() {
        // https://leetcode.cn/submissions/detail/199577356/
        // 85 / 86 个通过测试用例
        int[][] students = UtUtils.stringToInts2("[[1,0,0,0,0,1,1,1],[1,0,0,1,1,1,0,1],[1,0,1,1,1,0,1,1],[0,0,1,1,0,1,1,1],[1,1,1,1,0,0,0,1],[0,0,0,0,1,0,0,1],[1,0,0,0,0,0,0,1]]");
        int[][] mentors = UtUtils.stringToInts2("[[1,1,0,0,0,0,1,0],[1,0,1,1,0,0,1,0],[1,1,1,0,1,0,1,0],[1,0,1,1,1,0,0,1],[0,0,0,0,1,0,0,1],[0,0,1,0,1,0,0,0],[1,1,0,1,0,0,0,1]]");
        int expected = 40;
        Assertions.assertEquals(expected, solution1947.maxCompatibilitySum(students, mentors));
        Assertions.assertEquals(expected, solution1947.maxCompatibilitySum2(students, mentors));
    }
}
/*
[[0,0,1,1,1,0,1],[0,1,1,0,0,0,0],[0,0,1,1,1,1,1],[0,1,0,0,1,0,1],[1,0,1,1,1,1,1]]
[[0,1,1,0,0,0,0],[0,1,0,0,0,0,1],[0,1,0,1,0,0,1],[1,0,0,0,1,0,1],[1,1,1,1,1,0,0]]

[[0,0,1,0,1],[1,0,1,1,1]]
[[1,0,1,0,1],[1,0,1,1,0]]

[[1,1,1],[0,0,1],[0,0,1],[0,1,0]]
[[1,0,1],[0,1,1],[0,1,0],[1,1,0]]

[[0,1,0,1,1,1],[1,0,0,1,0,1],[1,0,1,1,0,0]]
[[1,0,0,0,0,1],[0,1,0,0,1,1],[0,1,0,0,1,1]]

[[1,0,0,0,0,1,1,1],[1,0,0,1,1,1,0,1],[1,0,1,1,1,0,1,1],[0,0,1,1,0,1,1,1],[1,1,1,1,0,0,0,1],[0,0,0,0,1,0,0,1],[1,0,0,0,0,0,0,1]]
[[1,1,0,0,0,0,1,0],[1,0,1,1,0,0,1,0],[1,1,1,0,1,0,1,0],[1,0,1,1,1,0,0,1],[0,0,0,0,1,0,0,1],[0,0,1,0,1,0,0,0],[1,1,0,1,0,0,0,1]]
 */
