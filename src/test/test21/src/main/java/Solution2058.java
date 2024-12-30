import java.util.ArrayList;
import java.util.List;

public class Solution2058 {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        // 转数组
        int[] listNode = toArray(head);
        if (listNode.length < 4) {
            return new int[]{-1, -1};
        }

        // 找出所有 临界点 下标
        List<Integer> points = new ArrayList<>();
        for (int i = 1; i < listNode.length - 1; i++) {
            if ((listNode[i] > listNode[i - 1] && listNode[i] > listNode[i + 1])
                    || (listNode[i] < listNode[i - 1] && listNode[i] < listNode[i + 1])) {
                points.add(i);
            }
        }
        int len = points.size();
        if (len < 2) {
            return new int[]{-1, -1};
        }

        // 找出 最小和最大距离
        int minDistance = Integer.MAX_VALUE;
        int maxDistance = points.get(len - 1) - points.get(0);
        for (int i = 1; i < len; i++) {
            minDistance = Math.min(minDistance, points.get(i) - points.get(i - 1));
        }
        return new int[]{minDistance, maxDistance};
    }

    private int[] toArray(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}
/*
2058. 找出临界点之间的最小和最大距离
https://leetcode.cn/problems/find-the-minimum-and-maximum-number-of-nodes-between-critical-points/

第 265 场周赛 T2。

链表中的 临界点 定义为一个 局部极大值点 或 局部极小值点 。
如果当前节点的值 严格大于 前一个节点和后一个节点，那么这个节点就是一个 局部极大值点 。
如果当前节点的值 严格小于 前一个节点和后一个节点，那么这个节点就是一个 局部极小值点 。
注意：节点只有在同时存在前一个节点和后一个节点的情况下，才能成为一个 局部极大值点 / 极小值点 。
给你一个链表 head ，返回一个长度为 2 的数组 [minDistance, maxDistance] ，其中 minDistance 是任意两个不同临界点之间的最小距离，
maxDistance 是任意两个不同临界点之间的最大距离。如果临界点少于两个，则返回 [-1，-1] 。
提示：
链表中节点的数量在范围 [2, 10^5] 内
1 <= Node.val <= 10^5

扫描一遍，找出所有 临界点 下标。
扫描所有 临界点 下标，找出 最小和最大距离。
 */