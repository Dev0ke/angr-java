import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1473Tests {
    private final Solution1473 solution1473 = new Solution1473();

    @Test
    public void example1() {
        int[] houses = {0, 0, 0, 0, 0};
        int[][] cost = UtUtils.stringToInts2("[[1,10],[10,1],[10,1],[1,10],[5,1]]");
        int m = 5;
        int n = 2;
        int target = 3;
        int expected = 9;
        Assertions.assertEquals(expected, solution1473.minCost(houses, cost, m, n, target));
    }

    @Test
    public void example2() {
        int[] houses = {0, 2, 1, 2, 0};
        int[][] cost = UtUtils.stringToInts2("[[1,10],[10,1],[10,1],[1,10],[5,1]]");
        int m = 5;
        int n = 2;
        int target = 3;
        int expected = 11;
        Assertions.assertEquals(expected, solution1473.minCost(houses, cost, m, n, target));
    }

    @Test
    public void example3() {
        int[] houses = {0, 0, 0, 0, 0};
        int[][] cost = UtUtils.stringToInts2("[[1,10],[10,1],[1,10],[10,1],[1,10]]");
        int m = 5;
        int n = 2;
        int target = 5;
        int expected = 5;
        Assertions.assertEquals(expected, solution1473.minCost(houses, cost, m, n, target));
    }

    @Test
    public void example4() {
        int[] houses = {3, 1, 2, 3};
        int[][] cost = UtUtils.stringToInts2("[[1,1,1],[1,1,1],[1,1,1],[1,1,1]]");
        int m = 4;
        int n = 3;
        int target = 3;
        int expected = -1;
        Assertions.assertEquals(expected, solution1473.minCost(houses, cost, m, n, target));
    }

    // 补充用例
    @Test
    public void example5() {
        // https://leetcode.cn/submissions/detail/359071637/
        String fileName = "solution1473-example5-input.txt";
        int[] houses = UtUtils.loadingInts(fileName, 0);
        int[][] cost = UtUtils.loadingInts2(fileName, 1);
        int m = UtUtils.loadingInt(fileName, 2);
        int n = UtUtils.loadingInt(fileName, 3);
        int target = UtUtils.loadingInt(fileName, 4);
        int expected = 1000000;
        Assertions.assertEquals(expected, solution1473.minCost(houses, cost, m, n, target));
    }
}
