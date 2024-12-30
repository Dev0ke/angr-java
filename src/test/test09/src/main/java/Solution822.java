import java.util.HashSet;
import java.util.Set;

public class Solution822 {
    public int flipgame(int[] fronts, int[] backs) {
        int n = fronts.length;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            if (fronts[i] == backs[i]) {
                set.add(fronts[i]);
            }
        }

        int ans = Integer.MAX_VALUE;
        for (int x : fronts) {
            if (!set.contains(x)) {
                ans = Math.min(ans, x);
            }
        }
        for (int x : backs) {
            if (!set.contains(x)) {
                ans = Math.min(ans, x);
            }
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}
/*
822. 翻转卡片游戏
https://leetcode.cn/problems/card-flipping-game/

在桌子上有 n 张卡片，每张卡片的正面和背面都写着一个正数（正面与背面上的数有可能不一样）。
我们可以先翻转任意张卡片，然后选择其中一张卡片。
如果选中的那张卡片背面的数字 x 与任意一张卡片的正面的数字都不同，那么这个数字是我们想要的数字。
哪个数是这些想要的数字中最小的数（找到这些数中的最小值）呢？如果没有一个数字符合要求的，输出 0 。
其中, fronts[i] 和 backs[i] 分别代表第 i 张卡片的正面和背面的数字。
如果我们通过翻转卡片来交换正面与背面上的数，那么当初在正面的数就变成背面的数，背面的数就变成正面的数。
提示：
n == fronts.length == backs.length
1 <= n <= 1000
1 <= fronts[i], backs[i] <= 2000

阅读理解。枚举。
如果 fronts[i] == backs[i]，那么 fronts[i] 不可能是答案。
 */