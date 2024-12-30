public class SolutionP302 {
    // O(mn)
    static class V1 {
        public int minArea(char[][] image, int x, int y) {
            int top = x, bottom = x;
            int left = y, right = y;
            for (x = 0; x < image.length; ++x) {
                for (y = 0; y < image[0].length; ++y) {
                    if (image[x][y] == '1') {
                        top = Math.min(top, x);
                        bottom = Math.max(bottom, x + 1);
                        left = Math.min(left, y);
                        right = Math.max(right, y + 1);
                    }
                }
            }
            return (right - left) * (bottom - top);
        }
    }

    // O(mlogn + nlogm)
    static class V2 {
        char[][] image;

        public int minArea(char[][] image, int x, int y) {
            this.image = image;
            int m = image.length, n = image[0].length;
            int left = searchColumns(0, y, 0, m, true);
            int right = searchColumns(y + 1, n, 0, m, false);
            int top = searchRows(0, x, left, right, true);
            int bottom = searchRows(x + 1, m, left, right, false);
            return (right - left) * (bottom - top);
        }

        private int searchColumns(int i, int j, int top, int bottom, boolean whiteToBlack) {
            while (i != j) {
                int k = top, mid = (i + j) / 2;
                while (k < bottom && image[k][mid] == '0') ++k;
                if (k < bottom == whiteToBlack) { // k < bottom 意味着 mid 列中有黑色像素
                    j = mid; // 在较小的一半中搜索边界
                } else {
                    i = mid + 1; // 在较大的一半中搜索边界
                }
            }
            return i;
        }

        private int searchRows(int i, int j, int left, int right, boolean whiteToBlack) {
            while (i != j) {
                int k = left, mid = (i + j) / 2;
                while (k < right && image[mid][k] == '0') ++k;
                if (k < right == whiteToBlack) { // k < right means 意味着 mid 行中有黑色像素
                    j = mid;
                } else {
                    i = mid + 1;
                }
            }
            return i;
        }
    }
}
/*
$302. 包含全部黑色像素的最小矩形
https://leetcode.cn/problems/smallest-rectangle-enclosing-black-pixels/description/

图片在计算机处理中往往是使用二维矩阵来表示的。
给你一个大小为 m x n 的二进制矩阵 image 表示一张黑白图片，0 代表白色像素，1 代表黑色像素。
黑色像素相互连接，也就是说，图片中只会有一片连在一块儿的黑色像素。像素点是水平或竖直方向连接的。
给你两个整数 x 和 y 表示某一个黑色像素的位置，请你找出包含全部黑色像素的最小矩形（与坐标轴对齐），并返回该矩形的面积。
你必须设计并实现一个时间复杂度低于 O(mn) 的算法来解决此问题。
提示：
m == image.length
n == image[i].length
1 <= m, n <= 100
image[i][j] 为 '0' 或 '1'
1 <= x < m
1 <= y < n
image[x][y] == '1'
image 中的黑色像素仅形成一个 组件

线性搜索 / 二分查找。
 */