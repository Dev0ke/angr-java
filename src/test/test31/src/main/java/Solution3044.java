import java.util.HashMap;
import java.util.Map;

public class Solution3044 {
    private static final int[][] DIRECTIONS8 = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}, {-1, -1}, {1, 1}, {-1, 1}, {1, -1}};

    public int mostFrequentPrime(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        Map<Integer, Integer> cnt = new HashMap<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int[] d : DIRECTIONS8) {
                    int nx = i + d[0];
                    int ny = j + d[1];
                    int v = mat[i][j];
                    while (nx >= 0 && nx < m && ny >= 0 && ny < n) {
                        v = v * 10 + mat[nx][ny];
                        if (isPrime(v)) {
                            cnt.put(v, cnt.getOrDefault(v, 0) + 1);
                        }
                        nx += d[0];
                        ny += d[1];
                    }
                }
            }
        }

        int ans = -1;
        int maxCnt = 0;
        for (Map.Entry<Integer, Integer> entry : cnt.entrySet()) {
            int key = entry.getKey();
            int c = entry.getValue();
            if (maxCnt < c) {
                maxCnt = c;
                ans = key;
            } else if (maxCnt == c) {
                ans = Math.max(ans, key);
            }
        }
        return ans;
    }

    private static boolean isPrime(int num) {
        if (num < 2) return false;
        for (int i = 2; i * i <= num; ++i) {
            if (num % i == 0) return false;
        }
        return true;
    }
}
/*
3044. 出现频率最高的质数
https://leetcode.cn/problems/most-frequent-prime/description/

第 385 场周赛 T3。

给你一个大小为 m x n 、下标从 0 开始的二维矩阵 mat 。在每个单元格，你可以按以下方式生成数字：
- 最多有 8 条路径可以选择：东，东南，南，西南，西，西北，北，东北。
- 选择其中一条路径，沿着这个方向移动，并且将路径上的数字添加到正在形成的数字后面。
- 注意，每一步都会生成数字，例如，如果路径上的数字是 1, 9, 1，那么在这个方向上会生成三个数字：1, 19, 191 。
返回在遍历矩阵所创建的所有数字中，出现频率最高的、大于 10的质数；如果不存在这样的质数，则返回 -1 。如果存在多个出现频率最高的质数，那么返回其中最大的那个。
注意：移动过程中不允许改变方向。
提示：
m == mat.length
n == mat[i].length
1 <= m, n <= 6
1 <= mat[i][j] <= 9

枚举。
时间复杂度 O(mnk)。其中 k = max(m, n)。判断质数需要 O(sqrt(10^k))
空间复杂度 O(mnk)
 */