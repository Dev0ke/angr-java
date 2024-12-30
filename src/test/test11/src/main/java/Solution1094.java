public class Solution1094 {
    public boolean carPooling(int[][] trips, int capacity) {
        int len = 1000 + 1;
        // 差分数组
        int[] diff = new int[len];
        for (int[] trip : trips) {
            int i = trip[1];
            // 你可以假设乘客会自觉遵守 “先下后上” 的良好素质
            int j = trip[2] - 1;
            int change = trip[0];
            diff[i] += change;
            diff[j + 1] -= change;
        }

        // 还原数组
        int[] res = new int[len];
        res[0] = diff[0];
        for (int i = 1; i < len; i++) {
            res[i] = res[i - 1] + diff[i];
        }
        // 比较最值
        for (int cur : res) {
            if (cur > capacity) {
                return false;
            }
        }
        return true;
    }
}
/*
1094. 拼车
https://leetcode.cn/problems/car-pooling/

第 142 场周赛 T2。

车上最初有 capacity 个空座位。车 只能 向一个方向行驶（也就是说，不允许掉头或改变方向）
给定整数 capacity 和一个数组 trips ,  trip[i] = [numPassengersi, fromi, toi]
表示第 i 次旅行有 numPassengersi 乘客，接他们和放他们的位置分别是 fromi 和 toi 。这些位置是从汽车的初始位置向东的公里数。
当且仅当你可以在所有给定的行程中接送所有乘客时，返回 true，否则请返回 false。
提示：
1 <= trips.length <= 1000
trips[i].length == 3
1 <= numPassengersi <= 100
0 <= fromi < toi <= 1000
1 <= capacity <= 10^5

差分数组
时间复杂度 O(n)
 */