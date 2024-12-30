import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution350 {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> cntMap1 = new HashMap<>();
        Map<Integer, Integer> cntMap2 = new HashMap<>();
        for (int num : nums1) {
            cntMap1.put(num, cntMap1.getOrDefault(num, 0) + 1);
        }
        for (int num : nums2) {
            cntMap2.put(num, cntMap2.getOrDefault(num, 0) + 1);
        }

        List<Integer> resList = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : cntMap1.entrySet()) {
            int key = entry.getKey();
            if (cntMap2.containsKey(key)) {
                int min = Math.min(entry.getValue(), cntMap2.get(key));
                for (int i = 0; i < min; i++) {
                    resList.add(key);
                }
            }
        }
        return resList.stream().mapToInt(i -> i).toArray();
    }
}
/*
350. 两个数组的交集 II
https://leetcode.cn/problems/intersection-of-two-arrays-ii/

给你两个整数数组 nums1 和 nums2 ，请你以数组形式返回两数组的交集。
返回结果中每个元素出现的次数，应与元素在两个数组中都出现的次数一致（如果出现次数不一致，则考虑取较小值）。可以不考虑输出结果的顺序。
提示：
1 <= nums1.length, nums2.length <= 1000
0 <= nums1[i], nums2[i] <= 1000
进阶：
如果给定的数组已经排好序呢？你将如何优化你的算法？
如果 nums1 的大小比 nums2 小，哪种方法更优？
如果 nums2 的元素存储在磁盘上，内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？

HashSet 升级为 HashMap 统计频次。
相似题目: 349. 两个数组的交集
https://leetcode.cn/problems/intersection-of-two-arrays/
 */