import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3213Tests {
    private final Solution3213.V1 solution_v1 = new Solution3213.V1();
    private final Solution3213.V2 solution_v2 = new Solution3213.V2();

    @Test
    public void example1() {
        String target = "abcdef";
        String[] words = {"abdef", "abc", "d", "def", "ef"};
        int[] costs = {100, 1, 1, 10, 5};
        int expected = 7;
        Assertions.assertEquals(expected, solution_v1.minimumCost(target, words, costs));
        Assertions.assertEquals(expected, solution_v2.minimumCost(target, words, costs));
    }

    @Test
    public void example2() {
        String target = "aaaa";
        String[] words = {"z", "zz", "zzz"};
        int[] costs = {1, 10, 100};
        int expected = -1;
        Assertions.assertEquals(expected, solution_v1.minimumCost(target, words, costs));
        Assertions.assertEquals(expected, solution_v2.minimumCost(target, words, costs));
    }

    // 补充用例
    @Test
    public void example3() {
        // https://leetcode.cn/problems/construct-string-with-minimum-cost/submissions/544703767/
        // TLE 750 / 803 个通过的测试用例
        final String fileName = "solution3213-example3-input.txt";
        String target = UtUtils.loadingString(fileName, 0);
        String[] words = UtUtils.loadingStrings(fileName, 1);
        int[] costs = UtUtils.loadingInts(fileName, 2);
        int expected = 4614;
        Assertions.assertEquals(expected, solution_v1.minimumCost(target, words, costs));
    }

    @Test
    public void example4() {
        // https://leetcode.cn/problems/construct-string-with-minimum-cost/submissions/545857386/
        // TLE 804 / 808 个通过的测试用例
        final String fileName = "solution3213-example4-input.txt";
        String target = UtUtils.loadingString(fileName, 0);
        String[] words = UtUtils.loadingStrings(fileName, 1);
        int[] costs = UtUtils.loadingInts(fileName, 2);
        int expected = -1;
        Assertions.assertEquals(expected, solution_v1.minimumCost(target, words, costs));
    }
}