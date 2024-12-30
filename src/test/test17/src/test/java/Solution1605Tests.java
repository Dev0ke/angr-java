import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1605Tests {
    private final Solution1605 solution1605 = new Solution1605();

    private boolean assertActual(int[] rowSum, int[] colSum, int[][] actual) {
        int M = actual.length;
        int N = actual[0].length;
        // 校对 rowSum
        for (int i = 0; i < M; i++) {
            int tmp = 0;
            for (int j = 0; j < N; j++) {
                tmp += actual[i][j];
            }
            if (tmp != rowSum[i]) {
                return false;
            }
        }
        // 校对 colSum
        for (int j = 0; j < N; j++) {
            int tmp = 0;
            for (int i = 0; i < M; i++) {
                tmp += actual[i][j];
            }
            if (tmp != colSum[j]) {
                return false;
            }
        }
        return true;
    }

    @Test
    public void example1() {
        int[] rowSum = {3, 8};
        int[] colSum = {4, 7};
        // 返回任意一个满足题目要求的二维矩阵，题目保证存在 至少一个 可行矩阵。
        int[][] expected = {{3, 0}, {1, 7}};
        Assertions.assertTrue(assertActual(rowSum.clone(), colSum.clone(), solution1605.restoreMatrix(rowSum, colSum)));
    }

    @Test
    public void example2() {
        int[] rowSum = {5, 7, 10};
        int[] colSum = {8, 6, 8};
        int[][] expected = {{0, 5, 0}, {6, 1, 0}, {2, 0, 8}};
        Assertions.assertTrue(assertActual(rowSum.clone(), colSum.clone(), solution1605.restoreMatrix(rowSum, colSum)));
    }

    @Test
    public void example3() {
        int[] rowSum = {14, 9};
        int[] colSum = {6, 9, 8};
        int[][] expected = {{0, 9, 5}, {6, 0, 3}};
        Assertions.assertTrue(assertActual(rowSum.clone(), colSum.clone(), solution1605.restoreMatrix(rowSum, colSum)));
    }

    @Test
    public void example4() {
        int[] rowSum = {1, 0};
        int[] colSum = {1};
        int[][] expected = {{1}, {0}};
        Assertions.assertTrue(assertActual(rowSum.clone(), colSum.clone(), solution1605.restoreMatrix(rowSum, colSum)));
    }

    @Test
    public void example5() {
        int[] rowSum = {0};
        int[] colSum = {0};
        int[][] expected = {{0}};
        Assertions.assertTrue(assertActual(rowSum.clone(), colSum.clone(), solution1605.restoreMatrix(rowSum, colSum)));
    }
}
