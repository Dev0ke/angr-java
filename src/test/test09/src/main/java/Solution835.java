public class Solution835 {
    public int largestOverlap(int[][] img1, int[][] img2) {
        int n = img1.length;

        int ans = 0;
        int[][] cnt = new int[n * 2 + 1][n * 2 + 1];
        for (int i1 = 0; i1 < n; i1++) {
            for (int j1 = 0; j1 < n; j1++) {
                if (img1[i1][j1] != 1) continue;

                for (int i2 = 0; i2 < n; i2++) {
                    for (int j2 = 0; j2 < n; j2++) {
                        if (img2[i2][j2] != 1) continue;

                        cnt[i1 - i2 + n][j1 - j2 + n]++;
                        ans = Math.max(ans, cnt[i1 - i2 + n][j1 - j2 + n]);
                    }
                }
            }
        }
        return ans;
    }
}
/*
835. 图像重叠
https://leetcode.cn/problems/image-overlap/description/

给你两个图像 img1 和 img2 ，两个图像的大小都是 n x n ，用大小相同的二进制正方形矩阵表示。二进制矩阵仅由若干 0 和若干 1 组成。
转换 其中一个图像，将所有的 1 向左，右，上，或下滑动任何数量的单位；然后把它放在另一个图像的上面。该转换的 重叠 是指两个图像 都 具有 1 的位置的数目。
请注意，转换 不包括 向任何方向旋转。越过矩阵边界的 1 都将被清除。
最大可能的重叠数量是多少？
提示：
n == img1.length == img1[i].length
n == img2.length == img2[i].length
1 <= n <= 30
img1[i][j] 为 0 或 1
img2[i][j] 为 0 或 1

枚举。
时间复杂度 O(n^4)。
据说还有 基于 FFT 的 O(n^2 logn) 解法：
https://leetcode.cn/problems/image-overlap/solutions/527350/ni-ke-neng-wu-fa-xiang-xiang-de-on2lognd-gc5j/
 */