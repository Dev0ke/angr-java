import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution1505 {
    public String minInteger(String num, int k) {
        int len = num.length();

        List<Queue<Integer>> posList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            posList.add(new LinkedList<>());
        }
        for (int i = 0; i < len; i++) {
            int idx = num.charAt(i) - '0';
            posList.get(idx).add(i + 1);
        }

        BIT bit = new BIT(len);
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 1; i <= len; i++) {
            for (int j = 0; j < 10; j++) {
                if (!posList.get(j).isEmpty()) {
                    int behind = bit.getsum(posList.get(j).element(), len - 1);
                    int dist = posList.get(j).element() + behind - i;
                    if (dist <= k) {
                        bit.add(posList.get(j).remove(), 1);
                        stringBuilder.append(j);
                        k -= dist;
                        break;
                    }
                }
            }
        }
        return stringBuilder.toString();
    }

    private static class BIT {
        private final int N;
        private final int[] tree;

        // O(n) 建树
        public BIT(int n) {
            this.N = n;
            this.tree = new int[N + 1];
        }

        public int lowbit(int x) {
            return x & (-x);
        }

        // nums[x] add k
        public void add(int x, int k) {
            while (x <= N) {
                tree[x] += k;
                x += lowbit(x);
            }
        }

        // nums [1,x] 的和
        public int getsum(int x) {
            int ans = 0;
            while (x >= 1) {
                ans += tree[x];
                x -= lowbit(x);
            }
            return ans;
        }

        // nums [l,r] 的和
        public int getsum(int l, int r) {
            return getsum(r + 1) - getsum(l);
        }
    }
}
/*
1505. 最多 K 次交换相邻数位后得到的最小整数
https://leetcode.cn/problems/minimum-possible-integer-after-at-most-k-adjacent-swaps-on-digits/

第 196 场周赛 T4。

给你一个字符串 num 和一个整数 k 。其中，num 表示一个很大的整数，字符串中的每个字符依次对应整数上的各个 数位 。
你可以交换这个整数相邻数位的数字 最多 k 次。
请你返回你能得到的最小整数，并以字符串形式返回。
提示：
1 <= num.length <= 30000
num 只包含 数字 且不含有 前导 0 。
1 <= k <= 10^9

贪心，树状数组
时间复杂度 O(nlogn)
空间复杂度 O(n)
 */