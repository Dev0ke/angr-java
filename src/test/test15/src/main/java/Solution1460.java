import java.util.HashMap;
import java.util.Map;

public class Solution1460 {
    public boolean canBeEqual(int[] target, int[] arr) {
        Map<Integer, Integer> cntMap1 = new HashMap<>();
        Map<Integer, Integer> cntMap2 = new HashMap<>();
        for (int i : target) {
            cntMap1.put(i, cntMap1.getOrDefault(i, 0) + 1);
        }
        for (int i : arr) {
            cntMap2.put(i, cntMap2.getOrDefault(i, 0) + 1);
        }
        return cntMap1.equals(cntMap2);
    }
}
/*
1460. 通过翻转子数组使两个数组相等
https://leetcode.cn/problems/make-two-arrays-equal-by-reversing-sub-arrays/

给你两个长度相同的整数数组 target 和 arr 。每一步中，你可以选择 arr 的任意 非空子数组 并将它翻转。你可以执行此过程任意次。
如果你能让 arr 变得与 target 相同，返回 True；否则，返回 False 。
提示：
target.length == arr.length
1 <= target.length <= 1000
1 <= target[i] <= 1000
1 <= arr[i] <= 1000

两个 HashMap 判等。
 */