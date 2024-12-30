import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Solution39Tests {
    private final Solution39.V1 solution39_v1 = new Solution39.V1();
    private final Solution39.V2 solution39_v2 = new Solution39.V2();

    @Test
    public void example1() {
        int[] candidates = {2, 3, 6, 7};
        int target = 7;
        List<List<Integer>> expected = UtUtils.stringToIntegerList2("[[2,2,3],[7]]");
        List<List<Integer>> actual = solution39_v1.combinationSum(candidates, target);
        actual.sort(UtUtils.INTEGER_LIST_COMPARATOR);
        expected.sort(UtUtils.INTEGER_LIST_COMPARATOR);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void example2() {
        int[] candidates = {2, 3, 5};
        int target = 8;
        List<List<Integer>> expected = UtUtils.stringToIntegerList2("[[2,2,2,2],[2,3,3],[3,5]]");
        List<List<Integer>> actual = solution39_v1.combinationSum(candidates, target);
        actual.sort(UtUtils.INTEGER_LIST_COMPARATOR);
        expected.sort(UtUtils.INTEGER_LIST_COMPARATOR);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void example3() {
        int[] candidates = {2};
        int target = 1;
        List<List<Integer>> expected = UtUtils.stringToIntegerList2("[]");
        List<List<Integer>> actual = solution39_v1.combinationSum(candidates, target);
        actual.sort(UtUtils.INTEGER_LIST_COMPARATOR);
        Assertions.assertEquals(expected, actual);
    }

    // 补充用例
    @Test
    public void example4() {
        // https://github.com/LeetCode-Feedback/LeetCode-Feedback/issues/9000
        // hqztrue：其实因为可以重复选同一个数的原因，连 O(n*2^n) 都不是一个上界，最坏数据会 TLE 得很惨...
        int[] candidates = {2, 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30, 32, 34, 36, 38, 40, 42, 44, 46, 48, 50, 52, 54, 56, 58, 60};
        int target = 499;
        List<List<Integer>> expected = UtUtils.stringToIntegerList2("[]");
        List<List<Integer>> actual = solution39_v2.combinationSum(candidates, target);
        actual.sort(UtUtils.INTEGER_LIST_COMPARATOR);
        expected.sort(UtUtils.INTEGER_LIST_COMPARATOR);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void example5() {
        // https://leetcode.cn/problems/combination-sum/solutions/1816684/yi-ge-shu-ju-tuan-mie-jue-da-bu-fen-dfsd-vshf/
        int[] candidates = {2, 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30, 32, 34, 36, 38, 40, 42, 44, 46, 48, 50, 52, 54, 56, 58, 197};
        int target = 199;
        List<List<Integer>> expected = UtUtils.stringToIntegerList2("[[2, 197]]");
        List<List<Integer>> actual = solution39_v2.combinationSum(candidates, target);
        actual.sort(UtUtils.INTEGER_LIST_COMPARATOR);
        expected.sort(UtUtils.INTEGER_LIST_COMPARATOR);
        Assertions.assertEquals(expected, actual);
    }
}
