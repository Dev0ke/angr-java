import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2343Tests {
    private final Solution2343 solution2343 = new Solution2343();

    @Test
    public void example1() {
        String[] nums = {"102", "473", "251", "814"};
        int[][] queries = UtUtils.stringToInts2("[[1,1],[2,3],[4,2],[1,2]]");
        int[] expected = {2, 2, 1, 0};
        Assertions.assertArrayEquals(expected, solution2343.smallestTrimmedNumbers(nums, queries));
    }

    @Test
    public void example2() {
        String[] nums = {"24", "37", "96", "04"};
        int[][] queries = UtUtils.stringToInts2("[[2,1],[2,2]]");
        int[] expected = {3, 0};
        Assertions.assertArrayEquals(expected, solution2343.smallestTrimmedNumbers(nums, queries));
    }

    // 补充用例
    @Test
    public void example3() {
        // https://leetcode.cn/submissions/detail/337872152/
        // java.lang.NumberFormatException: For input string: "4333639502"
        String[] nums = {"64333639502", "65953866768", "17845691654", "87148775908", "58954177897", "70439926174", "48059986638", "47548857440", "18418180516", "06364956881", "01866627626", "36824890579", "14672385151", "71207752868"};
        int[][] queries = UtUtils.stringToInts2("[[9,4],[6,1],[3,8],[12,9],[11,4],[4,9],[2,7],[10,3],[13,1],[13,1],[6,1],[5,10]]");
        int[] expected = {1, 5, 11, 10, 7, 0, 0, 1, 13, 13, 5, 12};
        Assertions.assertArrayEquals(expected, solution2343.smallestTrimmedNumbers(nums, queries));
    }
}