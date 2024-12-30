import java.util.ArrayList;
import java.util.List;

public class Solution2032 {
    public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
        boolean[] appear1 = new boolean[101];
        boolean[] appear2 = new boolean[101];
        boolean[] appear3 = new boolean[101];
        for (int num : nums1) {
            appear1[num] = true;
        }
        for (int num : nums2) {
            appear2[num] = true;
        }
        for (int num : nums3) {
            appear3[num] = true;
        }
        List<Integer> resList = new ArrayList<>();
        for (int i = 1; i <= 100; i++) {
            if ((appear1[i] && appear2[i]) || (appear2[i] && appear3[i]) || (appear1[i] && appear3[i])) {
                resList.add(i);
            }
        }
        return resList;
    }
}
/*
2032. 至少在两个数组中出现的值
https://leetcode.cn/problems/two-out-of-three/

第 262 场周赛 T1。

给你三个整数数组 nums1、nums2 和 nums3 ，请你构造并返回一个 不同 数组，且由 至少 在 两个 数组中出现的所有值组成。
数组中的元素可以按 任意 顺序排列。

模拟。
 */