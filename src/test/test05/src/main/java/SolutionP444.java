import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class SolutionP444 {
    public boolean sequenceReconstruction(int[] nums, List<List<Integer>> sequences) {
        int n = nums.length;

        // 拓扑排序
        Map<Integer, List<Integer>> adj = new HashMap<>();
        int[] inDegrees = new int[n + 1];
        for (List<Integer> seq : sequences) {
            for (int i = 1; i < seq.size(); i++) {
                int from = seq.get(i - 1);
                int to = seq.get(i);

                adj.computeIfAbsent(from, key -> new ArrayList<>()).add(to);
                inDegrees[to]++;
            }
        }

        // 入度为 0 进队列
        Queue<Integer> queue = new LinkedList<>();
        // 序列 org 是 1 到 n 整数的排列
        for (int i = 1; i <= n; i++) {
            if (inDegrees[i] == 0) {
                queue.add(i);
            }
        }
        List<Integer> resList = new ArrayList<>();
        // 从 seqs 重建唯一的序列
        while (queue.size() == 1) {
            int cur = queue.remove();
            resList.add(cur);

            for (int next : adj.getOrDefault(cur, new ArrayList<>())) {
                inDegrees[next]--;
                if (inDegrees[next] == 0) {
                    queue.add(next);
                }
            }
        }
        int[] res = resList.stream().mapToInt(i -> i).toArray();
        return Arrays.equals(nums, res);
    }
}
/*
$444. 序列重建
https://leetcode.cn/problems/sequence-reconstruction/

给定一个长度为 n 的整数数组 nums ，其中 nums 是范围为 [1，n] 的整数的排列。还提供了一个 2D 整数数组 sequences ，其中 sequences[i] 是 nums 的子序列。
检查 nums 是否是唯一的最短 超序列 。最短 超序列 是 长度最短 的序列，并且所有序列 sequences[i] 都是它的子序列。对于给定的数组 sequences ，可能存在多个有效的 超序列 。
- 例如，对于 sequences = [[1,2],[1,3]] ，有两个最短的 超序列 ，[1,2,3] 和 [1,3,2] 。
- 而对于 sequences = [[1,2],[1,3],[1,2,3]] ，唯一可能的最短 超序列 是 [1,2,3] 。[1,2,3,4] 是可能的超序列，但不是最短的。
如果 nums 是序列的唯一最短 超序列 ，则返回 true ，否则返回 false 。
子序列 是一个可以通过从另一个序列中删除一些元素或不删除任何元素，而不改变其余元素的顺序的序列。
提示：
n == nums.length
1 <= n <= 10^4
nums 是 [1, n] 范围内所有整数的排列
1 <= sequences.length <= 10^4
1 <= sequences[i].length <= 10^4
1 <= sum(sequences[i].length) <= 10^5
1 <= sequences[i][j] <= n
sequences 的所有数组都是 唯一 的
sequences[i] 是 nums 的一个子序列

拓扑排序。
 */