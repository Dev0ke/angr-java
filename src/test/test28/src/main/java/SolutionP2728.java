public class SolutionP2728 {
    public int houseCount(Street street, int k) {
        for (int i = 0; i < k; i++) {
            street.closeDoor();
            street.moveRight();
        }
        int ans = 1;
        street.openDoor();
        street.moveRight();
        while (!street.isDoorOpen()) {
            ans++;
            street.moveRight();
        }
        return ans;
    }

    // UT
    interface Street {
        void openDoor();

        void closeDoor();

        boolean isDoorOpen();

        void moveRight();

        void moveLeft();
    }
}
/*
$2728. 计算一个环形街道上的房屋数量
https://leetcode.cn/problems/count-houses-in-a-circular-street/description/

给定一个代表环形街道的类 Street 和一个正整数 k，表示街道上房屋的最大数量（也就是说房屋数量不超过 k ）。每个房屋的门初始时可以是开着的也可以是关着的。
刚开始，你站在一座房子的门前。你的任务是计算街道上的房屋数量。
Street 类包含以下函数：
- void openDoor() ：打开当前房屋的门。
- void closeDoor() ：关闭当前房屋的门。
- boolean isDoorOpen() ：如果当前房屋的门是开着的返回 true ，否则返回 false 。
- void moveRight() ：向右移动到下一座房屋。
- void moveLeft() ：向左移动到上一座房屋。
返回 ans，它表示街道上的房屋数量。
解释：
n 是房屋数量
1 <= n <= k <= 10^3

相似题目: $2753. 计算一个环形街道上的房屋数量 II
https://leetcode.cn/problems/count-houses-in-a-circular-street-ii/description/
 */