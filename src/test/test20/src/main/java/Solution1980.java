import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Solution1980 {
    public String findDifferentBinaryString(String[] nums) {
        int numN = nums[0].length();
        long min = 0;
        long max = (1L << numN) - 1L;
        Set<String> hashset = new HashSet<>();
        Collections.addAll(hashset, nums);

        for (long i = min; i <= max; i++) {
            String binaryStr = toBinaryString(i, numN);
            if (!hashset.contains(binaryStr)) {
                return binaryStr;
            }
        }
        return null;
    }

    private String toBinaryString(long num, int len) {
        String binaryStr = Long.toBinaryString(num);
        int zeroLen = len - binaryStr.length();
        return "0".repeat(Math.max(0, zeroLen)) + binaryStr;
    }
}
/*
1980. 找出不同的二进制字符串
https://leetcode.cn/problems/find-unique-binary-string/

第 255 场周赛 T2。

给你一个字符串数组 nums ，该数组由 n 个 互不相同 的二进制字符串组成，且每个字符串长度都是 n 。
请你找出并返回一个长度为 n 且 没有出现 在 nums 中的二进制字符串。如果存在多种答案，只需返回 任意一个 即可。
提示：
n == nums.length
1 <= n <= 16
nums[i].length == n
nums[i] 为 '0' 或 '1'
nums 中的所有字符串 互不相同

将所有可能枚举出来，使用 HashSet 判断是否包含，返回其中一个不包含的值即可。
 */