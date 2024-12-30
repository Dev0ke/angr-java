public class Solution2513 {
    public int minimizeSet(int divisor1, int divisor2, int uniqueCnt1, int uniqueCnt2) {
        int left = 0;
        int right = Integer.MAX_VALUE;
        while (left < right) {
            int mid = left + (right - left) / 2;
            // 边界二分 F, F,..., F, [T, T,..., T]
            // ----------------------^
            if (checkMid(divisor1, divisor2, uniqueCnt1, uniqueCnt2, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private boolean checkMid(int divisor1, int divisor2, int uniqueCnt1, int uniqueCnt2, int mid) {
        // 不能整除 divisor1 的数
        // 不能整除 divisor2 的数
        int cnt1 = mid / divisor1 * (divisor1 - 1) + mid % divisor1;
        int cnt2 = mid / divisor2 * (divisor2 - 1) + mid % divisor2;
        long lcm = divisor1 / getGCD(divisor1, divisor2) * divisor2;
        // 不能整除 divisor1、divisor2 的数
        long cnt3 = mid / lcm * (lcm - 1) + mid % lcm;
        return cnt1 >= uniqueCnt1 && cnt2 >= uniqueCnt2 && cnt3 >= uniqueCnt1 + uniqueCnt2;
    }

    private long getGCD(long num1, long num2) {
        if (num1 == 0) {
            return num2;
        }
        return getGCD(num2 % num1, num1);
    }
}
/*
2513. 最小化两个数组中的最大值
https://leetcode.cn/problems/minimize-the-maximum-of-two-arrays/

第 94 场双周赛 T3。

给你两个数组 arr1 和 arr2 ，它们一开始都是空的。你需要往它们中添加正整数，使它们满足以下条件：
arr1 包含 uniqueCnt1 个 互不相同 的正整数，每个整数都 不能 被 divisor1 整除 。
arr2 包含 uniqueCnt2 个 互不相同 的正整数，每个整数都 不能 被 divisor2 整除 。
arr1 和 arr2 中的元素 互不相同 。
给你 divisor1 ，divisor2 ，uniqueCnt1 和 uniqueCnt2 ，请你返回两个数组中 最大元素 的 最小值 。
提示：
2 <= divisor1, divisor2 <= 10^5
1 <= uniqueCnt1, uniqueCnt2 < 10^9
2 <= uniqueCnt1 + uniqueCnt2 <= 10^9

二分。两个数组中 最大元素 的 最小值。
对于每个值求：
cnt1 = 不能整除 divisor1 的数
cnt2 = 不能整除 divisor2 的数
cnt3 = 不能整除 divisor1、divisor2 的数
使 cnt3 >= uniqueCnt1 + uniqueCnt2 且 cnt1 >= uniqueCnt1 && cnt2 >= uniqueCnt2 便 ok，前两部分可以贪心取得。
 */