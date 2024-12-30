public class Solution2591 {
    public int distMoney(int money, int children) {
        for (int x = children; x >= 0; x--) {
            int y = children - x;
            if (x * 8 + y > money) continue;
            int sumy = money - x * 8;
            if (y == 0 && sumy > 0) continue;
            if (y == 1 && sumy == 4) continue;
            return x;
        }
        return -1;
    }
}
/*
2591. 将钱分给最多的儿童
https://leetcode.cn/problems/distribute-money-to-maximum-children/

第 100 场双周赛 T1。

给你一个整数 money ，表示你总共有的钱数（单位为美元）和另一个整数 children ，表示你要将钱分配给多少个儿童。
你需要按照如下规则分配：
- 所有的钱都必须被分配。
- 每个儿童至少获得 1 美元。
- 没有人获得 4 美元。
请你按照上述规则分配金钱，并返回 最多 有多少个儿童获得 恰好 8 美元。如果没有任何分配方案，返回 -1 。
提示：
1 <= money <= 200
2 <= children <= 30

贪心 + 分类讨论。
由于数据范围比较小，我们可以直接由大到小枚举`恰好 8 美元`的儿童人数，第一个满足条件的即为答案。
设有 x 个儿童获得恰好 8 美元，则 y 个（y = children-x）儿童至少获得 1 美元且没有人获得 4 美元。有 8x + y <= money；
注意两个例外情况：
当 y = 0 时，但 8x < money 时，"所有的钱都必须被分配" 不成立；
当 y = 1 时，但 8x + 4 = money 时，"没有人获得 4 美元" 不成立；
时间复杂度 O(children)
 */