import java.util.Map;
import java.util.TreeMap;

public class SolutionP1634 {
    public PolyNode addPoly(PolyNode poly1, PolyNode poly2) {
        // <K,V> <power, coefficient>
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        while (poly1 != null) {
            treeMap.put(poly1.power, treeMap.getOrDefault(poly1.power, 0) + poly1.coefficient);
            poly1 = poly1.next;
        }
        while (poly2 != null) {
            treeMap.put(poly2.power, treeMap.getOrDefault(poly2.power, 0) + poly2.coefficient);
            poly2 = poly2.next;
        }

        // 重建 PolyNode
        PolyNode dummy = new PolyNode();
        PolyNode head = dummy;
        while (treeMap.size() > 0) {
            Map.Entry<Integer, Integer> entry = treeMap.pollLastEntry();
            if (entry.getValue() == 0) {
                continue;
            }
            head.next = new PolyNode(entry.getValue(), entry.getKey());
            head = head.next;
        }
        return dummy.next;
    }

    static class PolyNode {
        int coefficient, power;
        PolyNode next = null;

        // fastjson
        public int getCoefficient() {
            return coefficient;
        }

        public int getPower() {
            return power;
        }

        public PolyNode getNext() {
            return next;
        }

        PolyNode() {
        }

        PolyNode(int x, int y) {
            this.coefficient = x;
            this.power = y;
        }

        PolyNode(int x, int y, PolyNode next) {
            this.coefficient = x;
            this.power = y;
            this.next = next;
        }
    }
}
/*
$1634. 求两个多项式链表的和
https://leetcode.cn/problems/add-two-polynomials-represented-as-linked-lists/

多项式链表是一种特殊形式的链表，每个节点表示多项式的一项。
每个节点有三个属性：
- coefficient：该项的系数。项 9x4 的系数是 9 。
- power：该项的指数。项 9x4 的指数是 4 。
- next：指向下一个节点的指针（引用），如果当前节点为链表的最后一个节点则为 null 。
例如，多项式 5x3 + 4x - 7 可以表示成如下图所示的多项式链表：
多项式链表必须是标准形式的，即多项式必须 严格 按指数 power 的递减顺序排列（即降幂排列）。另外，系数 coefficient 为 0 的项需要省略。
给定两个多项式链表的头节点 poly1 和 poly2，返回它们的和的头节点。
PolyNode 格式：
输入/输出格式表示为 n 个节点的列表，其中每个节点表示为 [coefficient, power] 。例如，多项式 5x3 + 4x - 7 表示为： [[5,3],[4,1],[-7,0]] 。
提示：
0 <= n <= 10^4
-10^9 <= PolyNode.coefficient <= 10^9
PolyNode.coefficient != 0
0 <= PolyNode.power <= 10^9
PolyNode.power > PolyNode.next.power

模拟。指数由低到高，可用 TreeMap 进行模拟。
时间复杂度 O(nlogn) 为排序时间复杂度
相似题目: 21. 合并两个有序链表
https://leetcode.cn/problems/merge-two-sorted-lists/
 */