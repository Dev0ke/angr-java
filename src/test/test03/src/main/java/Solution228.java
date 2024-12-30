import java.util.ArrayList;
import java.util.List;

public class Solution228 {
    public List<String> summaryRanges(int[] nums) {
        int len = nums.length;

        // 双指针
        int left = 0;
        int right = 0;
        List<String> resList = new ArrayList<>();
        while (right < len) {
            if (right + 1 < len && (nums[right + 1] - nums[left]) == (right + 1 - left)) {
                right++;
            } else {
                // "a->b" ，如果 a != b
                // "a" ，如果 a == b
                if (nums[left] == nums[right]) {
                    resList.add(String.valueOf(nums[left]));
                } else {
                    resList.add(nums[left] + "->" + nums[right]);
                }

                right++;
                left = right;
            }
        }
        return resList;
    }
}
/*
228. 汇总区间
https://leetcode.cn/problems/summary-ranges/

给定一个  无重复元素 的 有序 整数数组 nums 。
返回 恰好覆盖数组中所有数字 的 最小有序 区间范围列表 。也就是说，nums 的每个元素都恰好被某个区间范围所覆盖，并且不存在属于某个范围但不属于 nums 的数字 x 。
列表中的每个区间范围 [a,b] 应该按如下格式输出：
- "a->b" ，如果 a != b
- "a" ，如果 a == b
提示：
0 <= nums.length <= 20
-2^31 <= nums[i] <= 2^31 - 1
nums 中的所有值都 互不相同
nums 按升序排列

双指针
 */