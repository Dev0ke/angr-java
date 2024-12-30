import java.util.Arrays;

public class SolutionP1231 {
    public int maximizeSweetness(int[] sweetness, int k) {
        int left = Arrays.stream(sweetness).min().orElseThrow();
        int right = Arrays.stream(sweetness).sum() + 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            // 边界二分 F, F,..., F, [T, T,..., T]
            // ----------------------^
            if (!checkMid(sweetness, k, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left - 1;
    }

    // 能否使你所分得的巧克力甜度为 mid。TTTFFF
    private boolean checkMid(int[] sweetness, int k, int mid) {
        int cnt = 0;
        int sum = 0;
        for (int sweet : sweetness) {
            sum += sweet;
            if (sum >= mid) {
                cnt++;
                sum = 0;
            }
        }
        // 需要将切割 K 次才能得到 K+1 块
        return cnt > k;
    }
}
/*
$1231. 分享巧克力
https://leetcode.cn/problems/divide-chocolate/

你有一大块巧克力，它由一些甜度不完全相同的小块组成。我们用数组 sweetness 来表示每一小块的甜度。
你打算和 K 名朋友一起分享这块巧克力，所以你需要将切割 K 次才能得到 K+1 块，每一块都由一些 连续 的小块组成。
为了表现出你的慷慨，你将会吃掉 总甜度最小 的一块，并将其余几块分给你的朋友们。
请找出一个最佳的切割策略，使得你所分得的巧克力 总甜度最大，并返回这个 最大总甜度。
提示：
0 <= K < sweetness.length <= 10^4
1 <= sweetness[i] <= 10^5

二分。上界为所有巧克力总甜度，下界为 最小一块巧克力甜度。
 */