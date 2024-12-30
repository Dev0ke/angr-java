import java.util.ArrayList;
import java.util.List;

public class Solution1389 {
    public int[] createTargetArray(int[] nums, int[] index) {
        int n = nums.length;
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ans.add(index[i], nums[i]);
        }
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }
}
/*
1389. 按既定顺序创建目标数组
https://leetcode.cn/problems/create-target-array-in-the-given-order/description/

给你两个整数数组 nums 和 index。你需要按照以下规则创建目标数组：
- 目标数组 target 最初为空。
- 按从左到右的顺序依次读取 nums[i] 和 index[i]，在 target 数组中的下标 index[i] 处插入值 nums[i] 。
- 重复上一步，直到在 nums 和 index 中都没有要读取的元素。
请你返回目标数组。
题目保证数字插入位置总是存在。
提示：
1 <= nums.length, index.length <= 100
nums.length == index.length
0 <= nums[i] <= 100
0 <= index[i] <= i

模拟。
时间复杂度 O(n^2)。
 */