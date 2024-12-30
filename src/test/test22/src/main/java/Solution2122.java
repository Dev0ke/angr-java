import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution2122 {
    public int[] recoverArray(int[] nums) {
        int len = nums.length;
        Arrays.sort(nums);
        // 注意：生成的测试用例保证存在 至少一个 有效数组 arr
        for (int i = 1; i < len; i++) {
            int diff = nums[i] - nums[0];
            if (diff > 0 && diff % 2 == 0) {
                int k = diff / 2;
                boolean[] used = new boolean[len];
                used[0] = true;
                used[i] = true;
                // 双指针
                int left = 1;
                int right = i + 1;
                List<Integer> list = new ArrayList<>();
                list.add(nums[0] + k);
                while (true) {
                    while (left < len && used[left]) {
                        left++;
                    }
                    while (right < len && (used[right] || nums[right] != nums[left] + diff)) {
                        right++;
                    }
                    if (right == len) {
                        break;
                    }
                    used[left] = true;
                    used[right] = true;
                    list.add(nums[left] + k);
                }
                if (list.size() == len / 2) {
                    return list.stream().mapToInt(ii -> ii).toArray();
                }
            }
        }
        return new int[]{};
    }
}
/*
2122. 还原原数组
https://leetcode.cn/problems/recover-the-original-array/

第 273 场周赛 T4。

Alice 有一个下标从 0 开始的数组 arr ，由 n 个正整数组成。她会选择一个任意的 正整数 k 并按下述方式创建两个下标从 0 开始的新整数数组 lower 和 higher ：
1.对每个满足 0 <= i < n 的下标 i ，lower[i] = arr[i] - k
2.对每个满足 0 <= i < n 的下标 i ，higher[i] = arr[i] + k
不幸地是，Alice 丢失了全部三个数组。但是，她记住了在数组 lower 和 higher 中出现的整数，但不知道每个整数属于哪个数组。请你帮助 Alice 还原原数组。
给你一个由 2n 个整数组成的整数数组 nums ，其中 恰好 n 个整数出现在 lower ，剩下的出现在 higher ，还原并返回 原数组 arr 。如果出现答案不唯一的情况，返回 任一 有效数组。
注意：生成的测试用例保证存在 至少一个 有效数组 arr 。
 */