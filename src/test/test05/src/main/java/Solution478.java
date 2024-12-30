import java.util.Random;

public class Solution478 {
    static class Solution {
        private final Random random;
        private final double radius;
        private final double xCenter;
        private final double yCenter;
        private final double size;

        public Solution(double radius, double x_center, double y_center) {
            this.radius = radius;
            this.xCenter = x_center;
            this.yCenter = y_center;
            size = Math.PI * radius * radius;
            random = new Random();
        }

        public double[] randPoint() {
            while (true) {
                double x = random.nextDouble() * (2 * radius) - radius;
                double y = random.nextDouble() * (2 * radius) - radius;
                if (x * x + y * y <= radius * radius) {
                    return new double[]{xCenter + x, yCenter + y};
                }
            }
        }

        public double[] randPoint2() {
            double theta = random.nextDouble() * 2 * Math.PI, r = Math.sqrt(random.nextDouble() * size / Math.PI);
            return new double[]{xCenter + Math.cos(theta) * r, yCenter + Math.sin(theta) * r};
        }
    }
}
/*
478. 在圆内随机生成点
https://leetcode.cn/problems/generate-random-point-in-a-circle/

给定圆的半径和圆心的位置，实现函数 randPoint ，在圆中产生均匀随机点。
实现 Solution 类:
- Solution(double radius, double x_center, double y_center) 用圆的半径 radius 和圆心的位置 (x_center, y_center) 初始化对象
- randPoint() 返回圆内的一个随机点。圆周上的一点被认为在圆内。答案作为数组返回 [x, y] 。
提示：
0 < radius <= 10^8
-10^7 <= x_center, y_center <= 10^7
randPoint 最多被调用 3 * 10^4 次

拒绝采样。
取以2倍radius为边长的正方形内的点，如果其在圆内，则返回。
时间复杂度 O(1)
注意不能用 随机半径 + 随机极角 去生成。（因为这样生成的点并不是均匀的）
 */