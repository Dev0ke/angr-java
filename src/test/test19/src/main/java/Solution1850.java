public class Solution1850 {
    public int getMinSwaps(String num, int k) {
        int n = num.length();

        int[] a = new int[n];
        int[] a_k = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = num.charAt(i) - '0';
            a_k[i] = num.charAt(i) - '0';
        }
        for (int i = 0; i < k; i++) nextPermutation(a_k);

        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (a[i] == a_k[i]) continue;
            for (int j = i + 1; j < n; j++) {
                if (a[j] != a_k[i]) continue;
                for (int c = j - 1; c >= i; c--) {
                    ans++;
                    // swap
                    int tmp = a[c];
                    a[c] = a[c + 1];
                    a[c + 1] = tmp;
                }
                break;
            }
        }
        return ans;
    }

    // solution 31
    private void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[i] >= nums[j]) {
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1);
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    private void reverse(int[] nums, int start) {
        int right = nums.length - 1;
        while (start < right) {
            swap(nums, start, right);
            start++;
            right--;
        }
    }
}
/*
1850. 邻位交换的最小次数
https://leetcode.cn/problems/minimum-adjacent-swaps-to-reach-the-kth-smallest-number/description/

给你一个表示大整数的字符串 num ，和一个整数 k 。
如果某个整数是 num 中各位数字的一个 排列 且它的 值大于 num ，则称这个整数为 妙数 。可能存在很多妙数，但是只需要关注 值最小 的那些。
- 例如，num = "5489355142" ：
  - 第 1 个最小妙数是 "5489355214"
  - 第 2 个最小妙数是 "5489355241"
  - 第 3 个最小妙数是 "5489355412"
  - 第 4 个最小妙数是 "5489355421"
返回要得到第 k 个 最小妙数 需要对 num 执行的 相邻位数字交换的最小次数 。
测试用例是按存在第 k 个最小妙数而生成的。
提示：
2 <= num.length <= 1000
1 <= k <= 1000
num 仅由数字组成

第一步我们需要求出比 num 大的第 k 个排列 num_k。
第二步我们需要将 num 通过交换操作得到 num_k，每一步交换操作只能交换相邻的两个字符。
时间复杂度 O(n * (n + k))。
 */