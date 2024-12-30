public class Solution858 {
    public int mirrorReflection(int p, int q) {
        int g = getGCD(p, q);
        p = p / g % 2;
        q = q / g % 2;
        if (p == 1 && q == 1) return 1;
        return p == 1 ? 0 : 2;
    }

    private int getGCD(int num1, int num2) {
        return num1 == 0 ? num2 : getGCD(num2 % num1, num1);
    }
}
/*
858. 镜面反射
https://leetcode.cn/problems/mirror-reflection/description/

有一个特殊的正方形房间，每面墙上都有一面镜子。除西南角以外，每个角落都放有一个接受器，编号为 0， 1，以及 2。
正方形房间的墙壁长度为 p，一束激光从西南角射出，首先会与东墙相遇，入射点到接收器 0 的距离为 q 。
返回光线最先遇到的接收器的编号（保证光线最终会遇到一个接收器）。
提示：
1 <= q <= p <= 1000

数学。
光会反射吗？那我们假设光不反射好了。
3-0-3-0
| | | |
2-1-2-1
| | | |
3-0-3-0
时间复杂度 O(logP)。为求出最大公约数的时间复杂度。
 */