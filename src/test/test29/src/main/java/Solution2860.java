import java.util.List;

public class Solution2860 {
    public int countWays(List<Integer> nums) {
        int n = nums.size();
        nums.sort(null);

        int ans = 0;
        int yes = 0;
        // 没有选中学生
        if (yes < nums.get(0)) {
            ans++;
        }
        for (int i = 0; i < n; i++) {
            yes++;
            int x = nums.get(i);
            if (yes > x) {
                if (i + 1 < n) {
                    int y = nums.get(i + 1);
                    if (yes < y) {
                        ans++;
                    }
                }
            }
        }
        // 选中所有学生
        if (yes > nums.get(n - 1)) {
            ans++;
        }
        return ans;
    }
}
/*
2860. 让所有学生保持开心的分组方法数
https://leetcode.cn/problems/happy-students/

第 363 场周赛 T2。

给你一个下标从 0 开始、长度为 n 的整数数组 nums ，其中 n 是班级中学生的总数。班主任希望能够在让所有学生保持开心的情况下选出一组学生：
如果能够满足下述两个条件之一，则认为第 i 位学生将会保持开心：
- 这位学生被选中，并且被选中的学生人数 严格大于 nums[i] 。
- 这位学生没有被选中，并且被选中的学生人数 严格小于 nums[i] 。
返回能够满足让所有学生保持开心的分组方法的数目。
提示：
1 <= nums.length <= 10^5
0 <= nums[i] < nums.length

排序后，枚举分割点。
时间复杂度 O(nlogn)
 */