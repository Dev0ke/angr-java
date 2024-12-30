import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution1187 {
    private static final int INF = (int) 1e9;
    private int[] arr1;
    private int[] arr2;
    private List<Map<Integer, Integer>> memo;

    public int makeArrayIncreasing(int[] arr1, int[] arr2) {
        this.arr1 = arr1;
        this.arr2 = arr2;
        Arrays.sort(arr2);

        memo = new ArrayList<>();
        for (int i = 0; i < arr1.length; i++) {
            memo.add(new HashMap<>());
        }
        // 假设 a[n-1] 右侧有个无穷大的数
        int res = dfs(arr1.length - 1, INF);
        return res == INF ? -1 : res;
    }

    // 把 a[0, i] 这段替换成严格递增数组，且数组最后一个数小于 last
    private int dfs(int i, int last) {
        if (i < 0) {
            return 0;
        }
        if (memo.get(i).containsKey(last)) {
            return memo.get(i).get(last);
        }

        // 不替换 a[i]
        int res = arr1[i] < last ? dfs(i - 1, arr1[i]) : INF;
        // 二分查找 b 中小于 pre 的最大数的下标
        int left = 0;
        int right = arr2.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            // 边界二分 F, F,..., F, [T, T,..., T]
            // ----------------------^
            if (arr2[mid] >= last) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        int k = left - 1;
        if (k >= 0) {
            res = Math.min(res, dfs(i - 1, arr2[k]) + 1);
        }
        memo.get(i).put(last, res);
        return res;
    }
}
/*
1187. 使数组严格递增
https://leetcode.cn/problems/make-array-strictly-increasing/

给你两个整数数组 arr1 和 arr2，返回使 arr1 严格递增所需要的最小「操作」数（可能为 0）。
每一步「操作」中，你可以分别从 arr1 和 arr2 中各选出一个索引，分别为 i 和 j，0 <= i < arr1.length 和 0 <= j < arr2.length，然后进行赋值运算 arr1[i] = arr2[j]。
如果无法让 arr1 严格递增，请返回 -1。
提示：
1 <= arr1.length, arr2.length <= 2000
0 <= arr1[i], arr2[i] <= 10^9
 */