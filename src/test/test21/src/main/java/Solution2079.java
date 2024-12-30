public class Solution2079 {
    public int wateringPlants(int[] plants, int capacity) {
        int len = plants.length;
        int cnt = 0;
        int curCapacity = capacity;
        curCapacity -= plants[0];
        cnt++;
        for (int i = 1; i < len; ) {
            if (curCapacity >= plants[i]) {
                curCapacity -= plants[i];
                cnt++;
                i++;
            } else {
                cnt += i + i;
                curCapacity = capacity;
            }
        }
        return cnt;
    }
}
/*
2079. 给植物浇水
https://leetcode.cn/problems/watering-plants/

第 268 场周赛 T2。

你打算用一个水罐给花园里的 n 株植物浇水。植物排成一行，从左到右进行标记，编号从 0 到 n - 1 。其中，
第 i 株植物的位置是 x = i 。x = -1 处有一条河，你可以在那里重新灌满你的水罐。
每一株植物都需要浇特定量的水。你将会按下面描述的方式完成浇水：
按从左到右的顺序给植物浇水。
在给当前植物浇完水之后，如果你没有足够的水 完全 浇灌下一株植物，那么你就需要返回河边重新装满水罐。
你 不能 提前重新灌满水罐。
最初，你在河边（也就是，x = -1），在 x 轴上每移动 一个单位 都需要 一步 。
给你一个下标从 0 开始的整数数组 plants ，数组由 n 个整数组成。其中，plants[i] 为第 i 株植物需要的水量。
另有一个整数 capacity 表示水罐的容量，返回浇灌所有植物需要的 步数 。
提示：
n == plants.length
1 <= n <= 1000
1 <= plants[i] <= 10^6
max(plants[i]) <= capacity <= 10^9

看到数据范围 n <= 1000，模拟即可。
 */