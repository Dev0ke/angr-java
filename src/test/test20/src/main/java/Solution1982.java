import java.util.TreeMap;

public class Solution1982 {
    public int[] recoverArray(int n, int[] sums) {
        int BIAS = 0;
        for (int x : sums) {
            BIAS = Math.min(BIAS, x);
        }
        BIAS = -BIAS;

        // 将所求的元素中的负数转为正数
        TreeMap<Integer, Integer> st = new TreeMap<>();
        for (int x : sums) {
            insert(st, x + BIAS);
        }

        // 去除 0
        erase(st, st.firstKey());
        int[] ans = new int[n];
        int id = 0;
        ans[id++] = st.firstKey();

        // 若我们已经推出了 ans 中最小的 k 个元素，那么我们从 S 中把这 k 个元素所有子集的和去除。此时 S 中的最小值即为 ans 中的第 (k+1) 小值。
        for (int i = 1; i < n; i++) {
            for (int mask = 0; mask < (1 << i); mask++) {
                if ((mask >> (i - 1) & 1) == 1) {
                    int sum = 0;
                    for (int j = 0; j < i; j++) {
                        if ((mask >> j & 1) == 1) {
                            sum += ans[j];
                        }
                    }
                    erase(st, sum);
                }
            }
            ans[id++] = st.firstKey();
        }

        // 寻找 tmp 中的任意一个子集，使得该子集的和等于 m。把子集中的所有元素变为相反数（乘以 −1）后得到的 ans 即为最终答案。
        for (int mask = 0; mask < (1 << n); mask++) {
            int sum = 0;
            for (int j = 0; j < n; j++) {
                if ((mask >> j & 1) == 1) {
                    sum += ans[j];
                }
            }
            if (sum == BIAS) {
                for (int j = 0; j < n; j++) {
                    if ((mask >> j & 1) == 1) {
                        ans[j] = -ans[j];
                    }
                }
                break;
            }
        }
        return ans;
    }

    private void erase(TreeMap<Integer, Integer> map, int v) {
        map.put(v, map.getOrDefault(v, 0) - 1);
        if (map.get(v) == 0) map.remove(v);
    }

    private void insert(TreeMap<Integer, Integer> map, int v) {
        map.put(v, map.getOrDefault(v, 0) + 1);
    }
}
/*
1982. 从子集的和还原数组
https://leetcode.cn/problems/find-array-given-subset-sums/

第 255 场周赛 T4。

存在一个未知数组需要你进行还原，给你一个整数 n 表示该数组的长度。另给你一个数组 sums ，由未知数组中全部 2n 个 子集的和 组成（子集中的元素没有特定的顺序）。
返回一个长度为 n 的数组 ans 表示还原得到的未知数组。如果存在 多种 答案，只需返回其中 任意一个 。
如果可以由数组 arr 删除部分元素（也可能不删除或全删除）得到数组 sub ，那么数组 sub 就是数组 arr 的一个 子集 。sub 的元素之和就是 arr 的一个 子集的和 。一个空数组的元素之和为 0 。
注意：生成的测试用例将保证至少存在一个正确答案。
提示：
1 <= n <= 15
sums.length == 2^n
-10^4 <= sums[i] <= 10^4

经典问题 https://leetcode.cn/problems/find-array-given-subset-sums/solutions/951195/ti-jie-cong-zi-ji-de-he-huan-yuan-shu-zu-q9qw/
所有元素均为非负数
该限制条件下可以用归纳法求解。在下述解法中，“从 multiset 里去除元素 xxx”指的是去除一个 xxx，而不是去除所有 xxx。
所有元素均为非负数情况：
1、设 S 表示 sums 中所有元素组成的 multiset。
2、首先将 0 从 S 中去除，此时 S 中的最小值即为 ans 中的最小值。
3、若我们已经推出了 ans 中最小的 k 个元素，那么我们从 S 中把这 k 个元素所有子集的和去除。此时 S 中的最小值即为 ans 中的第 (k+1) 小值。
时间复杂度 O(n * 2^n)
 */