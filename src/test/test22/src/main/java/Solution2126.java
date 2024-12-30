import java.util.Arrays;

public class Solution2126 {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        Arrays.sort(asteroids);
        long sum = mass;
        for (int asteroid : asteroids) {
            if (sum < asteroid) {
                return false;
            } else {
                sum += asteroid;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution2126().asteroidsDestroyed(375, new int[]{5, 6, 24246, 51305, 87775, 12816}));
    }
}
/*
2126. 摧毁小行星
https://leetcode.cn/problems/destroying-asteroids/

第 274 场周赛 T3。

给你一个整数 mass ，它表示一颗行星的初始质量。再给你一个整数数组 asteroids ，其中 asteroids[i] 是第 i 颗小行星的质量。
你可以按 任意顺序 重新安排小行星的顺序，然后让行星跟它们发生碰撞。如果行星碰撞时的质量 大于等于 小行星的质量，那么小行星被 摧毁 ，
并且行星会 获得 这颗小行星的质量。否则，行星将被摧毁。
如果所有小行星 都 能被摧毁，请返回 true ，否则返回 false 。

贪心。第一眼写成 mass 与前 n-1 项的和是否大于第 n 项，WA 了。老老实实逐项累加比较即可。
 */