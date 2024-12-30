import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class SolutionP1213 {
    public List<Integer> arraysIntersection(int[] arr1, int[] arr2, int[] arr3) {
        Set<Integer> set1 = Arrays.stream(arr1).boxed().collect(Collectors.toSet());
        Set<Integer> set2 = Arrays.stream(arr2).boxed().collect(Collectors.toSet());
        Set<Integer> set3 = Arrays.stream(arr3).boxed().collect(Collectors.toSet());
        set1.retainAll(set2);
        set1.retainAll(set3);

        List<Integer> resList = new ArrayList<>(set1);
        Collections.sort(resList);
        return resList;
    }
}
/*
$1213. 三个有序数组的交集
https://leetcode.cn/problems/intersection-of-three-sorted-arrays/

给出三个均为 严格递增排列 的整数数组 arr1，arr2 和 arr3。返回一个由 仅 在这三个数组中 同时出现 的整数所构成的有序数组。
提示：
1 <= arr1.length, arr2.length, arr3.length <= 1000
1 <= arr1[i], arr2[i], arr3[i] <= 2000

Set 求交集。
相似题目: 2248. 多个数组求交集
https://leetcode.cn/problems/intersection-of-multiple-arrays/
 */