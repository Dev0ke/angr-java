import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution3072 {
    public int[] resultArray(int[] nums) {
        int n = nums.length;
        // 离散化
        int[] yArr = getDiscrete(nums);

        Fenwick segA = new Fenwick(n);
        Fenwick segB = new Fenwick(n);
        segA.add(getId(yArr, nums[0]), 1);
        segB.add(getId(yArr, nums[1]), 1);
        List<Integer> a = new ArrayList<>();
        List<Integer> b = new ArrayList<>();
        a.add(nums[0]);
        b.add(nums[1]);
        for (int i = 2; i < n; i++) {
            int v = nums[i];
            int vId = getId(yArr, v);
            int greaterCount_a = segA.getSum(n) - segA.getSum(vId);
            int greaterCount_b = segB.getSum(n) - segB.getSum(vId);
            if (greaterCount_a > greaterCount_b) {
                segA.add(vId, 1);
                a.add(v);
            } else if (greaterCount_a < greaterCount_b) {
                segB.add(vId, 1);
                b.add(v);
            } else {
                if (a.size() <= b.size()) {
                    segA.add(vId, 1);
                    a.add(v);
                } else {
                    segB.add(vId, 1);
                    b.add(v);
                }
            }
        }
        a.addAll(b);
        return a.stream().mapToInt(Integer::intValue).toArray();
    }

    private int[] getDiscrete(int[] xArr) {
        Set<Integer> set = new HashSet<>();
        for (int x : xArr) {
            set.add(x);
        }
        int sz = set.size();
        int[] yArr = new int[sz];
        int id = 0;
        for (Integer x : set) {
            yArr[id++] = x;
        }
        Arrays.sort(yArr);
        return yArr;
    }

    private int getId(int[] yArr, int x) {
        return Arrays.binarySearch(yArr, x) + 1;
    }

    static class Fenwick {
        private final int n;
        private final int[] tree;

        public Fenwick(int n) {
            this.n = n;
            this.tree = new int[n + 1];
        }

        int lowbit(int x) {
            return x & -x;
        }

        // nums[x] add k
        void add(int x, int k) {
            while (x <= n) {
                tree[x] += k;
                x += lowbit(x);
            }
        }

        // nums [1,x] 的和
        int getSum(int x) {
            int ans = 0;
            while (x > 0) {
                ans += tree[x];
                x -= lowbit(x);
            }
            return ans;
        }
    }
}
/*
3072. 将元素分配到两个数组中 II
https://leetcode.cn/problems/distribute-elements-into-two-arrays-ii/description/

第 387 场周赛 T4。

给你一个下标从 1 开始、长度为 n 的整数数组 nums 。
现定义函数 greaterCount ，使得 greaterCount(arr, val) 返回数组 arr 中 严格大于 val 的元素数量。
你需要使用 n 次操作，将 nums 的所有元素分配到两个数组 arr1 和 arr2 中。在第一次操作中，将 nums[1] 追加到 arr1 。在第二次操作中，将 nums[2] 追加到 arr2 。之后，在第 i 次操作中：
- 如果 greaterCount(arr1, nums[i]) > greaterCount(arr2, nums[i]) ，将 nums[i] 追加到 arr1 。
- 如果 greaterCount(arr1, nums[i]) < greaterCount(arr2, nums[i]) ，将 nums[i] 追加到 arr2 。
- 如果 greaterCount(arr1, nums[i]) == greaterCount(arr2, nums[i]) ，将 nums[i] 追加到元素数量较少的数组中。
- 如果仍然相等，那么将 nums[i] 追加到 arr1 。
连接数组 arr1 和 arr2 形成数组 result 。例如，如果 arr1 == [1,2,3] 且 arr2 == [4,5,6] ，那么 result = [1,2,3,4,5,6] 。
返回整数数组 result 。
提示：
3 <= n <= 10^5
1 <= nums[i] <= 10^9

离散化 + 树状数组。当然动态开点线段树也可以，但实测跑得慢 900+ms，数组数组 150+ms。
时间复杂度 O(nlogn)
 */