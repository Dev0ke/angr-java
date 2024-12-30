public class SolutionP531 {
    public int findLonelyPixel(char[][] picture) {
        int m = picture.length;
        int n = picture[0].length;

        // 预处理
        int[] rows = new int[m];
        int[] cols = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (picture[i][j] == 'B') {
                    rows[i]++;
                    cols[j]++;
                }
            }
        }

        int cnt = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (picture[i][j] == 'B' && rows[i] == 1 && cols[j] == 1) {
                    cnt++;
                }
            }
        }
        return cnt;
    }
}
/*
$531. 孤独像素 I
https://leetcode.cn/problems/lonely-pixel-i/

给你一个大小为 m x n 的图像 picture ，图像由黑白像素组成，'B' 表示黑色像素，'W' 表示白色像素，请你统计并返回图像中 黑色 孤独像素的数量。
黑色孤独像素 的定义为：如果黑色像素 'B' 所在的同一行和同一列不存在其他黑色像素，那么这个黑色像素就是黑色孤独像素。
提示：
m == picture.length
n == picture[i].length
1 <= m, n <= 500
picture[i][j] 为 'W' 或 'B'

预处理后统计
时间复杂度 O(mn)
空间复杂度 O(m + n)
 */