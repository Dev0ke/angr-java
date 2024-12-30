import java.util.ArrayList;
import java.util.List;

public class Solution1018 {
    public List<Boolean> prefixesDivBy5(int[] nums) {
        List<Boolean> ans = new ArrayList<>();
        int mod_int = 0;
        for (int v : nums) {
            mod_int = ((mod_int << 1) + v) % 5;
            ans.add(mod_int == 0);
        }
        return ans;
    }
}
/*
1018. 可被 5 整除的二进制前缀
https://leetcode.cn/problems/binary-prefix-divisible-by-5/description/

给定一个二进制数组 nums ( 索引从0开始 )。
我们将xi 定义为其二进制表示形式为子数组 nums[0..i] (从最高有效位到最低有效位)。
- 例如，如果 nums =[1,0,1] ，那么 x0 = 1, x1 = 2, 和 x2 = 5。
返回布尔值列表 answer，只有当 xi 可以被 5 整除时，答案 answer[i] 为 true，否则为 false。
提示：
1 <= nums.length <= 10^5
nums[i] 仅为 0 或 1

遍历。
时间复杂度 O(n)。
 */