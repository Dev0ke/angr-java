import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;

public class Solution975 {
    public int oddEvenJumps(int[] arr) {
        int n = arr.length;
        Integer[] ids = new Integer[n];
        for (int i = 0; i < n; i++) ids[i] = i;
        Arrays.sort(ids, Comparator.comparingInt(o -> arr[o]));
        Integer[] odd_next = make(ids);
        Arrays.sort(ids, Comparator.comparingInt(o -> -arr[o]));
        Integer[] even_next = make(ids);

        int[] odd = new int[n];
        int[] even = new int[n];
        odd[n - 1] = even[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            if (odd_next[i] != null) odd[i] = even[odd_next[i]];
            if (even_next[i] != null) even[i] = odd[even_next[i]];
        }
        return Arrays.stream(odd).sum();
    }

    private Integer[] make(Integer[] ids) {
        Integer[] ans = new Integer[ids.length];
        Deque<Integer> st = new ArrayDeque<>();
        for (Integer i : ids) {
            while (!st.isEmpty() && i > st.peek()) {
                ans[st.pop()] = i;
            }
            st.push(i);
        }
        return ans;
    }
}
/*
975. 奇偶跳
https://leetcode.cn/problems/odd-even-jump/description/

给定一个整数数组 A，你可以从某一起始索引出发，跳跃一定次数。在你跳跃的过程中，第 1、3、5... 次跳跃称为奇数跳跃，而第 2、4、6... 次跳跃称为偶数跳跃。
你可以按以下方式从索引 i 向后跳转到索引 j（其中 i < j）：
- 在进行奇数跳跃时（如，第 1，3，5... 次跳跃），你将会跳到索引 j，使得 A[i] <= A[j]，A[j] 是可能的最小值。如果存在多个这样的索引 j，你只能跳到满足要求的最小索引 j 上。
- 在进行偶数跳跃时（如，第 2，4，6... 次跳跃），你将会跳到索引 j，使得 A[i] >= A[j]，A[j] 是可能的最大值。如果存在多个这样的索引 j，你只能跳到满足要求的最小索引 j 上。
- （对于某些索引 i，可能无法进行合乎要求的跳跃。）
如果从某一索引开始跳跃一定次数（可能是 0 次或多次），就可以到达数组的末尾（索引 A.length - 1），那么该索引就会被认为是好的起始索引。
返回好的起始索引的数量。
提示：
1 <= A.length <= 20000
0 <= A[i] < 100000

单调栈。
时间复杂度 O(nlogn)。
 */