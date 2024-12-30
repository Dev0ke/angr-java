public class Solution1535 {
    public int getWinner(int[] arr, int k) {
        int ans = arr[0];
        int cnt = 0;
        for (int i = 1; i < arr.length; i++) {
            if (ans < arr[i]) {
                cnt = 1;
                ans = arr[i];
            } else {
                cnt++;
            }
            // 提前退出
            if (cnt == k) {
                return ans;
            }
        }
        return ans;
    }
}
/*
1535. 找出数组游戏的赢家
https://leetcode.cn/problems/find-the-winner-of-an-array-game/

第 200 场周赛 T2。

给你一个由 不同 整数组成的整数数组 arr 和一个整数 k 。
每回合游戏都在数组的前两个元素（即 arr[0] 和 arr[1] ）之间进行。比较 arr[0] 与 arr[1] 的大小，
较大的整数将会取得这一回合的胜利并保留在位置 0 ，较小的整数移至数组的末尾。当一个整数赢得 k 个连续回合时，游戏结束，该整数就是比赛的 赢家 。
返回赢得比赛的整数。
题目数据 保证 游戏存在赢家。
提示：
2 <= arr.length <= 10^5
1 <= arr[i] <= 10^6
arr 所含的整数 各不相同 。
1 <= k <= 10^9

用 List<Integer> 根据题意进行模拟可以通过，但实际上并不需要移动数组：
arr[0] 与 arr[1] 的较大值与 arr[2] 比较
然后较大值再与 arr[3] 比较
然后较大值再与 arr[4] 比较……
若一直比较至数组末还是没达到 k，返回的就是 arr 数组的最大值
 */