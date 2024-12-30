import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SolutionP1246 {
    public int minimumMoves(int[] arr) {
        int n = arr.length;

        // 区间 DP
        // f[i][j] 表示子数组 a[i, j] 的最少操作次数
        int[][] f = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(f[i], n);
        }
        Map<Integer, List<Integer>> g = new HashMap<>();
        for (int i = 0; i < n; i++) {
            f[i][i] = 1;
            for (int j = i; j < n; j++) {
                if (arr[i] == arr[j]) {
                    g.computeIfAbsent(i, key -> new ArrayList<>()).add(j);
                }
            }
        }

        for (int i = n - 2; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                if (i == j - 1) {
                    f[i][j] = arr[i] != arr[j] ? 2 : 1;
                } else {
                    if (arr[i] == arr[j]) {
                        f[i][j] = f[i + 1][j - 1];
                    }
                    for (int k : g.get(i)) {
                        if (k >= j) {
                            break;
                        }
                        f[i][j] = Math.min(f[i][j], f[i][k] + f[k + 1][j]);
                    }
                }
            }
        }
        return f[0][n - 1];
    }
}
/*
$1246. 删除回文子数组
https://leetcode.cn/problems/palindrome-removal/

给你一个整数数组 arr，每一次操作你都可以选择并删除它的一个 回文 子数组 arr[i], arr[i+1], ..., arr[j]（ i <= j）。
注意，每当你删除掉一个子数组，右侧元素都会自行向前移动填补空位。
请你计算并返回从数组中删除所有数字所需的最少操作次数。
提示：
1 <= arr.length <= 100
1 <= arr[i] <= 20

标准区间DP（预处理使时间超过100%） https://leetcode.cn/problems/palindrome-removal/solution/biao-zhun-qu-jian-dpyu-chu-li-shi-shi-ji-9ey0/
 */