import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class Solution1338 {
    public int minSetSize(int[] arr) {
        Map<Integer, Integer> cntMap = new HashMap<>();
        for (int v : arr) cntMap.merge(v, 1, Integer::sum);
        List<Integer> occ = new ArrayList<>(cntMap.values());
        occ.sort(Comparator.reverseOrder());

        int cnt = 0, ans = 0;
        for (int c : occ) {
            cnt += c;
            ans++;
            if (cnt * 2 >= arr.length) {
                break;
            }
        }
        return ans;
    }
}
/*
1338. 数组大小减半
https://leetcode.cn/problems/reduce-array-size-to-the-half/

第 174 场周赛 T2。

给你一个整数数组 arr。你可以从中选出一个整数集合，并删除这些整数在数组中的每次出现。
返回 至少 能删除数组中的一半整数的整数集合的最小大小。
提示：
1 <= arr.length <= 10^5
arr.length 为偶数
1 <= arr[i] <= 10^5

统计各数值频次，贪心法，从最大频次开始统计至半数即可。
 */