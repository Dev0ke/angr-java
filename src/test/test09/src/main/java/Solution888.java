import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution888 {
    public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
        int aliceSum = Arrays.stream(aliceSizes).sum();
        int bobSum = Arrays.stream(bobSizes).sum();
        int sum = (aliceSum + bobSum) / 2;
        // 总和差值
        int diff = sum - aliceSum;
        Map<Integer, Integer> idxMap = new HashMap<>();
        for (int i = 0; i < bobSizes.length; i++) {
            idxMap.put(bobSizes[i], i);
        }
        int[] ans = new int[2];
        for (int aliceSize : aliceSizes) {
            // 单个差值。类 "两数之和"
            int bobSize = aliceSize + diff;
            if (idxMap.containsKey(bobSize)) {
                ans[0] = aliceSize;
                ans[1] = bobSize;
                return ans;
            }
        }
        return ans;
    }
}
/*
888. 公平的糖果棒交换
https://leetcode.cn/problems/fair-candy-swap/

第 98 场周赛 T1。

爱丽丝和鲍勃拥有不同总数量的糖果。给你两个数组 aliceSizes 和 bobSizes ，aliceSizes[i] 是爱丽丝拥有的第 i 盒糖果中的糖果数量，
bobSizes[j] 是鲍勃拥有的第 j 盒糖果中的糖果数量。
两人想要互相交换一盒糖果，这样在交换之后，他们就可以拥有相同总数量的糖果。一个人拥有的糖果总数量是他们每盒糖果数量的总和。
返回一个整数数组 answer，其中 answer[0] 是爱丽丝必须交换的糖果盒中的糖果的数目，answer[1] 是鲍勃必须交换的糖果盒中的糖果的数目。
如果存在多个答案，你可以返回其中 任何一个 。题目测试用例保证存在与输入对应的答案。
提示：
1 <= aliceSizes.length, bobSizes.length <= 10^4
1 <= aliceSizes[i], bobSizes[j] <= 10^5
爱丽丝和鲍勃的糖果总数量不同。
题目数据保证对于给定的输入至少存在一个有效答案。

类 "两数之和"
 */
