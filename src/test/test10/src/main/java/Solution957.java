import java.util.HashMap;
import java.util.Map;

public class Solution957 {
    private static final int LEN = 8;

    public int[] prisonAfterNDays(int[] cells, int n) {
        // int[] => state
        int state = ints2state(cells);

        Map<Integer, Integer> memo = new HashMap<>();
        int day = 0;
        while (day < n) {
            if (memo.containsKey(state)) {
                // 两次相同情形间隔 k 天
                int k = day - memo.get(state);
                day += (n - day) / k * k;
            }
            // 第 n 天时的牢房
            memo.put(state, day);

            if (day < n) {
                day++;
                state = nextState(state);
            }
        }
        // state => int[]
        return state2ints(state);
    }

    private int ints2state(int[] cells) {
        int state = 0;
        for (int i = 0; i < LEN; i++) {
            if (cells[i] == 1) {
                state |= (1 << (LEN - 1 - i));
            }
        }
        return state;
    }

    private int[] state2ints(int state) {
        int[] cells = new int[LEN];
        for (int i = 0; i < LEN; i++) {
            if (((state >> i) & 1) == 1) {
                cells[LEN - 1 - i] = 1;
            }
        }
        return cells;
    }

    private int nextState(int state) {
        int nextState = 0;
        for (int i = 1; i <= 6; i++) {
            // 如果一间牢房的两个相邻的房间都被占用或都是空的，那么该牢房就会被占用。
            int pre = (state >> (i - 1)) & 1;
            int next = (state >> (i + 1)) & 1;
            if (pre == next) {
                nextState |= (1 << i);
            }
        }
        return nextState;
    }
}
/*
957. N 天后的牢房
https://leetcode.cn/problems/prison-cells-after-n-days/

监狱中 8 间牢房排成一排，每间牢房可能被占用或空置。
每天，无论牢房是被占用或空置，都会根据以下规则进行变更：
- 如果一间牢房的两个相邻的房间都被占用或都是空的，那么该牢房就会被占用。
- 否则，它就会被空置。
注意：由于监狱中的牢房排成一行，所以行中的第一个和最后一个牢房不存在两个相邻的房间。
给你一个整数数组 cells ，用于表示牢房的初始状态：如果第 i 间牢房被占用，则 cell[i]==1，否则 cell[i]==0 。另给你一个整数 n 。
请你返回 n 天后监狱的状况（即，按上文描述进行 n 次变更）。
提示：
cells.length == 8
cells[i] 为 0 或 1
1 <= n <= 10^9

牢房状态最多 2^8 = 256 种，因此必然出现重复，找到循环后取余以大幅减少重复运算即可。
Trick: 可以将数组状态映射成整数
 */