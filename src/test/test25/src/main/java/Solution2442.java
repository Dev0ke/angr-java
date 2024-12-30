import java.util.HashSet;
import java.util.Set;

public class Solution2442 {
    public int countDistinctIntegers(int[] nums) {
        Set<Integer> hashSet = new HashSet<>();
        for (int num : nums) {
            hashSet.add(num);
            int reverse = Integer.parseInt(new StringBuilder(String.valueOf(num)).reverse().toString());
            hashSet.add(reverse);
        }
        return hashSet.size();
    }
}
/*
2442. 反转之后不同整数的数目
https://leetcode.cn/problems/count-number-of-distinct-integers-after-reverse-operations/

第 315 场周赛 T2。

给你一个由 正 整数组成的数组 nums 。
你必须取出数组中的每个整数，反转其中每个数位，并将反转后得到的数字添加到数组的末尾。这一操作只针对 nums 中原有的整数执行。
返回结果数组中 不同 整数的数目。
提示：
1 <= nums.length <= 10^5
1 <= nums[i] <= 10^6

模拟。
 */