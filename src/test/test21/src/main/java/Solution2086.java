public class Solution2086 {
    public int minimumBuckets(String street) {
        // 没有办法收集所有房屋的雨水
        if (street.equals("H") || street.startsWith("HH") || street.endsWith("HH") || street.contains("HHH")) {
            return -1;
        }
        // 统计 "H.H" 次数
        int cntHPointH = 0;
        // 固定大小滑动窗口
        int left = 0;
        while (left + 2 < street.length()) {
            if (street.charAt(left) == 'H' && street.charAt(left + 1) == '.' && street.charAt(left + 2) == 'H') {
                cntHPointH++;
                left += 3;
            } else {
                left++;
            }
        }
        // 统计 'H' 次数
        int cntH = 0;
        for (char ch : street.toCharArray()) {
            if (ch == 'H') {
                cntH++;
            }
        }
        return cntH - cntHPointH;
    }
}
/*
2086. 从房屋收集雨水需要的最少水桶数
https://leetcode.cn/problems/minimum-number-of-food-buckets-to-feed-the-hamsters/

第 66 场双周赛 T2。

给你一个下标从 0 开始的字符串 street 。street 中每个字符要么是表示房屋的 'H' ，要么是表示空位的 '.' 。
你可以在 空位 放置水桶，从相邻的房屋收集雨水。位置在 i - 1 或者 i + 1 的水桶可以收集位置为 i 处房屋的雨水。
一个水桶如果相邻两个位置都有房屋，那么它可以收集 两个 房屋的雨水。
在确保 每个 房屋旁边都 至少 有一个水桶的前提下，请你返回需要的 最少 水桶数。如果无解请返回 -1 。

容易枚举出所有无解情况，直接返回 -1。
在有解情况下，假设有 n 个 'H'，最多需要 n 个水桶。
若存在 "H.H"，则可以节约 1 个水桶。
 */