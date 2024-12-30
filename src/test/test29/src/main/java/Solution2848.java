import java.util.List;

public class Solution2848 {
    private static final int MAX_N = 105;

    public int numberOfPoints(List<List<Integer>> nums) {
        int[] diff = new int[MAX_N];
        for (List<Integer> num : nums) {
            int start = num.get(0), end = num.get(1);
            diff[start] += 1;
            diff[end + 1] -= 1;
        }
        int[] res = new int[MAX_N];
        res[0] = diff[0];
        for (int i = 1; i < MAX_N; i++) {
            res[i] = res[i - 1] + diff[i];
        }
        int ans = 0;
        for (int x : res) {
            if (x > 0) {
                ans++;
            }
        }
        return ans;
    }
}
/*
2848. 与车相交的点
https://leetcode.cn/problems/points-that-intersect-with-cars/

第 362 场周赛 T1。

给你一个下标从 0 开始的二维整数数组 nums 表示汽车停放在数轴上的坐标。对于任意下标 i，nums[i] = [starti, endi] ，其中 starti 是第 i 辆车的起点，endi 是第 i 辆车的终点。
返回数轴上被车 任意部分 覆盖的整数点的数目。
提示：
1 <= nums.length <= 100
nums[i].length == 2
1 <= starti <= endi <= 100

差分模拟
 */