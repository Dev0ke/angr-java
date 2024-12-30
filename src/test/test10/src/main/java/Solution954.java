import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution954 {
    public boolean canReorderDoubled(int[] arr) {
        Map<Integer, Integer> cntMp = new HashMap<>();
        for (int x : arr) {
            cntMp.merge(x, 1, Integer::sum);
        }
        if (cntMp.getOrDefault(0, 0) % 2 != 0) {
            return false;
        }

        List<Integer> vals = new ArrayList<>(cntMp.keySet());
        vals.sort(Comparator.comparingInt(Math::abs));

        for (int x : vals) {
            int cnt_x = cntMp.get(x);
            if (cntMp.getOrDefault(2 * x, 0) < cnt_x) { // 无法找到足够的 2x 与 x 配对
                return false;
            }
            cntMp.merge(2 * x, -cnt_x, Integer::sum);
        }
        return true;
    }
}
/*
954. 二倍数对数组
https://leetcode.cn/problems/array-of-doubled-pairs/description/

给定一个长度为偶数的整数数组 arr，只有对 arr 进行重组后可以满足 “对于每个 0 <= i < len(arr) / 2，都有 arr[2 * i + 1] = 2 * arr[2 * i]” 时，返回 true；否则，返回 false。
提示：
0 <= arr.length <= 3 * 10^4
arr.length 是偶数
-10^5 <= arr[i] <= 10^5

哈希表统计频次。
 */