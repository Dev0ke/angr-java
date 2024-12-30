public class SolutionP1274 {
    public int countShips(Sea sea, int[] topRight, int[] bottomLeft) {
        return countShips(sea, topRight, bottomLeft, false);
    }

    private int countShips(Sea sea, int[] topRight, int[] bottomLeft, boolean claim) {
        int x1 = topRight[0], y1 = topRight[1];
        int x2 = bottomLeft[0], y2 = bottomLeft[1];

        if (x1 < x2 || y1 < y2) {
            return 0;
        }

        boolean judge = (claim ? true : sea.hasShips(topRight, bottomLeft));
        if (!judge) {
            return 0;
        }
        if (x1 == x2 && y1 == y2) {
            return 1;
        }

        if (x1 == x2) {
            int ymid = (y1 + y2) / 2;
            int A = countShips(sea, new int[]{x1, ymid}, new int[]{x1, y2});
            return A + countShips(sea, new int[]{x1, y1}, new int[]{x1, ymid + 1}, A == 0);
        } else {
            int xmid = (x1 + x2) / 2;
            int A = countShips(sea, new int[]{xmid, y1}, new int[]{x2, y2});
            return A + countShips(sea, new int[]{x1, y1}, new int[]{xmid + 1, y2}, A == 0);
        }
    }

    interface Sea {
        boolean hasShips(int[] topRight, int[] bottomLeft);
    }
}
/*
$1274. 矩形内船只的数目
https://leetcode.cn/problems/number-of-ships-in-a-rectangle/description/

(此题是 交互式问题 )
在用笛卡尔坐标系表示的二维海平面上，有一些船。每一艘船都在一个整数点上，且每一个整数点最多只有 1 艘船。
有一个函数 Sea.hasShips(topRight, bottomLeft) ，输入参数为右上角和左下角两个点的坐标，当且仅当这两个点所表示的矩形区域（包含边界）内至少有一艘船时，这个函数才返回 true ，否则返回 false 。
给你矩形的右上角 topRight 和左下角 bottomLeft 的坐标，请你返回此矩形内船只的数目。题目保证矩形内 至多只有 10 艘船。
调用函数 hasShips 超过400次 的提交将被判为 错误答案（Wrong Answer） 。同时，任何尝试绕过评测系统的行为都将被取消比赛资格。
提示：
ships 数组只用于评测系统内部初始化。你必须“蒙着眼睛”解决这个问题。你无法得知 ships 的信息，所以只能通过调用 hasShips 接口来求解。
0 <= bottomLeft[0] <= topRight[0] <= 1000
0 <= bottomLeft[1] <= topRight[1] <= 1000
topRight != bottomLeft

分治 + 二分查找
https://leetcode.cn/problems/number-of-ships-in-a-rectangle/solutions/101395/ju-xing-nei-chuan-zhi-de-shu-mu-by-leetcode-soluti/
 */