import java.util.HashMap;
import java.util.Map;

public class Solution149 {
    public int maxPoints(int[][] points) {
        int len = points.length;
        if (len <= 2) {
            return len;
        }
        int res = 0;
        for (int i = 0; i < len; i++) {
            if (res >= len - 1 || res > len / 2) {
                break;
            }
            Map<String, Integer> hashMap = new HashMap<>();
            for (int j = i + 1; j < len; j++) {
                int x = points[i][0] - points[j][0];
                int y = points[i][1] - points[j][1];
                if (x == 0) {
                    y = 1;
                } else if (y == 0) {
                    x = 1;
                } else {
                    if (y < 0) {
                        x = -x;
                        y = -y;
                    }
                    int gcdXy = getGCD(Math.abs(x), Math.abs(y));
                    x /= gcdXy;
                    y /= gcdXy;
                }
                String key = x + "-" + y;
                hashMap.put(key, hashMap.getOrDefault(key, 0) + 1);
            }
            int max = 0;
            for (Map.Entry<String, Integer> entry : hashMap.entrySet()) {
                int num = entry.getValue();
                max = Math.max(max, num + 1);
            }
            res = Math.max(res, max);
        }
        return res;
    }

    private int getGCD(int num1, int num2) {
        if (num1 == 0) {
            return num2;
        }
        return getGCD(num2 % num1, num1);
    }
}
/*
149. 直线上最多的点数
https://leetcode.cn/problems/max-points-on-a-line/

给你一个数组 points ，其中 points[i] = [xi, yi] 表示 X-Y 平面上的一个点。求最多有多少个点在同一条直线上。
提示：
1 <= points.length <= 300
points[i].length == 2
-10^4 <= xi, yi <= 10^4
points 中的所有点 互不相同

每两个点枚举斜率，HashMap 统计。
 */