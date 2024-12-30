public class SolutionP2753 {
    public int houseCount(Street s, int k) {
        while (!s.isDoorOpen()) {
            s.moveRight();
        }
        int ans = 0;
        for (int i = 1; i <= k; i++) {
            s.moveRight();
            if (s.isDoorOpen()) {
                ans = i;
                s.closeDoor();
            }
        }
        return ans;
    }

    // UT
    interface Street {
        void closeDoor();

        boolean isDoorOpen();

        void moveRight();
    }
}
/*
$2753. 计算一个环形街道上的房屋数量 II
https://leetcode.cn/problems/count-houses-in-a-circular-street-ii/description/

给定一个代表 环形 街道的类 Street 的对象 street 和一个正整数 k，表示街道上房屋的最大数量（也就是说房屋数量不超过 k）。每个房屋的门初始时可以是开着的也可以是关着的（至少有一个房屋的门是开着的）。
刚开始，你站在一座房子的门前。你的任务是计算街道上的房屋数量。
Street 类包含以下函数：
- void closeDoor()：关闭当前房屋的门。
- boolean isDoorOpen()：如果当前房屋的门是开着的返回 true，否则返回 false。
- void moveRight()：向右移动到下一座房屋。
注意：在 环形 街道内，如果将房屋从 1 到 n 编号，则当 i < n 时 housei 右边的房子是 housei+1，housen 右边的房子是 house1。
返回 ans，它表示街道上的房屋数量。
提示：
n 是房屋数量
1 <= n <= k <= 10^5
street 是环形的
输入数据中至少有一扇门是开着的

相似题目: $2728. 计算一个环形街道上的房屋数量
https://leetcode.cn/problems/count-houses-in-a-circular-street/description/
 */