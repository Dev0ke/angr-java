import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution672 {
    public int flipLights(int n, int presses) {
        Set<Integer> states = new HashSet<>();
        for (int mask = 0; mask < 1 << 4; mask++) {
            int[] pressArr = new int[4];
            for (int j = 0; j < 4; j++) {
                pressArr[j] = (mask >> j) & 1;
            }
            int sum = Arrays.stream(pressArr).sum();
            if (sum % 2 == presses % 2 && sum <= presses) {
                int state = pressArr[0] ^ pressArr[2] ^ pressArr[3];
                if (n >= 2) {
                    state |= (pressArr[0] ^ pressArr[1]) << 1;
                }
                if (n >= 3) {
                    state |= (pressArr[0] ^ pressArr[2]) << 2;
                }
                if (n >= 4) {
                    state |= (pressArr[0] ^ pressArr[1] ^ pressArr[3]) << 3;
                }
                states.add(state);
            }
        }
        return states.size();
    }
}
/*
672. 灯泡开关 Ⅱ
https://leetcode.cn/problems/bulb-switcher-ii/description/

房间中有 n 只已经打开的灯泡，编号从 1 到 n 。墙上挂着 4 个开关 。
这 4 个开关各自都具有不同的功能，其中：
- 开关 1 ：反转当前所有灯的状态（即开变为关，关变为开）
- 开关 2 ：反转编号为偶数的灯的状态（即 0, 2, 4, ...）
- 开关 3 ：反转编号为奇数的灯的状态（即 1, 3, ...）
- 开关 4 ：反转编号为 j = 3k + 1 的灯的状态，其中 k = 0, 1, 2, ...（即 1, 4, 7, 10, ...）
你必须 恰好 按压开关 presses 次。每次按压，你都需要从 4 个开关中选出一个来执行按压操作。
给你两个整数 n 和 presses ，执行完所有按压之后，返回 不同可能状态 的数量。
提示：
1 <= n <= 1000
0 <= presses <= 1000

降低搜索空间。
不用考虑按的顺序 + 只需考虑每个按钮被按了奇数次还是偶数次
编号 6k+1 受 1/3/4 影响
编号 6k+2,6k+6 受 1/2 影响
编号 6k+3,6k+5 受 1/3 影响
编号 6k+4 受 1/2/4 影响
因此，只需要考虑四个灯泡，即可知道所有灯泡最后的状态了。
时间复杂度 O(1)。
相似题目: 319. 灯泡开关
https://leetcode.cn/problems/bulb-switcher/
 */