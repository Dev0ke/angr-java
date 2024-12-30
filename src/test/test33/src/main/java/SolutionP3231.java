import java.util.ArrayList;
import java.util.List;

public class SolutionP3231 {
    static class V1 {
        public int minOperations(int[] nums) {
            List<Integer> sub = new ArrayList<>();
            for (int i = nums.length - 1; i >= 0; --i) {
                int x = nums[i];
                if (sub.isEmpty() || sub.get(sub.size() - 1) <= x) {
                    sub.add(x);
                } else {
                    int it = upperBound(sub, x);
                    sub.set(it, x);
                }
            }
            return sub.size();
        }

        private int upperBound(List<Integer> a, int key) {
            int l = 0, r = a.size();
            while (l < r) {
                int m = l + (r - l) / 2;
                if (a.get(m) > key) r = m;
                else l = m + 1;
            }
            return l;
        }
    }

    static class V2 {
        public int minOperations(int[] nums) {
            List<Integer> a = new ArrayList<>();
            for (int i = nums.length - 1; i >= 0; --i) {
                int x = nums[i];
                int j = upperBound(a, x);
                if (j == a.size()) a.add(x);
                else a.set(j, x);
            }
            return a.size();
        }

        private int upperBound(List<Integer> a, int key) {
            int l = 0, r = a.size();
            while (l < r) {
                int m = l + (r - l) / 2;
                if (a.get(m) > key) r = m;
                else l = m + 1;
            }
            return l;
        }
    }
}
/*
$3231. 要删除的递增子序列的最小数量
https://leetcode.cn/problems/minimum-number-of-increasing-subsequence-to-be-removed/description/

给定一个整数数组 nums，你可以执行任意次下面的操作：
- 从数组删除一个 严格递增 的 子序列。
您的任务是找到使数组为 空 所需的 最小 操作数。
提示：
1 <= nums.length <= 10^5
1 <= nums[i] <= 10^5

类似LIS的概念，注意修改等号部分即可
相似题目: 300. 最长递增子序列
https://leetcode.cn/problems/longest-increasing-subsequence/
 */