import java.util.HashSet;
import java.util.Set;

public class Solution349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for (int num : nums1) {
            set1.add(num);
        }
        for (int num : nums2) {
            set2.add(num);
        }
        set1.retainAll(set2);
        return set1.stream().mapToInt(i -> i).toArray();
    }
}
/*
349. 两个数组的交集
https://leetcode.cn/problems/intersection-of-two-arrays/

给定两个数组 nums1 和 nums2 ，返回 它们的交集 。输出结果中的每个元素一定是 唯一 的。我们可以 不考虑输出结果的顺序 。
提示：
1 <= nums1.length, nums2.length <= 1000
0 <= nums1[i], nums2[i] <= 1000

Set<E>#retainAll(Collection<?> c) 求交集。
相似题目: 350. 两个数组的交集 II
https://leetcode.cn/problems/intersection-of-two-arrays-ii/
 */