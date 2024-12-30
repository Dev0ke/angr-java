import java.util.Arrays;

public class Solution3074 {
    public int minimumBoxes(int[] apple, int[] capacity) {
        int sum = Arrays.stream(apple).sum();
        reverseSort(capacity);
        int totCap = 0;
        int n = capacity.length;
        for (int i = 0; i < n; i++) {
            totCap += capacity[i];
            if (totCap >= sum) {
                return i + 1;
            }
        }
        return n;
    }

    private void reverseSort(int[] nums) {
        Arrays.sort(nums);
        for (int l = 0, r = nums.length - 1; l < r; l++, r--) {
            int tmp = nums[l];
            nums[l] = nums[r];
            nums[r] = tmp;
        }
    }
}
/*
3074. 重新分装苹果
https://leetcode.cn/problems/apple-redistribution-into-boxes/description/

第 388 场周赛 T1。

给你一个长度为 n 的数组 apple 和另一个长度为 m 的数组 capacity 。
一共有 n 个包裹，其中第 i 个包裹中装着 apple[i] 个苹果。同时，还有 m 个箱子，第 i 个箱子的容量为 capacity[i] 个苹果。
请你选择一些箱子来将这 n 个包裹中的苹果重新分装到箱子中，返回你需要选择的箱子的 最小 数量。
注意，同一个包裹中的苹果可以分装到不同的箱子中。
提示：
1 <= n == apple.length <= 50
1 <= m == capacity.length <= 50
1 <= apple[i], capacity[i] <= 50
输入数据保证可以将包裹中的苹果重新分装到箱子中。

贪心。由大到小装。
时间复杂度 O(nlogn)
 */