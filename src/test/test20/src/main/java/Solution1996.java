import java.util.Arrays;

public class Solution1996 {
    public int numberOfWeakCharacters(int[][] properties) {
        // 攻击降序，防御升序
        Arrays.sort(properties, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return Integer.compare(o1[1], o2[1]);
            }
            return Integer.compare(o2[0], o1[0]);
        });

        int maxDefense = properties[0][1];
        int cnt = 0;
        for (int i = 1; i < properties.length; i++) {
            if (properties[i][1] < maxDefense) {
                cnt++;
            } else {
                maxDefense = properties[i][1];
            }
        }
        return cnt;
    }
}
/*
1996. 游戏中弱角色的数量
https://leetcode.cn/problems/the-number-of-weak-characters-in-the-game/

第 257 场周赛 T2。

你正在参加一个多角色游戏，每个角色都有两个主要属性：攻击 和 防御 。给你一个二维整数数组 properties ，
其中 properties[i] = [attacki, defensei] 表示游戏中第 i 个角色的属性。
如果存在一个其他角色的攻击和防御等级 都严格高于 该角色的攻击和防御等级，则认为该角色为 弱角色 。
更正式地，如果认为角色 i 弱于 存在的另一个角色 j ，那么 attackj > attacki 且 defensej > defensei 。
返回 弱角色 的数量。
提示：
2 <= properties.length <= 10^5
properties[i].length == 2
1 <= attacki, defensei <= 10^5

1.先按照攻击从大到小排序，相同攻击的再按照防御从小到大排序。
2.遍历数组，维护遍历过的角色的防御的最大值 maxDefense。
3.对于当前角色 p，如果 p 的防御小于 maxDefense，假设其角色为 q。
由于角色按照攻击从大到小排序，假设 p 的攻击等于 q 的攻击，则 p 的防御不可能小于 maxDefense，说明 q 的攻防都大于 p，所以 p 为弱角色。
 */