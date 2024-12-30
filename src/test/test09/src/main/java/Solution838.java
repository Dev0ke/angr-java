import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution838 {
    private int n;
    private char[] chars;

    public String pushDominoes(String dominoes) {
        n = dominoes.length();
        chars = dominoes.toCharArray();

        Queue<Integer> queue = new LinkedList<>();
        int[] times = new int[n];
        Arrays.fill(times, -1);
        for (int i = 0; i < n; i++) {
            if (chars[i] != '.') {
                queue.add(i);
                times[i] = 0;
            }
        }

        int time = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            time++;
            for (int i = 0; i < size; i++) {
                int curIdx = queue.remove();
                extracted(queue, times, time, curIdx);
            }
        }
        return new String(chars);
    }

    private void extracted(Queue<Integer> queue, int[] times, int time, int curIdx) {
        if (chars[curIdx] == 'L') {
            if (curIdx - 1 >= 0) {
                if (chars[curIdx - 1] == '.' && times[curIdx - 1] == -1) {
                    chars[curIdx - 1] = 'L';
                    times[curIdx - 1] = time;
                    queue.add(curIdx - 1);
                } else if (chars[curIdx - 1] == 'R' && times[curIdx - 1] == time) {
                    // 复位
                    chars[curIdx - 1] = '.';
                }
            }
        } else {
            if (curIdx + 1 < n) {
                if (chars[curIdx + 1] == '.' && times[curIdx + 1] == -1) {
                    chars[curIdx + 1] = 'R';
                    times[curIdx + 1] = time;
                    queue.add(curIdx + 1);
                } else if (chars[curIdx + 1] == 'L' && times[curIdx + 1] == time) {
                    // 复位
                    chars[curIdx + 1] = '.';
                }
            }
        }
    }
}
/*
838. 推多米诺
https://leetcode.cn/problems/push-dominoes/

n 张多米诺骨牌排成一行，将每张多米诺骨牌垂直竖立。在开始时，同时把一些多米诺骨牌向左或向右推。
每过一秒，倒向左边的多米诺骨牌会推动其左侧相邻的多米诺骨牌。同样地，倒向右边的多米诺骨牌也会推动竖立在其右侧的相邻多米诺骨牌。
如果一张垂直竖立的多米诺骨牌的两侧同时有多米诺骨牌倒下时，由于受力平衡， 该骨牌仍然保持不变。
就这个问题而言，我们会认为一张正在倒下的多米诺骨牌不会对其它正在倒下或已经倒下的多米诺骨牌施加额外的力。
给你一个字符串 dominoes 表示这一行多米诺骨牌的初始状态，其中：
- dominoes[i] = 'L'，表示第 i 张多米诺骨牌被推向左侧，
- dominoes[i] = 'R'，表示第 i 张多米诺骨牌被推向右侧，
- dominoes[i] = '.'，表示没有推动第 i 张多米诺骨牌。
返回表示最终状态的字符串。
提示：
n == dominoes.length
1 <= n <= 10^5
dominoes[i] 为 'L'、'R' 或 '.'

多源 BFS
时间复杂度 O(n)
空间复杂度 O(n)
 */