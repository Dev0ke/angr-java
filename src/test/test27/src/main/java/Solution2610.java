import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution2610 {
    public List<List<Integer>> findMatrix(int[] nums) {
        int n = nums.length;
        int[] cnt = new int[n + 1];
        for (int x : nums) {
            cnt[x]++;
        }
        Queue<int[]> queue = new LinkedList<>();
        for (int x = 0; x <= n; x++) {
            if (cnt[x] > 0) {
                queue.add(new int[]{x, cnt[x]});
            }
        }

        List<List<Integer>> resList = new ArrayList<>();
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                int[] tuple = queue.remove();
                list.add(tuple[0]);

                tuple[1]--;
                if (tuple[1] > 0) {
                    queue.add(tuple);
                }
            }
            resList.add(list);
        }
        return resList;
    }
}
/*
2610. 转换二维数组
https://leetcode.cn/problems/convert-an-array-into-a-2d-array-with-conditions/

第 339 场周赛 T2。

给你一个整数数组 nums 。请你创建一个满足以下条件的二维数组：
- 二维数组应该 只 包含数组 nums 中的元素。
- 二维数组中的每一行都包含 不同 的整数。
- 二维数组的行数应尽可能 少 。
返回结果数组。如果存在多种答案，则返回其中任何一种。
请注意，二维数组的每一行上可以存在不同数量的元素。
提示：
1 <= nums.length <= 200
1 <= nums[i] <= nums.length

队列，类似层序遍历。
时间复杂度 O(n)
 */