public class Solution457 {
    private int[] nums;
    private int n;

    public boolean circularArrayLoop(int[] nums) {
        this.nums = nums;
        this.n = nums.length;
        // 坑：不一定要从 0 开始
        for (int i = 0; i < n; i++) {
            if (check(i)) {
                return true;
            }
        }
        return false;
    }

    private boolean check(int start) {
        int cx = start;
        boolean neg = nums[start] < 0;
        int k = 1;
        while (true) {
            if (k > n) {
                return false;
            }
            int nx = ((cx + nums[cx]) % n + n) % n;
            if (nums[nx] > 0 && neg || nums[nx] < 0 && !neg) {
                return false;
            }
            if (nx == start) {
                return k > 1;
            }
            cx = nx;
            k++;
        }
    }
}
/*
457. 环形数组是否存在循环
https://leetcode.cn/problems/circular-array-loop/

存在一个不含 0 的 环形 数组 nums ，每个 nums[i] 都表示位于下标 i 的角色应该向前或向后移动的下标个数：
- 如果 nums[i] 是正数，向前（下标递增方向）移动 |nums[i]| 步
- 如果 nums[i] 是负数，向后（下标递减方向）移动 |nums[i]| 步
因为数组是 环形 的，所以可以假设从最后一个元素向前移动一步会到达第一个元素，而第一个元素向后移动一步会到达最后一个元素。
数组中的 循环 由长度为 k 的下标序列 seq 标识：
- 遵循上述移动规则将导致一组重复下标序列 seq[0] -> seq[1] -> ... -> seq[k - 1] -> seq[0] -> ...
- 所有 nums[seq[j]] 应当不是 全正 就是 全负
- k > 1
如果 nums 中存在循环，返回 true ；否则，返回 false 。
提示：
1 <= nums.length <= 5000
-1000 <= nums[i] <= 1000
nums[i] != 0

模拟。坑：不一定要从 0 开始
时间复杂度 O(n^2)
 */