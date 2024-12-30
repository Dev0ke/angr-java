import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution2094 {
    public int[] findEvenNumbers(int[] digits) {
        // 3 <= digits.length <= 100
        int len = digits.length;
        Set<Integer> resSet = new HashSet<>();
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                for (int k = j + 1; k < len; k++) {
                    resSet.addAll(arrangement(digits[i], digits[j], digits[k]));
                }
            }
        }
        List<Integer> resList = new ArrayList<>(resSet);
        Collections.sort(resList);
        return resList.stream().mapToInt(i -> i).toArray();
    }

    // 123 132
    // 213 231
    // 312 321
    private Set<Integer> arrangement(int digit1, int digit2, int digit3) {
        Set<Integer> resSet = new HashSet<>();
        if (digit1 != 0) {
            if (digit3 % 2 == 0) {
                resSet.add(digit1 * 100 + digit2 * 10 + digit3);
            }
            if (digit2 % 2 == 0) {
                resSet.add(digit1 * 100 + digit3 * 10 + digit2);
            }
        }
        if (digit2 != 0) {
            if (digit3 % 2 == 0) {
                resSet.add(digit2 * 100 + digit1 * 10 + digit3);
            }
            if (digit1 % 2 == 0) {
                resSet.add(digit2 * 100 + digit3 * 10 + digit1);
            }
        }
        if (digit3 != 0) {
            if (digit2 % 2 == 0) {
                resSet.add(digit3 * 100 + digit1 * 10 + digit2);
            }
            if (digit1 % 2 == 0) {
                resSet.add(digit3 * 100 + digit2 * 10 + digit1);
            }
        }
        return resSet;
    }

    public int[] findEvenNumbers2(int[] digits) {
        int[] cnt = new int[10];
        for (int digit : digits) {
            cnt[digit]++;
        }
        List<Integer> resList = new ArrayList<>();
        for (int i = 100; i < 999; i += 2) {
            int digit1 = i / 100 % 10;
            int digit2 = i / 10 % 10;
            int digit3 = i % 10;
            cnt[digit1]--;
            cnt[digit2]--;
            cnt[digit3]--;
            if (cnt[digit1] >= 0 && cnt[digit2] >= 0 && cnt[digit3] >= 0) {
                resList.add(i);
            }
            cnt[digit1]++;
            cnt[digit2]++;
            cnt[digit3]++;
        }
        return resList.stream().mapToInt(i -> i).toArray();
    }
}
/*
2094. 找出 3 位偶数
https://leetcode.cn/problems/finding-3-digit-even-numbers/

第 270 场周赛 T1。

给你一个整数数组 digits ，其中每个元素是一个数字（0 - 9）。数组中可能存在重复元素。
你需要找出 所有 满足下述条件且 互不相同 的整数：
- 该整数由 digits 中的三个元素按 任意 顺序 依次连接 组成。
- 该整数不含 前导零
- 该整数是一个 偶数
例如，给定的 digits 是 [1, 2, 3] ，整数 132 和 312 满足上面列出的全部条件。
将找出的所有互不相同的整数按 递增顺序 排列，并以数组形式返回。
提示：
3 <= digits.length <= 100
0 <= digits[i] <= 9

考虑暴力。
三个for时间复杂度 O(n^3)，3的全排列为6，最坏情况数量级为 6 * 10^6
 */