import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution3030 {
    public int[][] resultGrid(int[][] image, int threshold) {
        int m = image.length;
        int n = image[0].length;

        Map<Integer, List<Integer>> mp = new HashMap<>();
        for (int i = 0; i + 2 < m; i++) {
            for (int j = 0; j + 2 < n; j++) {
                int sum = checkAndSum(image, threshold, i, j);
                if (sum == -1) continue;
                addMap(sum, i, j, n, mp);
            }
        }

        int[][] ans = new int[m][n];
        for (int i = 0; i < m; i++) {
            System.arraycopy(image[i], 0, ans[i], 0, n);
        }
        for (Map.Entry<Integer, List<Integer>> entry : mp.entrySet()) {
            Integer key = entry.getKey();
            List<Integer> list = entry.getValue();
            int x = key / n, y = key % n;
            int sum = 0;
            for (Integer v : list) {
                sum += v;
            }
            ans[x][y] = sum / list.size();
        }
        return ans;
    }

    private void addMap(int sum, int i, int j, int n, Map<Integer, List<Integer>> mp) {
        int avg = sum / 9;
        for (int x = i; x < i + 3; x++) {
            for (int y = j; y < j + 3; y++) {
                int key = x * n + y;
                mp.computeIfAbsent(key, e -> new ArrayList<>()).add(avg);
            }
        }
    }

    private int checkAndSum(int[][] image, int threshold, int i, int j) {
        int sum = 0;
        for (int x = i; x < i + 3; x++) {
            for (int y = j; y < j + 3; y++) {
                // 上
                if (x > i && Math.abs(image[x - 1][y] - image[x][y]) > threshold) return -1;
                // 左
                if (y > j && Math.abs(image[x][y - 1] - image[x][y]) > threshold) return -1;
                sum += image[x][y];
            }
        }
        return sum;
    }
}
/*
3030. 找出网格的区域平均强度
https://leetcode.cn/problems/find-the-grid-of-region-average/description/

第 383 场周赛 T3。

给你一个下标从 0 开始、大小为 m x n 的网格 image ，表示一个灰度图像，其中 image[i][j] 表示在范围 [0..255] 内的某个像素强度。另给你一个 非负 整数 threshold 。
如果 image[a][b] 和 image[c][d] 满足 |a - c| + |b - d| == 1 ，则称这两个像素是 相邻像素 。
区域 是一个 3 x 3 的子网格，且满足区域中任意两个 相邻 像素之间，像素强度的 绝对差 小于或等于 threshold 。
区域 内的所有像素都认为属于该区域，而一个像素 可以 属于 多个 区域。
你需要计算一个下标从 0 开始、大小为 m x n 的网格 result ，其中 result[i][j] 是 image[i][j] 所属区域的 平均 强度，向下取整 到最接近的整数。如果 image[i][j] 属于多个区域，result[i][j] 是这些区域的 “取整后的平均强度” 的 平均值，也 向下取整 到最接近的整数。如果 image[i][j] 不属于任何区域，则 result[i][j] 等于 image[i][j] 。
返回网格 result 。
提示：
3 <= n, m <= 500
0 <= image[i][j] <= 255
0 <= threshold <= 255

模拟。
时间复杂度 O(mn)。其中常数为 9。
 */