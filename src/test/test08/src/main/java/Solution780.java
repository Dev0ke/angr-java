public class Solution780 {
    public boolean reachingPoints(int sx, int sy, int tx, int ty) {
        while (tx > sx && ty > sy && tx != ty) {
            if (tx > ty) tx %= ty;
            else ty %= tx;
        }
        if (tx == sx && ty == sy) return true;
        if (tx == sx) return ty > sy && (ty - sy) % tx == 0;
        if (ty == sy) return tx > sx && (tx - sx) % ty == 0;
        return false;
    }
}
/*
780. 到达终点
https://leetcode.cn/problems/reaching-points/

给定四个整数 sx , sy ，tx 和 ty，如果通过一系列的转换可以从起点 (sx, sy) 到达终点 (tx, ty)，则返回 true，否则返回 false。
从点 (x, y) 可以转换到 (x, x+y)  或者 (x+y, y)。
提示:
1 <= sx, sy, tx, ty <= 10^9

逆向操作
从点 (x, y) 可以转换到 (x, x+y)  或者 (x+y, y)。
即 点 (x, y) 恢复到 (x, y-x)  或者 (x-y, y)。由于点为正整数，因此只有一种逆向可能。
时间复杂度 O(logn)
空间复杂度 O(1)
 */