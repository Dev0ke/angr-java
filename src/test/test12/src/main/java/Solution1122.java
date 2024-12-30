public class Solution1122 {
    private static final int MAX_LEN = 1000;

    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        // 统计频次
        int[] cntArr = new int[MAX_LEN + 1];
        for (int num : arr1) {
            cntArr[num]++;
        }

        int[] res = new int[arr1.length];

        // 使 arr1 中项的相对顺序和 arr2 中的相对顺序相同
        int idx = 0;
        for (int num : arr2) {
            while (cntArr[num] > 0) {
                cntArr[num]--;
                res[idx] = num;
                idx++;
            }
        }

        // 未在 arr2 中出现过的元素需要按照升序放在 arr1 的末尾
        for (int i = 0; i < MAX_LEN + 1; i++) {
            while (cntArr[i] > 0) {
                cntArr[i]--;
                res[idx] = i;
                idx++;
            }
        }
        return res;
    }
}
/*
1122. 数组的相对排序
https://leetcode.cn/problems/relative-sort-array/

第 145 场周赛 T1。

给你两个数组，arr1 和 arr2，arr2 中的元素各不相同，arr2 中的每个元素都出现在 arr1 中。
对 arr1 中的元素进行排序，使 arr1 中项的相对顺序和 arr2 中的相对顺序相同。未在 arr2 中出现过的元素需要按照升序放在 arr1 的末尾。
提示：
1 <= arr1.length, arr2.length <= 1000
0 <= arr1[i], arr2[i] <= 1000
arr2 中的元素 arr2[i]  各不相同 
arr2 中的每个元素 arr2[i] 都出现在 arr1 中

计数排序
时间复杂度 O(m+n)
空间复杂度 O(1) 常数为 1000
 */