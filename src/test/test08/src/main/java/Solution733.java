import java.util.LinkedList;
import java.util.Queue;

public class Solution733 {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int oldColor = image[sr][sc];
        if (oldColor == newColor) {
            return image;
        }

        // BFS
        int M = image.length;
        int N = image[0].length;
        int[][] directions = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{sr, sc});

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cur = queue.remove();
                int curM = cur[0];
                int curN = cur[1];
                image[curM][curN] = newColor;

                for (int[] dir : directions) {
                    int nextM = curM + dir[0];
                    int nextN = curN + dir[1];
                    if (nextM >= 0 && nextM < M && nextN >= 0 && nextN < N && image[nextM][nextN] == oldColor) {
                        queue.add(new int[]{nextM, nextN});
                    }
                }
            }
        }
        return image;
    }
}
/*
733. 图像渲染
https://leetcode.cn/problems/flood-fill/

有一幅以二维整数数组表示的图画，每一个整数表示该图画的像素值大小，数值在 0 到 65535 之间。
给你一个坐标 (sr, sc) 表示图像渲染开始的像素值（行 ，列）和一个新的颜色值 newColor，让你重新上色这幅图像。
为了完成上色工作，从初始坐标开始，记录初始坐标的上下左右四个方向上像素值与初始坐标相同的相连像素点，
接着再记录这四个方向上符合条件的像素点与他们对应四个方向上像素值与初始坐标相同的相连像素点，……，重复该过程。将所有有记录的像素点的颜色值改为新的颜色值。
最后返回经过上色渲染后的图像。
注意:
image 和 image[0] 的长度在范围 [1, 50] 内。
给出的初始点将满足 0 <= sr < image.length 和 0 <= sc < image[0].length。
image[i][j] 和 newColor 表示的颜色值在范围 [0, 65535]内。

BFS 模拟。
 */