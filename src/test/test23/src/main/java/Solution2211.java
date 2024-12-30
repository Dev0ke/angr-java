public class Solution2211 {
    public int countCollisions(String directions) {
        int len = directions.length();
        char[] chars = directions.toCharArray();

        int sum = 0;
        int cnt = 0;
        // 左往右
        for (int i = 0; i < len; i++) {
            if (chars[i] == 'R') {
                cnt++;
            } else {
                sum += cnt;
                cnt = 0;
            }
        }

        // 右往左
        cnt = 0;
        for (int i = len - 1; i >= 0; i--) {
            if (chars[i] == 'L') {
                cnt++;
            } else {
                sum += cnt;
                cnt = 0;
            }
        }

        return sum;
    }
}
/*
2211. 统计道路上的碰撞次数
https://leetcode.cn/problems/count-collisions-on-a-road/

第 285 场周赛 T2。

在一条无限长的公路上有 n 辆汽车正在行驶。汽车按从左到右的顺序按从 0 到 n - 1 编号，每辆车都在一个 独特的 位置。
给你一个下标从 0 开始的字符串 directions ，长度为 n 。directions[i] 可以是 'L'、'R' 或 'S' 分别表示第 i 辆车是向 左 、向 右 或者 停留 在当前位置。每辆车移动时 速度相同 。
碰撞次数可以按下述方式计算：
- 当两辆移动方向 相反 的车相撞时，碰撞次数加 2 。
- 当一辆移动的车和一辆静止的车相撞时，碰撞次数加 1 。
碰撞发生后，涉及的车辆将无法继续移动并停留在碰撞位置。除此之外，汽车不能改变它们的状态或移动方向。
返回在这条道路上发生的 碰撞总次数 。
提示：
1 <= directions.length <= 10^5
directions[i] 的值为 'L'、'R' 或 'S'

稍作分析，可以发现 "RL"=2; "RS"/"SL"=1，因此可以将 R 跟 S 拆开统计，每次 +1 即可。
时间复杂度 O(n)
 */