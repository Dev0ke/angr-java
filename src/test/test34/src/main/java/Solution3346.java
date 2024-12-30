import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution3346 {
    // 赛时代码
    public int maxFrequency(int[] nums, int k, int numOperations) {
        int n = nums.length;
        Arrays.sort(nums);
        int l = 0, r = 0;
        int mx = 0;
        int maxD = k * Math.min(2, numOperations);
        while (r < n) {
            while (nums[r] - nums[l] > maxD) {
                l++;
            }
            mx = Math.max(mx, r - l + 1);
            r++;
        }

        Map<Integer, Integer> cnt = new HashMap<>();
        for (int v : nums) {
            cnt.merge(v, 1, Integer::sum);
        }

        List<Node> arr = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : cnt.entrySet()) {
            arr.add(new Node(entry.getKey(), entry.getValue()));
        }
        arr.sort(Comparator.comparingInt(o -> o.val));
        int sz = arr.size();
        int[] ps = new int[sz + 1];
        for (int i = 0; i < sz; i++) {
            ps[i + 1] = ps[i] + arr.get(i).cnt;
        }

        int[] L = new int[sz];
        int pre = 0;
        for (int i = 0; i < sz; i++) {
            while (arr.get(i).val - arr.get(pre).val > k) {
                pre++;
            }
            L[i] = pre;
        }

        int[] R = new int[sz];
        int suf = 0;
        for (int i = 0; i < sz; i++) {
            while (suf < sz && arr.get(suf).val - arr.get(i).val <= k) {
                suf++;
            }
            R[i] = suf - 1;
        }

        int ans = Math.min(mx, numOperations);
        for (int i = 0; i < sz; i++) {
            int lo = ps[i] - ps[L[i]];
            int hi = ps[R[i] + 1] - ps[i + 1];
            int res = arr.get(i).cnt + Math.min(numOperations, lo + hi);
            ans = Math.max(ans, res);
        }
        return ans;
    }

    static class Node {
        int val, cnt;

        public Node(int val, int cnt) {
            this.val = val;
            this.cnt = cnt;
        }
    }
}
/*
3346. 执行操作后元素的最高频率 I
https://leetcode.cn/problems/maximum-frequency-of-an-element-after-performing-operations-i/description/

第 143 场双周赛 T2。

给你一个整数数组 nums 和两个整数 k 和 numOperations 。
你必须对 nums 执行 操作  numOperations 次。每次操作中，你可以：
- 选择一个下标 i ，它在之前的操作中 没有 被选择过。
- 将 nums[i] 增加范围 [-k, k] 中的一个整数。
在执行完所有操作以后，请你返回 nums 中出现 频率最高 元素的出现次数。
一个元素 x 的 频率 指的是它在数组中出现的次数。
提示：
1 <= nums.length <= 10^5
1 <= nums[i] <= 10^5
0 <= k <= 10^5
0 <= numOperations <= nums.length

分类讨论。两种情况：变成 nums[i] 或者 不变成 nums[i]。
同: 3347. 执行操作后元素的最高频率 II
https://leetcode.cn/problems/maximum-frequency-of-an-element-after-performing-operations-ii/description/
 */