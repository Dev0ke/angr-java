import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution2274 {
    public int maxConsecutive(int bottom, int top, int[] special) {
        List<Integer> list = new ArrayList<>();
        list.add(bottom - 1);
        list.add(top + 1);
        for (int i : special) {
            list.add(i);
        }

        Collections.sort(list);

        int max = 0;
        int size = list.size();
        for (int i = 1; i < size; i++) {
            int diff = list.get(i) - list.get(i - 1) - 1;
            max = Math.max(max, diff);
        }
        return max;
    }
}
/*
2274. 不含特殊楼层的最大连续楼层数
https://leetcode.cn/problems/maximum-consecutive-floors-without-special-floors/

第 293 场周赛 T2。

Alice 管理着一家公司，并租用大楼的部分楼层作为办公空间。Alice 决定将一些楼层作为 特殊楼层 ，仅用于放松。
给你两个整数 bottom 和 top ，表示 Alice 租用了从 bottom 到 top（含 bottom 和 top 在内）的所有楼层。另给你一个整数数组 special ，
其中 special[i] 表示 Alice 指定用于放松的特殊楼层。
返回不含特殊楼层的 最大 连续楼层数。
提示
1 <= special.length <= 10^5
1 <= bottom <= special[i] <= top <= 10^9
special 中的所有值 互不相同

排序后 遍历即可。
 */