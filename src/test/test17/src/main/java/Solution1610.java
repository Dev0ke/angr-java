import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution1610 {
    public int visiblePoints(List<List<Integer>> points, int angle, List<Integer> location) {
        // 预处理
        int cntSame = 0;
        int locationX = location.get(0);
        int locationY = location.get(1);
        List<Double> degreeList = new ArrayList<>();
        for (List<Integer> point : points) {
            int pointX = point.get(0);
            int pointY = point.get(1);
            if (pointX == locationX && pointY == locationY) {
                cntSame++;
                continue;
            }
            // atan2 函数返回的是原点至点 (x,y) 的方位角，即与 x 轴的夹角。也可以理解为复数 x+yi 的辐角。
            // 返回值的单位为弧度，取值范围为 (-PI, PI]
            double degree = Math.atan2(pointY - locationY, pointX - locationX);
            degreeList.add(degree);
        }
        Collections.sort(degreeList);
        int size = degreeList.size();
        for (int i = 0; i < size; i++) {
            degreeList.add(degreeList.get(i) + 2 * Math.PI);
        }

        // 滑动窗口
        int max = 0;
        int right = 0;
        double toDegree = angle * Math.PI / 180;
        for (int i = 0; i < size; i++) {
            double cur = degreeList.get(i) + toDegree;
            while (right < degreeList.size() && degreeList.get(right) <= cur) {
                right++;
            }
            max = Math.max(max, right - i);
        }
        return max + cntSame;
    }
}
/*
1610. 可见点的最大数目
https://leetcode.cn/problems/maximum-number-of-visible-points/

第 209 场周赛 T3。

给你一个点数组 points 和一个表示角度的整数 angle ，你的位置是 location ，
其中 location = [posx, posy] 且 points[i] = [xi, yi] 都表示 X-Y 平面上的整数坐标。
最开始，你面向东方进行观测。你 不能 进行移动改变位置，但可以通过 自转 调整观测角度。换句话说，posx 和 posy 不能改变。
你的视野范围的角度用 angle 表示， 这决定了你观测任意方向时可以多宽。设 d 为你逆时针自转旋转的度数，
那么你的视野就是角度范围 [d - angle/2, d + angle/2] 所指示的那片区域。
对于每个点，如果由该点、你的位置以及从你的位置直接向东的方向形成的角度 位于你的视野中 ，那么你就可以看到它。
同一个坐标上可以有多个点。你所在的位置也可能存在一些点，但不管你的怎么旋转，总是可以看到这些点。同时，点不会阻碍你看到其他点。
返回你能看到的点的最大数目。
提示：
1 <= points.length <= 10^5
points[i].length == 2
location.length == 2
0 <= angle < 360
0 <= posx, posy, xi, yi <= 100

先求出每个点相对于 location 的方向角，再用滑动窗口求解。
官方题解: https://leetcode.cn/problems/maximum-number-of-visible-points/solution/you-xiao-ke-jian-dian-de-zui-da-shu-mu-b-r1qz/
时间复杂度 O(nlogn)，其中 n 为坐标的个数，由于需要对所有的极角进行排序，利用移动指针区间查找的时间复杂度为 O(2n+2n)，因此总的时间复杂度应该为 O(nlogn+2n+2n)=O(nlogn)。
空间复杂度 O(n)，其中 n 为坐标的个数，我们总共最多需要两倍坐标个数的空间来存储坐标的极角。
 */