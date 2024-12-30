public class Solution1299 {
    public int[] replaceElements(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];
        ans[n - 1] = -1;
        for (int i = n - 2; i >= 0; i--) {
            ans[i] = Math.max(ans[i + 1], arr[i + 1]);
        }
        return ans;
    }
}
/*
1299. 将每个元素替换为右侧最大元素
https://leetcode.cn/problems/replace-elements-with-greatest-element-on-right-side/description/

给你一个数组 arr ，请你将每个元素用它右边最大的元素替换，如果是最后一个元素，用 -1 替换。
完成所有替换操作后，请你返回这个数组。
提示：
1 <= arr.length <= 10^4
1 <= arr[i] <= 10^5

倒序遍历。
时间复杂度 O(n)。
 */