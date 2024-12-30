import java.util.ArrayDeque;
import java.util.Deque;

public class Solution1673 {
    public int[] mostCompetitive(int[] nums, int k) {
        int toDel = nums.length - k;
        Deque<Integer> stack = new ArrayDeque<>();
        for (int num : nums) {
            // 栈非空 && 待删除数量 && 栈顶元素大于当前元素
            while (!stack.isEmpty() && toDel > 0 && stack.peek() > num) {
                stack.pop();
                toDel--;
            }
            stack.push(num);
        }
        while (toDel > 0) {
            stack.pop();
            toDel--;
        }
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = stack.removeLast();
        }
        return res;
    }
}
/*
1673. 找出最具竞争力的子序列
https://leetcode.cn/problems/find-the-most-competitive-subsequence/

第 217 场周赛 T2。

给你一个整数数组 nums 和一个正整数 k ，返回长度为 k 且最具 竞争力 的 nums 子序列。
数组的子序列是从数组中删除一些元素（可能不删除元素）得到的序列。
在子序列 a 和子序列 b 第一个不相同的位置上，如果 a 中的数字小于 b 中对应的数字，
那么我们称子序列 a 比子序列 b（相同长度下）更具 竞争力 。 例如，[1,3,4] 比 [1,3,5] 更具竞争力，
在第一个不相同的位置，也就是最后一个位置上， 4 小于 5 。
提示：
1 <= nums.length <= 10^5
0 <= nums[i] <= 10^9
1 <= k <= nums.length

单调栈。
 */