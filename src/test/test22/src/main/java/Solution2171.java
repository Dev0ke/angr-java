import java.util.Arrays;

public class Solution2171 {
    public long minimumRemoval(int[] beans) {
        int len = beans.length;

        Arrays.sort(beans);
        long sum = 0L;
        for (int bean : beans) {
            sum += bean;
        }

        long min = Long.MAX_VALUE;
        for (int i = 0; i < len; i++) {
            // 魔法豆相等的值
            long target = beans[i];
            // 剩余的魔法豆
            long remain = target * (len - i);
            // 需要拿出魔法豆的数目
            long remove = sum - remain;
            min = Math.min(min, remove);
        }
        return min;
    }
}
/*
2171. 拿出最少数目的魔法豆
https://leetcode.cn/problems/removing-minimum-number-of-magic-beans/

第 280 场周赛 T3。

给你一个 正 整数数组 beans ，其中每个整数表示一个袋子里装的魔法豆的数目。
请你从每个袋子中 拿出 一些豆子（也可以 不拿出），使得剩下的 非空 袋子中（即 至少 还有 一颗 魔法豆的袋子）魔法豆的数目 相等 。一旦魔法豆从袋子中取出，你不能将它放到任何其他的袋子中。
请你返回你需要拿出魔法豆的 最少数目。

排序前可能没啥思路，但排序后一目了然。遍历求移除数最小值即可。
时间复杂度 O(nlogn) 为排序的时间复杂度。
 */