import java.util.HashSet;
import java.util.Set;

public class Solution1539 {
    public int findKthPositive(int[] arr, int k) {
        Set<Integer> hashSet = new HashSet<>();
        for (int i : arr) {
            hashSet.add(i);
        }

        int num = 1;
        while (k > 0) {
            if (!hashSet.contains(num)) {
                k--;
            }
            num++;
        }
        return num - 1;
    }
}
/*
1539. 第 k 个缺失的正整数
https://leetcode.cn/problems/kth-missing-positive-number/

给你一个 严格升序排列 的正整数数组 arr 和一个整数 k 。
请你找到这个数组里第 k 个缺失的正整数。
提示：
1 <= arr.length <= 1000
1 <= arr[i] <= 1000
1 <= k <= 1000
对于所有 1 <= i < j <= arr.length 的 i 和 j 满足 arr[i] < arr[j]

线性遍历
时间复杂度 O(n)
相似题目: 2195. 向数组中追加 K 个整数
https://leetcode.cn/problems/append-k-integers-with-minimal-sum/
 */