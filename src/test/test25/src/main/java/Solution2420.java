import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

public class Solution2420 {
    public List<Integer> goodIndices(int[] nums, int k) {
        int n = nums.length;

        List<Integer> resList = new ArrayList<>();
        // 特判
        if (k == 1) {
            for (int i = 1; i < n - 1; i++) {
                resList.add(i);
            }
            return resList;
        }

        // 预处理差值
        int[] diff = new int[n];
        for (int i = 1; i < n; i++) {
            diff[i] = nums[i] - nums[i - 1];
        }

        // 左往右
        BitSet bitSet1 = new BitSet(n);
        int cnt = 0;
        for (int i = 2; i < n; i++) {
            if (diff[i - 1] <= 0) {
                cnt++;
                if (cnt >= k - 1) {
                    bitSet1.set(i);
                }
            } else {
                cnt = 0;
            }
        }

        // 右往左
        cnt = 0;
        BitSet bitSet2 = new BitSet(n);
        for (int i = n - 2; i - 1 >= 0; i--) {
            if (diff[i + 1] >= 0) {
                cnt++;
                if (cnt >= k - 1) {
                    bitSet2.set(i - 1);
                }
            } else {
                cnt = 0;
            }
        }

        // 取交集
        for (int i = 0; i < n; i++) {
            if (bitSet1.get(i) && bitSet2.get(i)) {
                resList.add(i);
            }
        }
        return resList;
    }
}
/*
2420. 找到所有好下标
https://leetcode.cn/problems/find-all-good-indices/

第 312 场周赛 T3。

给你一个大小为 n 下标从 0 开始的整数数组 nums 和一个正整数 k 。
对于 k <= i < n - k 之间的一个下标 i ，如果它满足以下条件，我们就称它为一个 好 下标：
- 下标 i 之前 的 k 个元素是 非递增的 。
- 下标 i 之后 的 k 个元素是 非递减的 。
按 升序 返回所有好下标。
提示：
n == nums.length
3 <= n <= 10^5
1 <= nums[i] <= 10^6
1 <= k <= n / 2

线性遍历，分别从左到右、从右到左统计符合单侧要求的下标，二者取并集即可。
时间复杂度 O(n)
 */