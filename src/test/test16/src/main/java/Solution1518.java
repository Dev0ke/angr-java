public class Solution1518 {
    public int numWaterBottles(int numBottles, int numExchange) {
        // 统计
        int cnt = 0;
        // 空瓶
        int empty = 0;
        while (numBottles > 0) {
            cnt += numBottles;
            empty += numBottles;
            // 换酒
            numBottles = empty / numExchange;
            empty %= numExchange;
        }
        return cnt;
    }
}
/*
1518. 换酒问题
https://leetcode.cn/problems/water-bottles/

第 198 场周赛 T1。

小区便利店正在促销，用 numExchange 个空酒瓶可以兑换一瓶新酒。你购入了 numBottles 瓶酒。
如果喝掉了酒瓶中的酒，那么酒瓶就会变成空的。
请你计算 最多 能喝到多少瓶酒。
提示：
1 <= numBottles <= 100
2 <= numExchange <= 100

递归模拟
 */