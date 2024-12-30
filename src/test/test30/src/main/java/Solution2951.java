import java.util.ArrayList;
import java.util.List;

public class Solution2951 {
    public List<Integer> findPeaks(int[] mountain) {
        int n = mountain.length;
        List<Integer> ans = new ArrayList<>();
        for (int i = 1; i <= n - 2; i++) {
            if (mountain[i] > mountain[i - 1] && mountain[i] > mountain[i + 1]) {
                ans.add(i);
            }
        }
        return ans;
    }
}
/*
2951. 找出峰值
https://leetcode.cn/problems/find-the-peaks/description/

第 374 场周赛 T1。

给你一个下标从 0 开始的数组 mountain 。你的任务是找出数组 mountain 中的所有 峰值。
以数组形式返回给定数组中 峰值 的下标，顺序不限 。
注意：
- 峰值 是指一个严格大于其相邻元素的元素。
- 数组的第一个和最后一个元素 不 是峰值。
提示：
3 <= mountain.length <= 100
1 <= mountain[i] <= 100

模拟。
 */