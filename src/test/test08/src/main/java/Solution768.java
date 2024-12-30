import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution768 {
    public int maxChunksToSorted(int[] arr) {
        int n = arr.length;
        int[] sorted = new int[n];
        System.arraycopy(arr, 0, sorted, 0, n);
        Arrays.sort(sorted);
        int ans = 0;
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int x = arr[i], y = sorted[i];
            if (cnt.merge(x, 1, Integer::sum) == 0) cnt.remove(x);
            if (cnt.merge(y, -1, Integer::sum) == 0) cnt.remove(y);
            if (cnt.isEmpty()) {
                ans++;
            }
        }
        return ans;
    }
}
/*
768. 最多能完成排序的块 II
https://leetcode.cn/problems/max-chunks-to-make-sorted-ii/description/

给你一个整数数组 arr 。
将 arr 分割成若干 块 ，并将这些块分别进行排序。之后再连接起来，使得连接的结果和按升序排序后的原数组相同。
返回能将数组分成的最多块数？
提示：
1 <= arr.length <= 2000
0 <= arr[i] <= 10^8

排序 + 哈希表。
时间复杂度 O(nlogn)。
也可以 单调栈？
相似题目: 769. 最多能完成排序的块
https://leetcode.cn/problems/max-chunks-to-make-sorted/
 */