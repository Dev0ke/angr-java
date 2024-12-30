import java.util.ArrayList;
import java.util.List;

public class Solution969 {
    public List<Integer> pancakeSort(int[] arr) {
        int len = arr.length;

        List<Integer> list = new ArrayList<>();
        for (int n = len; n > 1; n--) {
            int idx = 0;
            for (int i = 1; i < n; i++) {
                if (arr[i] >= arr[idx]) {
                    idx = i;
                }
            }
            if (idx == n - 1) {
                continue;
            }
            reverse(arr, idx);
            reverse(arr, n - 1);
            list.add(idx + 1);
            list.add(n);
        }
        return list;
    }

    private void reverse(int[] arr, int k) {
        for (int i = 0, j = k; i < j; i++, j--) {
            int tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
        }
    }
}
/*
969. 煎饼排序
https://leetcode.cn/problems/pancake-sorting/

给你一个整数数组 arr ，请使用 煎饼翻转 完成对数组的排序。
一次煎饼翻转的执行过程如下：
- 选择一个整数 k ，1 <= k <= arr.length
- 反转子数组 arr[0...k-1]（下标从 0 开始）
例如，arr = [3,2,1,4] ，选择 k = 3 进行一次煎饼翻转，反转子数组 [3,2,1] ，得到 arr = [1,2,3,4] 。
以数组形式返回能使 arr 有序的煎饼翻转操作所对应的 k 值序列。任何将数组排序且翻转次数在 10 * arr.length 范围内的有效答案都将被判断为正确。
提示：
1 <= arr.length <= 100
1 <= arr[i] <= arr.length
arr 中的所有整数互不相同（即，arr 是从 1 到 arr.length 整数的一个排列）

官方题解: https://leetcode.cn/problems/pancake-sorting/solution/jian-bing-pai-xu-by-leetcode-solution-rzzu/
煎饼排序的相关背景内容可以参考百度百科「煎饼排序」。2011年，劳伦特·比尔托（Laurent Bulteau）、纪尧姆·佛丁（Guillaume Fertin）
和伊雷娜·鲁苏（Irena Rusu）证明了给定一叠煎饼的长度分布，找到最短解法是 NP 困难的，
参考论文「Bulteau, Laurent; Fertin, Guillaume; Rusu, Irena. Pancake Flipping Is Hard. Journal of Computer and System Sciences: 1556–1574.」。
找最短解法比较困难，但是题目只需要找到一种可行的解法。并且最多通过两步操作就能把任意下标置换到队尾。
step1: 反转 arr[0...k-1] index 被置于队首
step2: 反转整个 arr，index 被置于队尾
时间复杂度 O(n^2)
空间复杂度 O(n)
 */