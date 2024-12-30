import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.IntStream;

public class Solution870 {
    public int[] advantageCount(int[] nums1, int[] nums2) {
        int n = nums1.length;
        Arrays.sort(nums1);
        Integer[] id2 = IntStream.range(0, n).boxed().toArray(Integer[]::new);
        Arrays.sort(id2, Comparator.comparingInt(o -> nums2[o]));

        int[] res = new int[n];
        int l = 0, r = n - 1;
        for (int n1 : nums1) {
            if (n1 > nums2[id2[l]]) {
                res[id2[l]] = n1;
                l++;
            } else {
                res[id2[r]] = n1;
                r--;
            }
        }
        return res;
    }
}
/*
870. 优势洗牌
https://leetcode.cn/problems/advantage-shuffle/

给定两个大小相等的数组 nums1 和 nums2，nums1 相对于 nums2 的优势可以用满足 nums1[i] > nums2[i] 的索引 i 的数目来描述。
返回 nums1 的任意排列，使其相对于 nums2 的优势最大化。
提示：
1 <= nums1.length <= 10^5
nums2.length == nums1.length
0 <= nums1[i], nums2[i] <= 10^9

贪心。又名 "田忌赛马"。
时间复杂度 O(nlogn)
空间复杂度 O(n)
 */