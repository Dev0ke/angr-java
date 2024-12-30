import java.util.ArrayList;
import java.util.List;

public class Solution1313 {
    public int[] decompressRLElist(int[] nums) {
        int n = nums.length;
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i += 2) {
            for (int j = 0; j < nums[i]; j++) {
                ans.add(nums[i + 1]);
            }
        }
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }
}
/*
1313. 解压缩编码列表
https://leetcode.cn/problems/decompress-run-length-encoded-list/description/

给你一个以行程长度编码压缩的整数列表 nums 。
考虑每对相邻的两个元素 [freq, val] = [nums[2*i], nums[2*i+1]] （其中 i >= 0 ），每一对都表示解压后子列表中有 freq 个值为 val 的元素，你需要从左到右连接所有子列表以生成解压后的列表。
请你返回解压后的列表。
提示：
2 <= nums.length <= 100
nums.length % 2 == 0
1 <= nums[i] <= 100

模拟。
时间复杂度 O(n + sum(nums[even]))。
 */