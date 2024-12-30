public class Solution769 {
    public int maxChunksToSorted(int[] arr) {
        int res = 0;
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
            if (max == i) {
                res++;
            }
        }
        return res;
    }
}
/*
769. 最多能完成排序的块
https://leetcode.cn/problems/max-chunks-to-make-sorted/

给定一个长度为 n 的整数数组 arr ，它表示在 [0, n - 1] 范围内的整数的排列。
我们将 arr 分割成若干 块 (即分区)，并对每个块单独排序。将它们连接起来后，使得连接的结果和按升序排序后的原数组相同。
返回数组能分成的最多块数量。
提示:
n == arr.length
1 <= n <= 10
0 <= arr[i] < n
arr 中每个元素都 不同

贪心。由于 arr 是要给排列（permutation），因此升序后的结果是唯一的，当且只当当前最大值等于其下标时才能进行分块。
考虑数组能分成的最多块数量，直接统计符合要求的下标即可。
时间复杂度 O(n)
空间复杂度 O(1)
相似题目: 768. 最多能完成排序的块 II
https://leetcode.cn/problems/max-chunks-to-make-sorted-ii/description/
 */
