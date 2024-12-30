import java.util.LinkedList;

public class Solution2210 {
    public int countHillValley(int[] nums) {
        // 去重
        LinkedList<Integer> list = new LinkedList<>();
        for (int num : nums) {
            if (list.isEmpty() || num != list.peekLast()) {
                list.addLast(num);
            }
        }

        // 统计 峰和谷
        int size = list.size();
        int cnt = 0;
        for (int i = 1; i < size - 1; i++) {
            if (list.get(i) > list.get(i - 1) && list.get(i) > list.get(i + 1)) {
                cnt++;
            }
            if (list.get(i) < list.get(i - 1) && list.get(i) < list.get(i + 1)) {
                cnt++;
            }
        }
        return cnt;
    }
}
/*
2210. 统计数组中峰和谷的数量
https://leetcode.cn/problems/count-hills-and-valleys-in-an-array/

第 285 场周赛 T1。

给你一个下标从 0 开始的整数数组 nums 。如果两侧距 i 最近的不相等邻居的值均小于 nums[i] ，则下标 i 是 nums 中，某个峰的一部分。
类似地，如果两侧距 i 最近的不相等邻居的值均大于 nums[i] ，则下标 i 是 nums 中某个谷的一部分。
对于相邻下标 i 和 j ，如果 nums[i] == nums[j] ， 则认为这两下标属于 同一个 峰或谷。
注意，要使某个下标所做峰或谷的一部分，那么它左右两侧必须 都 存在不相等邻居。
返回 nums 中峰和谷的数量。
提示：
3 <= nums.length <= 100
1 <= nums[i] <= 100

去重后再统计 峰和谷
 */