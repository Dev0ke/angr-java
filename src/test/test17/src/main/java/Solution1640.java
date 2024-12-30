import java.util.HashMap;
import java.util.Map;

public class Solution1640 {
    public boolean canFormArray(int[] arr, int[][] pieces) {
        // pieces 中的整数 互不相同（也就是说，如果将 pieces 扁平化成一维数组，数组中的所有整数互不相同）
        Map<Integer, int[]> map = new HashMap<>();
        for (int[] piece : pieces) {
            map.put(piece[0], piece);
        }
        // 对单个 piece 数组，遍历对比
        int idx = 0;
        while (idx < arr.length) {
            if (!map.containsKey(arr[idx])) {
                return false;
            }
            int[] piece = map.get(arr[idx]);
            for (int num : piece) {
                if (arr[idx] != num) {
                    return false;
                }
                idx++;
            }
        }
        return true;
    }
}
/*
1640. 能否连接形成数组
https://leetcode.cn/problems/check-array-formation-through-concatenation/

第 213 场周赛 T1。

给你一个整数数组 arr ，数组中的每个整数 互不相同 。另有一个由整数数组构成的数组 pieces，其中的整数也 互不相同 。
请你以 任意顺序 连接 pieces 中的数组以形成 arr 。但是，不允许 对每个数组 pieces[i] 中的整数重新排序。
如果可以连接 pieces 中的数组形成 arr ，返回 true ；否则，返回 false 。
提示：
1 <= pieces.length <= arr.length <= 100
sum(pieces[i].length) == arr.length
1 <= pieces[i].length <= arr.length
1 <= arr[i], pieces[i][j] <= 100
arr 中的整数 互不相同
pieces 中的整数 互不相同（也就是说，如果将 pieces 扁平化成一维数组，数组中的所有整数互不相同）

模拟。
 */