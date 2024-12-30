import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution2561 {
    public long minCost(int[] basket1, int[] basket2) {
        int n = basket1.length;
        Map<Integer, Integer> cntMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            cntMap.put(basket1[i], cntMap.getOrDefault(basket1[i], 0) + 1);
            cntMap.put(basket2[i], cntMap.getOrDefault(basket2[i], 0) - 1);
        }

        int min = Integer.MAX_VALUE;
        List<Integer> list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : cntMap.entrySet()) {
            int x = entry.getKey();
            int c = Math.abs(entry.getValue());
            if (c % 2 == 1) {
                return -1;
            }
            min = Math.min(min, x);
            for (int i = 0; i < c / 2; i++) {
                list.add(x);
            }
        }

        long res = 0;
        Collections.sort(list);
        for (int i = 0; i < list.size() / 2; i++) {
            res += Math.min(list.get(i), min * 2);
        }
        return res;
    }
}
/*
2561. 重排水果
https://leetcode.cn/problems/rearranging-fruits/

第 331 场周赛 T4。

你有两个果篮，每个果篮中有 n 个水果。给你两个下标从 0 开始的整数数组 basket1 和 basket2 ，用以表示两个果篮中每个水果的成本。
你希望两个果篮相等。为此，可以根据需要多次执行下述操作：
- 选中两个下标 i 和 j ，并交换 basket1 中的第 i 个水果和 basket2 中的第 j 个水果。
- 交换的成本是 min(basket1i,basket2j) 。
根据果篮中水果的成本进行排序，如果排序后结果完全相同，则认为两个果篮相等。
返回使两个果篮相等的最小交换成本，如果无法使两个果篮相等，则返回 -1 。
提示：
basket1.length == bakste2.length
1 <= basket1.length <= 10^5
1 <= basket1i,basket2i <= 10^9

构造题/思维题
除了两两配对互换外，还可以借助值最小的 交换两次 达到同样目的。
 */