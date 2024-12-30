import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution1431 {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> resList = new ArrayList<>();
        int max = Arrays.stream(candies).max().orElseThrow();
        for (int candy : candies) {
            if (candy + extraCandies >= max) {
                resList.add(true);
            } else {
                resList.add(false);
            }
        }
        return resList;
    }
}
/*
1431. 拥有最多糖果的孩子
https://leetcode.cn/problems/kids-with-the-greatest-number-of-candies/

第 25 场双周赛 T1。

给你一个数组 candies 和一个整数 extraCandies ，其中 candies[i] 代表第 i 个孩子拥有的糖果数目。
对每一个孩子，检查是否存在一种方案，将额外的 extraCandies 个糖果分配给孩子们之后，此孩子有 最多 的糖果。
注意，允许有多个孩子同时拥有 最多 的糖果数目。
提示：
2 <= candies.length <= 100
1 <= candies[i] <= 100
1 <= extraCandies <= 50

取出最大值，逐个比较即可。
时间复杂度 O(n)
 */