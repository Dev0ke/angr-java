import java.math.BigInteger;
import java.util.Collections;
import java.util.PriorityQueue;

public class Solution1985 {
    public String kthLargestNumber(String[] nums, int k) {
        // 大顶堆
        PriorityQueue<String> maxHeap = new PriorityQueue<>((o1, o2) -> new BigInteger(o2).compareTo(new BigInteger(o1)));
        Collections.addAll(maxHeap, nums);
        String res = "";
        while (k > 0) {
            res = maxHeap.poll();
            k--;
        }
        return res;
    }
}
/*
1985. 找出数组中的第 K 大整数
https://leetcode.cn/problems/find-the-kth-largest-integer-in-the-array/

第 256 场周赛 T2。

给你一个字符串数组 nums 和一个整数 k 。nums 中的每个字符串都表示一个不含前导零的整数。
返回 nums 中表示第 k 大整数的字符串。
注意：重复的数字在统计时会视为不同元素考虑。例如，如果 nums 是 ["1","2","2"]，那么 "2" 是最大的整数，"2" 是第二大的整数，"1" 是第三大的整数。
提示：
1 <= k <= nums.length <= 10^4
1 <= nums[i].length <= 100
nums[i] 仅由数字组成
nums[i] 不含任何前导零

优先队列一眼题。
 */