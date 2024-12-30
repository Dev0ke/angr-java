import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution2584 {
    public int findValidSplit2(int[] nums) {
        int n = nums.length;
        Map<Integer, int[]> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            List<Integer> factorPrime = getFactorPrime(nums[i]);
            for (int x : factorPrime) {
                if (!map.containsKey(x)) {
                    map.put(x, new int[]{i, i});
                } else {
                    map.get(x)[1] = i;
                }
            }
        }

        // f[i] 表示下标 starti 对应的最长 endi
        int[] f = new int[n];
        for (Map.Entry<Integer, int[]> entry : map.entrySet()) {
            int[] val = entry.getValue();
            f[val[0]] = Math.max(f[val[0]], val[1]);
        }

        // 能到达的最远距离下标，当前下标
        int maxR = 0, curR = 0;
        // [1, time) 返回所需片段的最小数目
        for (int i = 0; i < n - 1; i++) {
            maxR = Math.max(maxR, f[i]);
            if (i == curR) {
                if (i == maxR) {
                    return i;
                }
                curR = maxR;
            }
        }
        return -1;
    }

    private static List<Integer> getFactorPrime(int num) {
        List<Integer> resList = new ArrayList<>();
        for (int i = 2; i * i <= num; i++) {
            // 如果 i 能够整除 N，说明 i 为 N 的一个质因子。
            if (num % i == 0) {
                while (num % i == 0) {
                    num /= i;
                }
                resList.add(i);
            }
        }
        // 说明再经过操作之后 N 留下了一个素数
        if (num != 1) {
            resList.add(num);
        }
        return resList;
    }

    private static final int MAX_N = (int) (1e6 + 5);

    public int findValidSplit(int[] nums) {
        int n = nums.length;
        // left[p] 表示质数 p 首次出现的下标
        int[] left = new int[MAX_N];
        Arrays.fill(left, -1);
        // right[i] 表示左端点为 i 的区间的右端点的最大值
        int[] right = new int[n];

        for (int i = 0; i < n; i++) {
            int x = nums[i];
            for (int d = 2; d * d <= x; d++) {
                if (x % d == 0) {
                    if (left[d] == -1) {
                        // 第一次遇到质数 d
                        left[d] = i;
                    } else {
                        // 记录左端点对应的右端点的最大值
                        right[left[d]] = i;
                    }
                    // for (x /= d; x % d == 0; x /= d) ;
                    x /= d;
                    while (x % d == 0) {
                        x /= d;
                    }
                }
            }
            if (x > 1) {
                if (left[x] == -1) {
                    left[x] = i;
                } else {
                    right[left[x]] = i;
                }
            }
        }

        int maxR = 0;
        for (int i = 0; i < n; i++) {
            if (i > maxR) {
                return maxR;
            }
            maxR = Math.max(maxR, right[i]);
        }
        return -1;
    }
}
/*
2584. 分割数组使乘积互质
https://leetcode.cn/problems/split-the-array-to-make-coprime-products/

第 335 场周赛 T3。

给你一个长度为 n 的整数数组 nums ，下标从 0 开始。
如果在下标 i 处 分割 数组，其中 0 <= i <= n - 2 ，使前 i + 1 个元素的乘积和剩余元素的乘积互质，则认为该分割 有效 。
- 例如，如果 nums = [2, 3, 3] ，那么在下标 i = 0 处的分割有效，因为 2 和 9 互质，而在下标 i = 1 处的分割无效，因为 6 和 3 不互质。在下标 i = 2 处的分割也无效，因为 i == n - 1 。
返回可以有效分割数组的最小下标 i ，如果不存在有效分割，则返回 -1 。
当且仅当 gcd(val1, val2) == 1 成立时，val1 和 val2 这两个值才是互质的，其中 gcd(val1, val2) 表示 val1 和 val2 的最大公约数。
提示：
n == nums.length
1 <= n <= 10^4
1 <= nums[i] <= 10^6

分解质因数 + 贪心
考虑每个质因数的 第一次出现下标 与 最后一次出现下标。然后类似跳跃游戏，看从下标 0 最远到达多远，这部分都是不能分割的。
时间复杂度 O(n * √n)
相似题目: 45. 跳跃游戏 II
https://leetcode.cn/problems/jump-game-ii/
 */