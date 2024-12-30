import java.util.ArrayList;
import java.util.List;

public class Solution3285 {
    public List<Integer> stableMountains(int[] height, int threshold) {
        int n = height.length;
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i + 1 < n; i++) {
            if (height[i] > threshold) {
                ans.add(i + 1);
            }
        }
        return ans;
    }
}
/*
3285. 找到稳定山的下标
https://leetcode.cn/problems/find-indices-of-stable-mountains/description/

第 139 场双周赛 T1。

有 n 座山排成一列，每座山都有一个高度。给你一个整数数组 height ，其中 height[i] 表示第 i 座山的高度，再给你一个整数 threshold 。
对于下标不为 0 的一座山，如果它左侧相邻的山的高度 严格大于 threshold ，那么我们称它是 稳定 的。我们定义下标为 0 的山 不是 稳定的。
请你返回一个数组，包含所有 稳定 山的下标，你可以以 任意 顺序返回下标数组。
提示：
2 <= n == height.length <= 100
1 <= height[i] <= 100
1 <= threshold <= 100

枚举。
时间复杂度 O(n)。
 */