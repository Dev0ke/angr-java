import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Solution826 {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int n = difficulty.length;
        // [difficultyi, profiti]
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new int[]{difficulty[i], profit[i]});
        }
        list.sort(Comparator.comparingInt(o -> o[0]));
        for (int i = 1; i < n; i++) {
            int[] pre = list.get(i - 1);
            int[] cur = list.get(i);
            cur[1] = Math.max(pre[1], cur[1]);
        }

        int sum = 0;
        for (int i : worker) {
            int left = 0;
            int right = n;
            while (left < right) {
                int mid = left + (right - left) / 2;
                // 边界二分 F, F,..., F, [T, T,..., T]
                // ----------------------^
                // 工人能完成的工作 TTTFFF 不能完成 FFFTTT
                if (list.get(mid)[0] > i) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            if (left - 1 >= 0) {
                sum += list.get(left - 1)[1];
            }
        }
        return sum;
    }
}
/*
826. 安排工作以达到最大收益
https://leetcode.cn/problems/most-profit-assigning-work/

你有 n 个工作和 m 个工人。给定三个数组： difficulty, profit 和 worker ，其中:
- difficulty[i] 表示第 i 个工作的难度，profit[i] 表示第 i 个工作的收益。
- worker[i] 是第 i 个工人的能力，即该工人只能完成难度小于等于 worker[i] 的工作。
每个工人 最多 只能安排 一个 工作，但是一个工作可以 完成多次 。
- 举个例子，如果 3 个工人都尝试完成一份报酬为 $1 的同样工作，那么总收益为 $3 。如果一个工人不能完成任何工作，他的收益为 $0 。
返回 在把工人分配到工作岗位后，我们所能获得的最大利润 。
提示:
n == difficulty.length
n == profit.length
m == worker.length
1 <= n, m <= 10^4
1 <= difficulty[i], profit[i], worker[i] <= 10^5

按 difficulty 升序排列，profit 取所有能满足 difficulty 的最大值。
再根据每个工人，二分找出能完成 difficulty 的工作。
时间复杂度 O(nlogn)
 */