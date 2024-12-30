public class SolutionP3247 {
    static final int MOD = (int) (1e9 + 7);

    public int subsequenceCount(int[] nums) {
        long a = 1, b = 0;
        for (int v : nums) {
            if (v % 2 == 1) {
                a = b = (a + b) % MOD;
            } else {
                a = (a + a) % MOD;
                b = (b + b) % MOD;
            }
        }
        return (int) b;
    }
}
/*
$3247. 奇数和子序列的数量
https://leetcode.cn/problems/number-of-subsequences-with-odd-sum/description/

给定一个数组 nums，返回元素和为奇数的 子序列 的数量。
由于答案可能很大，返回答案对 10^9 + 7 取模。
提示：
1 <= nums.length <= 10^5
1 <= nums[i] <= 10^9

设a为直到当前的所有和为偶数的子序列数量，b为和为奇数的数量，则初始有空子序列a为1，b为0。
遍历nums。
当遍历到i时，am/bm表示必须以i为结尾的和为偶数/奇数的子序列数量，则当i为奇数时，偶数和子序列加上i为结尾变成奇数和子序列，反之亦然，即am = b, bm = a；同理当i为偶数时am = a, bm = b。此时a/b加上am/bm更新为新的a/b。
遍历结束后，去掉空子序列(a-=1，但本题只考虑奇数和，所以不影响），返回b即可。
https://leetcode.cn/problems/number-of-subsequences-with-odd-sum/solutions/2874131/dong-tai-gui-hua-5xing-ji-jian-1003247-q-4u6r/
 */