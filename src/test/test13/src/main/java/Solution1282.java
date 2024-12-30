import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution1282 {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        int n = groupSizes.length;
        Map<Integer, List<Integer>> idxListMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            idxListMap.computeIfAbsent(groupSizes[i], key -> new ArrayList<>()).add(i);
        }

        List<List<Integer>> resList = new ArrayList<>();
        for (Map.Entry<Integer, List<Integer>> entry : idxListMap.entrySet()) {
            int key = entry.getKey();
            List<Integer> idxList = entry.getValue();
            for (int i = 0; i < idxList.size(); i += key) {
                List<Integer> subList = idxList.subList(i, i + key);
                resList.add(subList);
            }
        }
        return resList;
    }
}
/*
1282. 用户分组
https://leetcode.cn/problems/group-the-people-given-the-group-size-they-belong-to/

有 n 个人被分成数量未知的组。每个人都被标记为一个从 0 到 n - 1 的唯一ID 。
给定一个整数数组 groupSizes ，其中 groupSizes[i] 是第 i 个人所在的组的大小。例如，如果 groupSizes[1] = 3 ，则第 1 个人必须位于大小为 3 的组中。
返回一个组列表，使每个人 i 都在一个大小为 groupSizes[i] 的组中。
每个人应该 恰好只 出现在 一个组 中，并且每个人必须在一个组中。如果有多个答案，返回其中 任何 一个。可以 保证 给定输入 至少有一个 有效的解。
提示：
groupSizes.length == n
1 <= n <= 500
1 <= groupSizes[i] <= n

贪心。相同 size 的放在一组
 */