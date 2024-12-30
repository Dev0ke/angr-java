public class SolutionP2422 {
    public int minimumOperations(int[] nums) {
        int n = nums.length;
        int ans = 0;
        int i = 0, j = n - 1;
        long pre = nums[0], suf = nums[n - 1];
        while (i < j) {
            if (pre < suf) {
                i++;
                pre += nums[i];
                ans++;
            } else if (pre > suf) {
                j--;
                suf += nums[j];
                ans++;
            } else {
                i++;
                j--;
                pre = nums[i];
                suf = nums[j];
            }
        }
        return ans;
    }
}
/*
$2422. 使用合并操作将数组转换为回文序列
https://leetcode.cn/problems/merge-operations-to-turn-array-into-a-palindrome/description/

给定一个由 正整数 组成的数组 nums。
可以对阵列执行如下操作，次数不限:
- 选择任意两个 相邻 的元素并用它们的 和 替换 它们。
  - 例如，如果 nums = [1,2,3,1]，则可以应用一个操作使其变为 [1,5,1]。
返回将数组转换为 回文序列 所需的 最小 操作数。
提示:
1 <= nums.length <= 10^5
1 <= nums[i] <= 10^6

由于最终要形成回文数组，可考虑贪心地让数组两头的元素尽快相等
操作的关键词：
相邻：使用双指针，一前一后，向中间遍历
求和：新的元素只能增大，故可根据前后元素的大小比较，决定是哪一边进行求和操作
https://leetcode.cn/problems/merge-operations-to-turn-array-into-a-palindrome/solutions/1857128/-by-steven2018-phdz/
 */