import java.util.ArrayList;
import java.util.List;

public class Solution3069 {
    public int[] resultArray(int[] nums) {
        int n = nums.length;
        List<Integer> a = new ArrayList<>();
        List<Integer> b = new ArrayList<>();
        a.add(nums[0]);
        b.add(nums[1]);
        for (int i = 2; i < n; i++) {
            if (a.get(a.size() - 1) > b.get(b.size() - 1)) {
                a.add(nums[i]);
            } else {
                b.add(nums[i]);
            }
        }
        a.addAll(b);
        return a.stream().mapToInt(Integer::intValue).toArray();
    }
}
/*
3069. 将元素分配到两个数组中 I
https://leetcode.cn/problems/distribute-elements-into-two-arrays-i/description/

第 387 场周赛 T1。

给你一个下标从 1 开始、包含 不同 整数的数组 nums ，数组长度为 n 。
你需要通过 n 次操作，将 nums 中的所有元素分配到两个数组 arr1 和 arr2 中。在第一次操作中，将 nums[1] 追加到 arr1 。在第二次操作中，将 nums[2] 追加到 arr2 。之后，在第 i 次操作中：
- 如果 arr1 的最后一个元素 大于 arr2 的最后一个元素，就将 nums[i] 追加到 arr1 。否则，将 nums[i] 追加到 arr2 。
通过连接数组 arr1 和 arr2 形成数组 result 。例如，如果 arr1 == [1,2,3] 且 arr2 == [4,5,6] ，那么 result = [1,2,3,4,5,6] 。
返回数组 result 。
提示：
3 <= n <= 50
1 <= nums[i] <= 100
nums中的所有元素都互不相同。

模拟。
时间复杂度 O(n)。
 */