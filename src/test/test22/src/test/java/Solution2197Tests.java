import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Solution2197Tests {
    private final Solution2197 solution2197 = new Solution2197();

    @Test
    public void example1() {
        int[] nums = {6, 4, 3, 2, 7, 6, 2};
        List<Integer> expected = List.of(12, 7, 6);
        Assertions.assertEquals(expected, solution2197.replaceNonCoprimes(nums));
    }

    @Test
    public void example2() {
        int[] nums = {2, 2, 1, 1, 3, 3, 3};
        List<Integer> expected = List.of(2, 1, 1, 3);
        Assertions.assertEquals(expected, solution2197.replaceNonCoprimes(nums));
    }

    // 补充用例
    @Test
    public void example3() {
        int[] nums = {48757};
        List<Integer> expected = List.of(48757);
        Assertions.assertEquals(expected, solution2197.replaceNonCoprimes(nums));
    }

    @Test
    public void example4() {
        int[] nums = {517, 11, 121, 517, 3, 51, 3, 1887, 5};
        List<Integer> expected = List.of(5687, 1887, 5);
        Assertions.assertEquals(expected, solution2197.replaceNonCoprimes(nums));
    }

    @Test
    public void example5() {
        int[] nums = {31, 97561, 97561, 97561, 97561, 97561, 97561, 97561, 97561};
        List<Integer> expected = List.of(31, 97561);
        Assertions.assertEquals(expected, solution2197.replaceNonCoprimes(nums));
    }

    @Test
    public void example6() {
        // TLE 57 / 71 个通过测试用例
        int[] nums = UtUtils.loadingInts("solution2197-example6-input.txt", 0);
        List<Integer> expected = UtUtils.loadingIntegerList("solution2197-example6-output.txt", 0);
        Assertions.assertEquals(expected, solution2197.replaceNonCoprimes(nums));
    }

    @Test
    public void example7() {
        // 60 / 71 个通过测试用例
        int[] nums = {287, 41, 49, 287, 899, 23, 23, 20677, 5, 825};
        List<Integer> expected = List.of(2009, 20677, 825);
        Assertions.assertEquals(expected, solution2197.replaceNonCoprimes(nums));
    }

    @Test
    public void example8() {
        // 69 / 71 个通过测试用例
        int[] nums = UtUtils.loadingInts("solution2197-example8-input.txt", 0);
        System.out.println(solution2197.replaceNonCoprimes(nums));
        List<Integer> expected = UtUtils.loadingIntegerList("solution2197-example8-output.txt", 0);
        Assertions.assertEquals(expected, solution2197.replaceNonCoprimes(nums));
    }
}
