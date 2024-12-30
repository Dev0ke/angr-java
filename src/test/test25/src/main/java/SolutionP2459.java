public class SolutionP2459 {
    public int sortArray(int[] nums) {
        int n = nums.length;
        int[] newNums = new int[n];
        for (int i = 0; i < n; i++) {
            newNums[i] = (nums[i] - 1 + n) % n; // Ensure non-negative result
        }
        return Math.min(f(nums, 0), f(newNums, n - 1));
    }

    private int f(int[] nums, int z) {
        boolean[] vis = new boolean[nums.length];
        int cir = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i == nums[i] || vis[i]) {
                continue;
            }
            cir++;
            int j = i;
            while (!vis[j]) {
                vis[j] = true;
                cir++;
                j = nums[j];
            }
        }
        return cir - 2 * (nums[z] != z ? 1 : 0);
    }
}
/*
$2459. 通过移动项目到空白区域来排序数组
https://leetcode.cn/problems/sort-array-by-moving-items-to-empty-space/description/

给定一个大小为 n 的整数数组 nums，其中包含从 0 到 n - 1 (包含边界) 的 每个 元素。从 1 到 n - 1 的每一个元素都代表一项目，元素 0 代表一个空白区域。
在一个操作中，您可以将 任何 项目移动到空白区域。如果所有项目的编号都是 升序 的，并且空格在数组的开头或结尾，则认为 nums 已排序。
例如，如果 n = 4，则 nums 按以下条件排序:
- nums = [0,1,2,3] 或
- nums = [1,2,3,0]
...否则被认为是无序的。
返回排序 nums 所需的最小操作数。
提示:
n == nums.length
2 <= n <= 10^5
0 <= nums[i] < n
nums 的所有值都是 唯一 的。

https://leetcode.cn/problems/sort-array-by-moving-items-to-empty-space/solutions/1941567/by-424479543-76m8/
比如[4,2,0,3,1]，3在原地不用换，4201成环。
每个长度为m的环，如果0在环中，则交换次数是m-1,否则交换次数是m+1。
1.先全部按m+1算，则交换总次数为 错位元素数+环数。
2.再看0是否错位，如果0错位，则0在某一环中，该环的交换次数由m+1变成m-1。
 */