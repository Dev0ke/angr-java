import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution2766 {
    public List<Integer> relocateMarbles(int[] nums, int[] moveFrom, int[] moveTo) {
        Set<Integer> set = new HashSet<>();
        for (int x : nums) set.add(x);

        int n = moveFrom.length;
        for (int i = 0; i < n; i++) {
            set.remove(moveFrom[i]);
            set.add(moveTo[i]);
        }

        List<Integer> ans = new ArrayList<>(set);
        ans.sort(null);
        return ans;
    }
}
/*
2766. 重新放置石块
https://leetcode.cn/problems/relocate-marbles/

第 108 场双周赛 T2。

给你一个下标从 0 开始的整数数组 nums ，表示一些石块的初始位置。再给你两个长度 相等 下标从 0 开始的整数数组 moveFrom 和 moveTo 。
在 moveFrom.length 次操作内，你可以改变石块的位置。在第 i 次操作中，你将位置在 moveFrom[i] 的所有石块移到位置 moveTo[i] 。
完成这些操作后，请你按升序返回所有 有 石块的位置。
注意：
- 如果一个位置至少有一个石块，我们称这个位置 有 石块。
- 一个位置可能会有多个石块。
提示：
1 <= nums.length <= 10^5
1 <= moveFrom.length <= 10^5
moveFrom.length == moveTo.length
1 <= nums[i], moveFrom[i], moveTo[i] <= 10^9
测试数据保证在进行第 i 步操作时，moveFrom[i] 处至少有一个石块。

哈希表模拟
时间复杂度 O(nlogn) 为排序时间复杂度
 */