import java.util.ArrayList;
import java.util.List;

public class Solution2582 {
    public int passThePillow(int n, int time) {
        // 构造一个周期
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) list.add(i);
        for (int i = n - 1; i > 1; i--) list.add(i);

        int sz = list.size();
        return list.get(time % sz);
    }
}
/*
2582. 递枕头
https://leetcode.cn/problems/pass-the-pillow/

第 335 场周赛 T1。

n 个人站成一排，按从 1 到 n 编号。
最初，排在队首的第一个人拿着一个枕头。每秒钟，拿着枕头的人会将枕头传递给队伍中的下一个人。一旦枕头到达队首或队尾，传递方向就会改变，队伍会继续沿相反方向传递枕头。
- 例如，当枕头到达第 n 个人时，TA 会将枕头传递给第 n - 1 个人，然后传递给第 n - 2 个人，依此类推。
给你两个正整数 n 和 time ，返回 time 秒后拿着枕头的人的编号。
提示：
2 <= n <= 1000
1 <= time <= 1000

模拟。
时间复杂度 O(n)
相似题目: 3178. 找出 K 秒后拿着球的孩子
https://leetcode.cn/problems/find-the-child-who-has-the-ball-after-k-seconds/description/
 */