import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Solution2248 {
    public List<Integer> intersection(int[][] nums) {
        Set<Integer> resSet = Arrays.stream(nums[0]).boxed().collect(Collectors.toSet());
        for (int[] num : nums) {
            Set<Integer> hashSet = Arrays.stream(num).boxed().collect(Collectors.toSet());
            resSet.retainAll(hashSet);
        }
        List<Integer> resList = new ArrayList<>(resSet);
        Collections.sort(resList);
        return resList;
    }
}
/*
2248. 多个数组求交集
https://leetcode.cn/problems/intersection-of-multiple-arrays/

第 290 场周赛 T1。

给你一个二维整数数组 nums ，其中 nums[i] 是由 不同 正整数组成的一个非空数组，按 升序排列 返回一个数组，数组中的每个元素在 nums 所有数组 中都出现过。
提示：
1 <= nums.length <= 1000
1 <= sum(nums[i].length) <= 1000
1 <= nums[i][j] <= 1000
nums[i] 中的所有值 互不相同

求交集后排序返回。
时间复杂度 O(nlogn)
 */
