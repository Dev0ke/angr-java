import java.util.Arrays;

public class Solution1558 {
    // 第一种操作：让序列中某个数加 1
    // 第二种操作：让序列中所有数全体乘以 2
    public int minOperations(int[] nums) {
        // 第一种操作的数量：二进制表示中 1 的数量之和
        int ans = 0;
        for (int v : nums) {
            ans += Integer.bitCount(v); // 第一种操作的数量
        }
        // 第二种操作的数量：所有数的二进制表示的最高位数
        int mx = Arrays.stream(nums).max().orElseThrow();
        if (mx > 0) {
            ans += 31 - Integer.numberOfLeadingZeros(mx);
        }
        return ans;
    }
}
/*
1558. 得到目标数组的最少函数调用次数
https://leetcode.cn/problems/minimum-numbers-of-function-calls-to-make-target-array/description/

```
func modify(arr, op, idx) {
    //add by 1 index idx
    if (op == 0) {
        arr[idx] = arr[idx] + 1
    }
    //multiply by 2 all elements
    if (op == 1) {
        for (i = 0; i < arr.length; i++) {
            arr[i] = arr[i] * 2
        }
    }
}
```
给你一个与 nums 大小相同且初始值全为 0 的数组 arr ，请你调用以上函数得到整数数组 nums 。
请你返回将 arr 变成 nums 的最少函数调用次数。
答案保证在 32 位有符号整数以内。
提示：
1 <= nums.length <= 10^5
0 <= nums[i] <= 10^9

二进制性质。
时间复杂度 O(nU)。其中 U = log(max(nums[i])) < 32
相似题目: 1404. 将二进制表示减到 1 的步骤数
https://leetcode.cn/problems/number-of-steps-to-reduce-a-number-in-binary-representation-to-one/description/
 */